package com.gatonaranja.triviaudb

import android.content.Context

object Questions {
    fun getQuestions(context: Context): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val questionMatrix: Array<Array<String>> = arrayOf(
            arrayOf(context.getString(R.string.que1_String), context.getString(R.string.que1_op1_String) ,context.getString(R.string.que1_op2_String),context.getString(R.string.que1_op3_String),context.getString(R.string.que1_op4_String), context.getString(R.string.que1_feedback_String)),
            arrayOf(context.getString(R.string.que2_String), context.getString(R.string.que2_op1_String) ,context.getString(R.string.que2_op2_String),context.getString(R.string.que2_op3_String),context.getString(R.string.que2_op4_String), context.getString(R.string.que2_feedback_String)),
            arrayOf(context.getString(R.string.que3_String), context.getString(R.string.que3_op1_String) ,context.getString(R.string.que3_op2_String),context.getString(R.string.que3_op3_String),context.getString(R.string.que3_op4_String), context.getString(R.string.que3_feedback_String)),
            arrayOf(context.getString(R.string.que4_String), context.getString(R.string.que4_op1_String) ,context.getString(R.string.que4_op2_String),context.getString(R.string.que4_op3_String),context.getString(R.string.que4_op4_String), context.getString(R.string.que4_feedback_String)),
            arrayOf(context.getString(R.string.que5_String), context.getString(R.string.que5_op1_String) ,context.getString(R.string.que5_op2_String),context.getString(R.string.que5_op3_String),context.getString(R.string.que5_op4_String), context.getString(R.string.que5_feedback_String)),
            arrayOf(context.getString(R.string.que6_String), context.getString(R.string.que6_op1_String) ,context.getString(R.string.que6_op2_String),context.getString(R.string.que6_op3_String),context.getString(R.string.que6_op4_String), context.getString(R.string.que6_feedback_String)),
            arrayOf(context.getString(R.string.que7_String), context.getString(R.string.que7_op1_String) ,context.getString(R.string.que7_op2_String),context.getString(R.string.que7_op3_String),context.getString(R.string.que7_op4_String), context.getString(R.string.que7_feedback_String)),
            arrayOf(context.getString(R.string.que8_String), context.getString(R.string.que8_op1_String) ,context.getString(R.string.que8_op2_String),context.getString(R.string.que8_op3_String),context.getString(R.string.que8_op4_String), context.getString(R.string.que8_feedback_String)),
            arrayOf(context.getString(R.string.que9_String), context.getString(R.string.que9_op1_String) ,context.getString(R.string.que9_op2_String),context.getString(R.string.que9_op3_String),context.getString(R.string.que9_op4_String), context.getString(R.string.que9_feedback_String)),
            arrayOf(context.getString(R.string.que10_String), context.getString(R.string.que10_op1_String) ,context.getString(R.string.que10_op2_String),context.getString(R.string.que10_op3_String),context.getString(R.string.que10_op4_String), context.getString(R.string.que10_feedback_String)),
            arrayOf(context.getString(R.string.que11_String), context.getString(R.string.que11_op1_String) ,context.getString(R.string.que11_op2_String),context.getString(R.string.que11_op3_String),context.getString(R.string.que11_op4_String), context.getString(R.string.que11_feedback_String)),
            arrayOf(context.getString(R.string.que12_String), context.getString(R.string.que12_op1_String) ,context.getString(R.string.que12_op2_String),context.getString(R.string.que12_op3_String),context.getString(R.string.que12_op4_String), context.getString(R.string.que12_feedback_String)),
            arrayOf(context.getString(R.string.que13_String), context.getString(R.string.que13_op1_String) ,context.getString(R.string.que13_op2_String),context.getString(R.string.que13_op3_String),context.getString(R.string.que13_op4_String), context.getString(R.string.que13_feedback_String)),
            arrayOf(context.getString(R.string.que14_String), context.getString(R.string.que14_op1_String) ,context.getString(R.string.que14_op2_String),context.getString(R.string.que14_op3_String),context.getString(R.string.que14_op4_String), context.getString(R.string.que14_feedback_String)),
            arrayOf(context.getString(R.string.que15_String), context.getString(R.string.que15_op1_String) ,context.getString(R.string.que15_op2_String),context.getString(R.string.que15_op3_String),context.getString(R.string.que15_op4_String), context.getString(R.string.que15_feedback_String)),
            arrayOf(context.getString(R.string.que16_String), context.getString(R.string.que16_op1_String) ,context.getString(R.string.que16_op2_String),context.getString(R.string.que16_op3_String),context.getString(R.string.que16_op4_String), context.getString(R.string.que16_feedback_String)),
            arrayOf(context.getString(R.string.que17_String), context.getString(R.string.que17_op1_String) ,context.getString(R.string.que17_op2_String),context.getString(R.string.que17_op3_String),context.getString(R.string.que17_op4_String), context.getString(R.string.que17_feedback_String)),
            arrayOf(context.getString(R.string.que18_String), context.getString(R.string.que18_op1_String) ,context.getString(R.string.que18_op2_String),context.getString(R.string.que18_op3_String),context.getString(R.string.que18_op4_String), context.getString(R.string.que18_feedback_String)),
            arrayOf(context.getString(R.string.que19_String), context.getString(R.string.que19_op1_String) ,context.getString(R.string.que19_op2_String),context.getString(R.string.que19_op3_String),context.getString(R.string.que19_op4_String), context.getString(R.string.que19_feedback_String)),
            arrayOf(context.getString(R.string.que20_String), context.getString(R.string.que20_op1_String) ,context.getString(R.string.que20_op2_String),context.getString(R.string.que20_op3_String),context.getString(R.string.que20_op4_String), context.getString(R.string.que20_feedback_String)),
            arrayOf(context.getString(R.string.que21_String), context.getString(R.string.que21_op1_String) ,context.getString(R.string.que21_op2_String),context.getString(R.string.que21_op3_String),context.getString(R.string.que21_op4_String), context.getString(R.string.que21_feedback_String)),
            arrayOf(context.getString(R.string.que22_String), context.getString(R.string.que22_op1_String) ,context.getString(R.string.que22_op2_String),context.getString(R.string.que22_op3_String),context.getString(R.string.que22_op4_String), context.getString(R.string.que22_feedback_String)),
            arrayOf(context.getString(R.string.que23_String), context.getString(R.string.que23_op1_String) ,context.getString(R.string.que23_op2_String),context.getString(R.string.que23_op3_String),context.getString(R.string.que23_op4_String), context.getString(R.string.que23_feedback_String)),
            arrayOf(context.getString(R.string.que24_String), context.getString(R.string.que24_op1_String) ,context.getString(R.string.que24_op2_String),context.getString(R.string.que24_op3_String),context.getString(R.string.que24_op4_String), context.getString(R.string.que24_feedback_String)),
            arrayOf(context.getString(R.string.que25_String), context.getString(R.string.que25_op1_String) ,context.getString(R.string.que25_op2_String),context.getString(R.string.que25_op3_String),context.getString(R.string.que25_op4_String), context.getString(R.string.que25_feedback_String)),
            arrayOf(context.getString(R.string.que26_String), context.getString(R.string.que26_op1_String) ,context.getString(R.string.que26_op2_String),context.getString(R.string.que26_op3_String),context.getString(R.string.que26_op4_String), context.getString(R.string.que26_feedback_String)),
            arrayOf(context.getString(R.string.que27_String), context.getString(R.string.que27_op1_String) ,context.getString(R.string.que27_op2_String),context.getString(R.string.que27_op3_String),context.getString(R.string.que27_op4_String), context.getString(R.string.que27_feedback_String)),
            arrayOf(context.getString(R.string.que28_String), context.getString(R.string.que28_op1_String) ,context.getString(R.string.que28_op2_String),context.getString(R.string.que28_op3_String),context.getString(R.string.que28_op4_String), context.getString(R.string.que28_feedback_String)),
            arrayOf(context.getString(R.string.que29_String), context.getString(R.string.que29_op1_String) ,context.getString(R.string.que29_op2_String),context.getString(R.string.que29_op3_String),context.getString(R.string.que29_op4_String), context.getString(R.string.que29_feedback_String)),
            arrayOf(context.getString(R.string.que30_String), context.getString(R.string.que30_op1_String) ,context.getString(R.string.que30_op2_String),context.getString(R.string.que30_op3_String),context.getString(R.string.que30_op4_String), context.getString(R.string.que30_feedback_String)),
            arrayOf(context.getString(R.string.que31_String), context.getString(R.string.que31_op1_String) ,context.getString(R.string.que31_op2_String),context.getString(R.string.que31_op3_String),context.getString(R.string.que31_op4_String), context.getString(R.string.que31_feedback_String)),
            arrayOf(context.getString(R.string.que32_String), context.getString(R.string.que32_op1_String) ,context.getString(R.string.que32_op2_String),context.getString(R.string.que32_op3_String),context.getString(R.string.que32_op4_String), context.getString(R.string.que32_feedback_String)),
            arrayOf(context.getString(R.string.que33_String), context.getString(R.string.que33_op1_String) ,context.getString(R.string.que33_op2_String),context.getString(R.string.que33_op3_String),context.getString(R.string.que33_op4_String), context.getString(R.string.que33_feedback_String)),
            arrayOf(context.getString(R.string.que34_String), context.getString(R.string.que34_op1_String) ,context.getString(R.string.que34_op2_String),context.getString(R.string.que34_op3_String),context.getString(R.string.que34_op4_String), context.getString(R.string.que34_feedback_String)),
            arrayOf(context.getString(R.string.que35_String), context.getString(R.string.que35_op1_String) ,context.getString(R.string.que35_op2_String),context.getString(R.string.que35_op3_String),context.getString(R.string.que35_op4_String), context.getString(R.string.que35_feedback_String)),
            arrayOf(context.getString(R.string.que36_String), context.getString(R.string.que36_op1_String) ,context.getString(R.string.que36_op2_String),context.getString(R.string.que36_op3_String),context.getString(R.string.que36_op4_String), context.getString(R.string.que36_feedback_String)),
            arrayOf(context.getString(R.string.que37_String), context.getString(R.string.que37_op1_String) ,context.getString(R.string.que37_op2_String),context.getString(R.string.que37_op3_String),context.getString(R.string.que37_op4_String), context.getString(R.string.que37_feedback_String)),
            arrayOf(context.getString(R.string.que38_String), context.getString(R.string.que38_op1_String) ,context.getString(R.string.que38_op2_String),context.getString(R.string.que38_op3_String),context.getString(R.string.que38_op4_String), context.getString(R.string.que38_feedback_String)),
            arrayOf(context.getString(R.string.que39_String), context.getString(R.string.que39_op1_String) ,context.getString(R.string.que39_op2_String),context.getString(R.string.que39_op3_String),context.getString(R.string.que39_op4_String), context.getString(R.string.que39_feedback_String)),
            arrayOf(context.getString(R.string.que40_String), context.getString(R.string.que40_op1_String) ,context.getString(R.string.que40_op2_String),context.getString(R.string.que40_op3_String),context.getString(R.string.que40_op4_String), context.getString(R.string.que40_feedback_String)),
            arrayOf(context.getString(R.string.que41_String), context.getString(R.string.que41_op1_String) ,context.getString(R.string.que41_op2_String),context.getString(R.string.que41_op3_String),context.getString(R.string.que41_op4_String), context.getString(R.string.que41_feedback_String)),
            arrayOf(context.getString(R.string.que42_String), context.getString(R.string.que42_op1_String) ,context.getString(R.string.que42_op2_String),context.getString(R.string.que42_op3_String),context.getString(R.string.que42_op4_String), context.getString(R.string.que42_feedback_String)),
            arrayOf(context.getString(R.string.que43_String), context.getString(R.string.que43_op1_String) ,context.getString(R.string.que43_op2_String),context.getString(R.string.que43_op3_String),context.getString(R.string.que43_op4_String), context.getString(R.string.que43_feedback_String)),
            arrayOf(context.getString(R.string.que44_String), context.getString(R.string.que44_op1_String) ,context.getString(R.string.que44_op2_String),context.getString(R.string.que44_op3_String),context.getString(R.string.que44_op4_String), context.getString(R.string.que44_feedback_String)),
            arrayOf(context.getString(R.string.que45_String), context.getString(R.string.que45_op1_String) ,context.getString(R.string.que45_op2_String),context.getString(R.string.que45_op3_String),context.getString(R.string.que45_op4_String), context.getString(R.string.que45_feedback_String)),
            arrayOf(context.getString(R.string.que46_String), context.getString(R.string.que46_op1_String) ,context.getString(R.string.que46_op2_String),context.getString(R.string.que46_op3_String),context.getString(R.string.que46_op4_String), context.getString(R.string.que46_feedback_String)),
            arrayOf(context.getString(R.string.que47_String), context.getString(R.string.que47_op1_String) ,context.getString(R.string.que47_op2_String),context.getString(R.string.que47_op3_String),context.getString(R.string.que47_op4_String), context.getString(R.string.que47_feedback_String)),
            arrayOf(context.getString(R.string.que48_String), context.getString(R.string.que48_op1_String) ,context.getString(R.string.que48_op2_String),context.getString(R.string.que48_op3_String),context.getString(R.string.que48_op4_String), context.getString(R.string.que48_feedback_String)),
            arrayOf(context.getString(R.string.que49_String), context.getString(R.string.que49_op1_String) ,context.getString(R.string.que49_op2_String),context.getString(R.string.que49_op3_String),context.getString(R.string.que49_op4_String), context.getString(R.string.que49_feedback_String)),
            arrayOf(context.getString(R.string.que50_String), context.getString(R.string.que50_op1_String) ,context.getString(R.string.que50_op2_String),context.getString(R.string.que50_op3_String),context.getString(R.string.que50_op4_String), context.getString(R.string.que50_feedback_String)),
            arrayOf(context.getString(R.string.que51_String), context.getString(R.string.que51_op1_String) ,context.getString(R.string.que51_op2_String),context.getString(R.string.que51_op3_String),context.getString(R.string.que51_op4_String), context.getString(R.string.que51_feedback_String)),
            arrayOf(context.getString(R.string.que52_String), context.getString(R.string.que52_op1_String) ,context.getString(R.string.que52_op2_String),context.getString(R.string.que52_op3_String),context.getString(R.string.que52_op4_String), context.getString(R.string.que52_feedback_String)),
            arrayOf(context.getString(R.string.que53_String), context.getString(R.string.que53_op1_String) ,context.getString(R.string.que53_op2_String),context.getString(R.string.que53_op3_String),context.getString(R.string.que53_op4_String), context.getString(R.string.que53_feedback_String)),
            arrayOf(context.getString(R.string.que54_String), context.getString(R.string.que54_op1_String) ,context.getString(R.string.que54_op2_String),context.getString(R.string.que54_op3_String),context.getString(R.string.que54_op4_String), context.getString(R.string.que54_feedback_String)),
            arrayOf(context.getString(R.string.que55_String), context.getString(R.string.que55_op1_String) ,context.getString(R.string.que55_op2_String),context.getString(R.string.que55_op3_String),context.getString(R.string.que55_op4_String), context.getString(R.string.que55_feedback_String)),
            arrayOf(context.getString(R.string.que56_String), context.getString(R.string.que56_op1_String) ,context.getString(R.string.que56_op2_String),context.getString(R.string.que56_op3_String),context.getString(R.string.que56_op4_String), context.getString(R.string.que56_feedback_String)),
            arrayOf(context.getString(R.string.que57_String), context.getString(R.string.que57_op1_String) ,context.getString(R.string.que57_op2_String),context.getString(R.string.que57_op3_String),context.getString(R.string.que57_op4_String), context.getString(R.string.que57_feedback_String)),
            arrayOf(context.getString(R.string.que58_String), context.getString(R.string.que58_op1_String) ,context.getString(R.string.que58_op2_String),context.getString(R.string.que58_op3_String),context.getString(R.string.que58_op4_String), context.getString(R.string.que58_feedback_String)),
            arrayOf(context.getString(R.string.que59_String), context.getString(R.string.que59_op1_String) ,context.getString(R.string.que59_op2_String),context.getString(R.string.que59_op3_String),context.getString(R.string.que59_op4_String), context.getString(R.string.que59_feedback_String)),
            arrayOf(context.getString(R.string.que60_String), context.getString(R.string.que60_op1_String) ,context.getString(R.string.que60_op2_String),context.getString(R.string.que60_op3_String),context.getString(R.string.que60_op4_String), context.getString(R.string.que60_feedback_String)),
            arrayOf(context.getString(R.string.que61_String), context.getString(R.string.que61_op1_String) ,context.getString(R.string.que61_op2_String),context.getString(R.string.que61_op3_String),context.getString(R.string.que61_op4_String), context.getString(R.string.que61_feedback_String)),
            /*arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que70_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que80_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que90_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),
            arrayOf(context.getString(R.string.que00_String), context.getString(R.string.que00_op1_String) ,context.getString(R.string.que00_op2_String),context.getString(R.string.que00_op3_String),context.getString(R.string.que00_op4_String), context.getString(R.string.que00_feedback_String)),*/
        )
        //    0           0          0         0          0          0
        //    1           1          1         1         1           1
        val que1 = Question (
            1,
            questionMatrix[0][0],
            questionMatrix[0][1],
            questionMatrix[0][2],
            questionMatrix[0][3],
            questionMatrix[0][4],
            questionMatrix[0][5],
            1,
            1
        )
        questionsList.add(que1)

