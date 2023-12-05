package com.gatonaranja.triviaudb

import androidx.annotation.Keep

 data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val feedback: String,
    val sagaID: Int,
    val correctAnswer: Int,
)
