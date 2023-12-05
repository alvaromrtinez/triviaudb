package com.gatonaranja.triviaudb

import com.google.firebase.crashlytics.FirebaseCrashlytics

fun log(tag: String, message: String){

    FirebaseCrashlytics.getInstance().setCustomKey(tag, message)
}