        val que2 = Question (
            2,
            questionMatrix[1][0],
            questionMatrix[1][1],
            questionMatrix[1][2],
            questionMatrix[1][3],
            questionMatrix[1][4],
            questionMatrix[1][5],
            1,
            3
        )
        questionsList.add(que2)

        val que3 = Question (
            3,
            questionMatrix[2][0],
            questionMatrix[2][1],
            questionMatrix[2][2],
            questionMatrix[2][3],
            questionMatrix[2][4],
            questionMatrix[2][5],
            1,
            2
        )
        questionsList.add(que3)

        val que4 = Question (
            4,
            questionMatrix[3][0],
            questionMatrix[3][1],
            questionMatrix[3][2],
            questionMatrix[3][3],
            questionMatrix[3][4],
            questionMatrix[3][5],
            1,
            2
        )
        questionsList.add(que4)

        val que5 = Question (
            5,
            questionMatrix[4][0],
            questionMatrix[4][1],
            questionMatrix[4][2],
            questionMatrix[4][3],
            questionMatrix[4][4],
            questionMatrix[4][5],
            1,
            4

        )
        questionsList.add(que5)

        val que6 = Question (
            6,
            questionMatrix[5][0],
            questionMatrix[5][1],
            questionMatrix[5][2],
            questionMatrix[5][3],
            questionMatrix[5][4],
            questionMatrix[5][5],
            1,
            1
        )
        questionsList.add(que6)

