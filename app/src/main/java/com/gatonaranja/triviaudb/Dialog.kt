package com.gatonaranja.triviaudb

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class Dialog : DialogFragment() {
    private val firebaseRemoteConfig by lazy { FirebaseRemoteConfig.getInstance() }
    private var actionDialog: Button? = null
    override fun getTheme() = R.style.RoundedCornersDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onResume() {
        super.onResume()
        /*dialog?.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionDialog = view.findViewById<Button?>(R.id.btn_update).apply {
            setOnClickListener {
                getStoreUrl()
            }
        }
    }

    private fun getStoreUrl() {
        val updateUrl = firebaseRemoteConfig.getString(KEY_FORCE_UPDATE_URL)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity?.startActivity(intent)
    }

    companion object {
        const val KEY_FORCE_UPDATE_URL = "android_force_update_store_url"
    }
}