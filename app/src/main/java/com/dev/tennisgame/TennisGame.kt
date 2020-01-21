package com.dev.tennisgame

class TennisGame {

    fun translateToScore(score: Int): String {
        return when (score){
            0 -> "Love"
            else -> "Illegal score: $score"
        }
    }
}