        val que7 = Question (
            7,
            questionMatrix[6][0],
            questionMatrix[6][1],
            questionMatrix[6][2],
            questionMatrix[6][3],
            questionMatrix[6][4],
            questionMatrix[6][5],
            1,
            3
        )
        questionsList.add(que7)

        val que8 = Question (
            8,
            questionMatrix[7][0],
            questionMatrix[7][1],
            questionMatrix[7][2],
            questionMatrix[7][3],
            questionMatrix[7][4],
            questionMatrix[7][5],
            1,
            1
        )
        questionsList.add(que8)

        val que9 = Question (
            9,
            questionMatrix[8][0],
            questionMatrix[8][1],
            questionMatrix[8][2],
            questionMatrix[8][3],
            questionMatrix[8][4],
            questionMatrix[8][5],
            1,
            3
        )
        questionsList.add(que9)

        val que10 = Question (
            10,
            questionMatrix[9][0],
            questionMatrix[9][1],
            questionMatrix[9][2],
            questionMatrix[9][3],
            questionMatrix[9][4],
            questionMatrix[9][5],
            1,
            4

        )
        questionsList.add(que10)

        //11 AL 20

        val que11 = Question (
            11,
            questionMatrix[10][0],
            questionMatrix[10][1],
            questionMatrix[10][2],
            questionMatrix[10][3],
            questionMatrix[10][4],
            questionMatrix[10][5],
            1,
            4

        )
        questionsList.add(que11)

