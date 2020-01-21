package com.dev.tennisgame.utilities

class GameConstant {
    companion object {
        const val FORTY = "Forty"
        const val THIRTY = "Thirty"
        const val FIFTEEN = "Fifteen"
        const val LOVE = "Love"
        const val ALL = "all"
        const val FOUR_POINT = 4
        const val THREE_POINT = 3
        const val TWO_POINT = 2
        const val ONE_POINT = 1
        const val WON_THE_GAME = "won the game!"
        const val DEUCE = "Deuce"
        const val ADVANTAGE = "Advantage"
        const val EXCLAMATION = "!"
        private const val ILLEGAL_SCORE = "Illegal score:"

        fun illegalScore(score: Int): String{
            return "$ILLEGAL_SCORE $score"
        }
    }
}