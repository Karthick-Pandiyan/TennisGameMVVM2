package com.dev.tennisgame

import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.GameConstant.Companion.ALL
import com.dev.tennisgame.utilities.GameConstant.Companion.ILLEGAL_SCORE
import com.dev.tennisgame.utilities.GameConstant.Companion.illegalScore
import com.dev.tennisgame.utilities.Score.FORTY
import com.dev.tennisgame.utilities.Score.THIRTY
import com.dev.tennisgame.utilities.Score.FIFTEEN
import com.dev.tennisgame.utilities.Score.LOVE

class TennisGame {

    var playerOneScore: Int = LOVE.value
    var playerTwoScore: Int = LOVE.value


    fun getScore(): String {
        if(isPlayerScoresAreEqual())
            return "${translateToScore(playerOneScore)} $ALL"

        return "${translateToScore(playerOneScore)}, ${translateToScore(playerTwoScore)}"
    }

    fun translateToScore(score: Int): String {
        return when (score){
            FORTY.value -> GameConstant.FORTY
            THIRTY.value -> GameConstant.THIRTY
            FIFTEEN.value -> GameConstant.FIFTEEN
            LOVE.value -> GameConstant.LOVE
            else -> illegalScore(score)
        }
    }

    private fun isPlayerScoresAreEqual() = playerOneScore == playerTwoScore

    fun addScoreToPlayerOne(){
        playerOneScore++
    }

    fun addScoreToPlayerTwo(){
        playerTwoScore++
    }

}