        val que12 = Question (
            12,
            questionMatrix[11][0],
            questionMatrix[11][1],
            questionMatrix[11][2],
            questionMatrix[11][3],
            questionMatrix[11][4],
            questionMatrix[11][5],
            1,
            1

        )
        questionsList.add(que12)

        val que13 = Question (
            13,
            questionMatrix[12][0],
            questionMatrix[12][1],
            questionMatrix[12][2],
            questionMatrix[12][3],
            questionMatrix[12][4],
            questionMatrix[12][5],
            1,
            1
        )
        questionsList.add(que13)

        val que14 = Question (
            14,
            questionMatrix[13][0],
            questionMatrix[13][1],
            questionMatrix[13][2],
            questionMatrix[13][3],
            questionMatrix[13][4],
            questionMatrix[13][5],
            1,
            3
        )
        questionsList.add(que14)

        val que15 = Question (
            15,
            questionMatrix[14][0],
            questionMatrix[14][1],
            questionMatrix[14][2],
            questionMatrix[14][3],
            questionMatrix[14][4],
            questionMatrix[14][5],
            1,
            3
        )
        questionsList.add(que15)

        val que16 = Question (
            16,
            questionMatrix[15][0],
            questionMatrix[15][1],
            questionMatrix[15][2],
            questionMatrix[15][3],
            questionMatrix[15][4],
            questionMatrix[15][5],
            1,
            4
        )
        questionsList.add(que16)

