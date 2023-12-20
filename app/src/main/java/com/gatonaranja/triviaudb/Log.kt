package com.gatonaranja.triviaudb

import androidx.annotation.Keep
import com.google.firebase.crashlytics.FirebaseCrashlytics

@Keep fun log(tag: String, message: String){

    FirebaseCrashlytics.getInstance().setCustomKey(tag, message)
}