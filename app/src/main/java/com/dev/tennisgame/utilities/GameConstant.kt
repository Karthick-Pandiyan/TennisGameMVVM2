package com.dev.tennisgame.utilities

class GameConstant {
    companion object {
        const val FORTY = "Forty"
        const val THIRTY = "Thirty"
        const val FIFTEEN = "Fifteen"
        const val LOVE = "Love"

        fun illegalScore(score: Int): String{
            return "Illegal score: $score"
        }
    }
}