        val que17 = Question (
            17,
            questionMatrix[16][0],
            questionMatrix[16][1],
            questionMatrix[16][2],
            questionMatrix[16][3],
            questionMatrix[16][4],
            questionMatrix[16][5],
            1,
            2
        )
        questionsList.add(que17)

        val que18 = Question (
            18,
            questionMatrix[17][0],
            questionMatrix[17][1],
            questionMatrix[17][2],
            questionMatrix[17][3],
            questionMatrix[17][4],
            questionMatrix[17][5],
            1,
            4
        )
        questionsList.add(que18)

        val que19 = Question (
            19,
            questionMatrix[18][0],
            questionMatrix[18][1],
            questionMatrix[18][2],
            questionMatrix[18][3],
            questionMatrix[18][4],
            questionMatrix[18][5],
            1,
            3
        )
        questionsList.add(que19)

        val que20 = Question (
            20,
            questionMatrix[19][0],
            questionMatrix[19][1],
            questionMatrix[19][2],
            questionMatrix[19][3],
            questionMatrix[19][4],
            questionMatrix[19][5],
            1,
            2
        )
        questionsList.add(que20)

// 20 AL 29
        val que21 = Question (
            21,
            questionMatrix[20][0],
            questionMatrix[20][1],
            questionMatrix[20][2],
            questionMatrix[20][3],
            questionMatrix[20][4],
            questionMatrix[20][5],
            1,
            3
        )
        questionsList.add(que21)

