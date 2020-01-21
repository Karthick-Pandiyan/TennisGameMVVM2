package com.dev.tennisgame

class TennisGame {

    fun translateToScore(score: Int): String {
        return when (score){
            3 -> "Forty"
            2 -> "Thirty"
            1 -> "Fifteen"
            0 -> "Love"
            else -> "Illegal score: $score"
        }
    }
}