        val que22 = Question (
            22,
            questionMatrix[21][0],
            questionMatrix[21][1],
            questionMatrix[21][2],
            questionMatrix[21][3],
            questionMatrix[21][4],
            questionMatrix[21][5],
            1,
            2
        )
        questionsList.add(que22)

        val que23 = Question (
            23,
            questionMatrix[22][0],
            questionMatrix[22][1],
            questionMatrix[22][2],
            questionMatrix[22][3],
            questionMatrix[22][4],
            questionMatrix[22][5],
            1,
            2
        )
        questionsList.add(que23)

        val que24 = Question (
            24,
            questionMatrix[23][0],
            questionMatrix[23][1],
            questionMatrix[23][2],
            questionMatrix[23][3],
            questionMatrix[23][4],
            questionMatrix[23][5],
            1,
            3
        )
        questionsList.add(que24)

        val que25 = Question (
            25,
            questionMatrix[24][0],
            questionMatrix[24][1],
            questionMatrix[24][2],
            questionMatrix[24][3],
            questionMatrix[24][4],
            questionMatrix[24][5],
            1,
            1
        )
        questionsList.add(que25)

        val que26 = Question (
            26,
            questionMatrix[25][0],
            questionMatrix[25][1],
            questionMatrix[25][2],
            questionMatrix[25][3],
            questionMatrix[25][4],
            questionMatrix[25][5],
            1,
            2
        )
        questionsList.add(que26)

        val que27 = Question (
            27,
            questionMatrix[26][0],
            questionMatrix[26][1],
            questionMatrix[26][2],
            questionMatrix[26][3],
            questionMatrix[26][4],
            questionMatrix[26][5],
            1,
            2
        )
        questionsList.add(que27)

        val que28 = Question (
            28,
            questionMatrix[27][0],
            questionMatrix[27][1],
            questionMatrix[27][2],
            questionMatrix[27][3],
            questionMatrix[27][4],
            questionMatrix[27][5],
            1,
            4
        )
        questionsList.add(que28)

        val que29 = Question (
            29,
            questionMatrix[28][0],
            questionMatrix[28][1],
            questionMatrix[28][2],
            questionMatrix[28][3],
            questionMatrix[28][4],
            questionMatrix[28][5],
            1,
            4
        )
        questionsList.add(que29)

        val que30 = Question (
            30,
            questionMatrix[29][0],
            questionMatrix[29][1],
            questionMatrix[29][2],
            questionMatrix[29][3],
            questionMatrix[29][4],
            questionMatrix[29][5],
            1,
            4
        )
        questionsList.add(que30)

        //31 a 40
        val que31 = Question (
            31,
            questionMatrix[30][0],
            questionMatrix[30][1],
            questionMatrix[30][2],
            questionMatrix[30][3],
            questionMatrix[30][4],
            questionMatrix[30][5],
            2,
            2
        )
        questionsList.add(que31)

        val que32 = Question (
            32,
            questionMatrix[31][0],
            questionMatrix[31][1],
            questionMatrix[31][2],
            questionMatrix[31][3],
            questionMatrix[31][4],
            questionMatrix[31][5],
            2,
            2
        )
        questionsList.add(que32)

        val que33 = Question (
            33,
            questionMatrix[32][0],
            questionMatrix[32][1],
            questionMatrix[32][2],
            questionMatrix[32][3],
            questionMatrix[32][4],
            questionMatrix[32][5],
            2,
            1
        )
        questionsList.add(que33)

        val que34 = Question (
            34,
            questionMatrix[33][0],
            questionMatrix[33][1],
            questionMatrix[33][2],
            questionMatrix[33][3],
            questionMatrix[33][4],
            questionMatrix[33][5],
            2,
            3
        )
        questionsList.add(que34)

        val que35 = Question (
            35,
            questionMatrix[34][0],
            questionMatrix[34][1],
            questionMatrix[34][2],
            questionMatrix[34][3],
            questionMatrix[34][4],
            questionMatrix[34][5],
            2,
            1
        )
        questionsList.add(que35)

        val que36 = Question (
            36,
            questionMatrix[35][0],
            questionMatrix[35][1],
            questionMatrix[35][2],
            questionMatrix[35][3],
            questionMatrix[35][4],
            questionMatrix[35][5],
            2,
            3
        )
        questionsList.add(que36)

        val que37 = Question (
            37,
            questionMatrix[36][0],
            questionMatrix[36][1],
            questionMatrix[36][2],
            questionMatrix[36][3],
            questionMatrix[36][4],
            questionMatrix[36][5],
            2,
            2
        )
        questionsList.add(que37)

        val que38 = Question (
            38,
            questionMatrix[37][0],
            questionMatrix[37][1],
            questionMatrix[37][2],
            questionMatrix[37][3],
            questionMatrix[37][4],
            questionMatrix[37][5],
            2,
            1
        )
        questionsList.add(que38)

        val que39 = Question (
            39,
            questionMatrix[38][0],
            questionMatrix[38][1],
            questionMatrix[38][2],
            questionMatrix[38][3],
            questionMatrix[38][4],
            questionMatrix[38][5],
            2,
            4
        )
        questionsList.add(que39)

        val que40 = Question (
            40,
            questionMatrix[39][0],
            questionMatrix[39][1],
            questionMatrix[39][2],
            questionMatrix[39][3],
            questionMatrix[39][4],
            questionMatrix[39][5],
            2,
            3
        )
        questionsList.add(que40)

        //41-50
        val que41 = Question (
            41,
            questionMatrix[40][0],
            questionMatrix[40][1],
            questionMatrix[40][2],
            questionMatrix[40][3],
            questionMatrix[40][4],
            questionMatrix[40][5],
            2,
            3
        )
        questionsList.add(que41)

        val que42 = Question (
            42,
            questionMatrix[41][0],
            questionMatrix[41][1],
            questionMatrix[41][2],
            questionMatrix[41][3],
            questionMatrix[41][4],
            questionMatrix[41][5],
            2,
            4
        )
        questionsList.add(que42)

        val que43 = Question (
            43,
            questionMatrix[42][0],
            questionMatrix[42][1],
            questionMatrix[42][2],
            questionMatrix[42][3],
            questionMatrix[42][4],
            questionMatrix[42][5],
            2,
            2
        )
        questionsList.add(que43)

        val que44 = Question (
            44,
            questionMatrix[43][0],
            questionMatrix[43][1],
            questionMatrix[43][2],
            questionMatrix[43][3],
            questionMatrix[43][4],
            questionMatrix[43][5],
            2,
            3
        )
        questionsList.add(que44)

        val que45 = Question (
            45,
            questionMatrix[44][0],
            questionMatrix[44][1],
            questionMatrix[44][2],
            questionMatrix[44][3],
            questionMatrix[44][4],
            questionMatrix[44][5],
            2,
            1
        )
        questionsList.add(que45)

        val que46 = Question (
            46,
            questionMatrix[45][0],
            questionMatrix[45][1],
            questionMatrix[45][2],
            questionMatrix[45][3],
            questionMatrix[45][4],
            questionMatrix[45][5],
            2,
            4
        )
        questionsList.add(que46)

        val que47 = Question (
            47,
            questionMatrix[46][0],
            questionMatrix[46][1],
            questionMatrix[46][2],
            questionMatrix[46][3],
            questionMatrix[46][4],
            questionMatrix[46][5],
            2,
            3
        )
        questionsList.add(que47)

        val que48 = Question (
            48,
            questionMatrix[47][0],
            questionMatrix[47][1],
            questionMatrix[47][2],
            questionMatrix[47][3],
            questionMatrix[47][4],
            questionMatrix[47][5],
            2,
            4
        )
        questionsList.add(que48)

        val que49 = Question (
            49,
            questionMatrix[48][0],
            questionMatrix[48][1],
            questionMatrix[48][2],
            questionMatrix[48][3],
            questionMatrix[48][4],
            questionMatrix[48][5],
            2,
            2
        )
        questionsList.add(que49)

        val que50 = Question (
            50,
            questionMatrix[49][0],
            questionMatrix[49][1],
            questionMatrix[49][2],
            questionMatrix[49][3],
            questionMatrix[49][4],
            questionMatrix[49][5],
            2,
            3
        )
        questionsList.add(que50)

        //51-60
        val que51 = Question (
            51,
            questionMatrix[50][0],
            questionMatrix[50][1],
            questionMatrix[50][2],
            questionMatrix[50][3],
            questionMatrix[50][4],
            questionMatrix[50][5],
            3,
            3
        )
        questionsList.add(que51)

        val que52 = Question (
            52,
            questionMatrix[51][0],
            questionMatrix[51][1],
            questionMatrix[51][2],
            questionMatrix[51][3],
            questionMatrix[51][4],
            questionMatrix[51][5],
            2,
            2
        )
        questionsList.add(que52)

        val que53 = Question (
            53,
            questionMatrix[52][0],
            questionMatrix[52][1],
            questionMatrix[52][2],
            questionMatrix[52][3],
            questionMatrix[52][4],
            questionMatrix[52][5],
            3,
            2
        )
        questionsList.add(que53)

        val que54 = Question (
            54,
            questionMatrix[53][0],
            questionMatrix[53][1],
            questionMatrix[53][2],
            questionMatrix[53][3],
            questionMatrix[53][4],
            questionMatrix[53][5],
            3,
            1
        )
        questionsList.add(que54)

        val que55 = Question (
            55,
            questionMatrix[54][0],
            questionMatrix[54][1],
            questionMatrix[54][2],
            questionMatrix[54][3],
            questionMatrix[54][4],
            questionMatrix[54][5],
            3,
            3
        )
        questionsList.add(que55)

        val que56 = Question (
            56,
            questionMatrix[55][0],
            questionMatrix[55][1],
            questionMatrix[55][2],
            questionMatrix[55][3],
            questionMatrix[55][4],
            questionMatrix[55][5],
            3,
            3
        )
        questionsList.add(que56)

        val que57 = Question (
            57,
            questionMatrix[56][0],
            questionMatrix[56][1],
            questionMatrix[56][2],
            questionMatrix[56][3],
            questionMatrix[56][4],
            questionMatrix[56][5],
            2,
            4
        )
        questionsList.add(que57)

        val que58 = Question (
            58,
            questionMatrix[57][0],
            questionMatrix[57][1],
            questionMatrix[57][2],
            questionMatrix[57][3],
            questionMatrix[57][4],
            questionMatrix[57][5],
            2,
            2
        )
        questionsList.add(que48)

        val que59 = Question (
            59,
            questionMatrix[58][0],
            questionMatrix[58][1],
            questionMatrix[58][2],
            questionMatrix[58][3],
            questionMatrix[58][4],
            questionMatrix[58][5],
            2,
            1
        )
        questionsList.add(que59)

        val que60 = Question (
            60,
            questionMatrix[59][0],
            questionMatrix[59][1],
            questionMatrix[59][2],
            questionMatrix[59][3],
            questionMatrix[59][4],
            questionMatrix[59][5],
            2,
            3
        )
        questionsList.add(que60)

        val que61 = Question (
            61,
            questionMatrix[60][0],
            questionMatrix[60][1],
            questionMatrix[60][2],
            questionMatrix[60][3],
            questionMatrix[60][4],
            questionMatrix[60][5],
            4,
            3
        )
        questionsList.add(que61)

        return questionsList
    }


}