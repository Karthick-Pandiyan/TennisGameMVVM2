package com.dev.tennisgame

import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.GameConstant.Companion.ALL
import com.dev.tennisgame.utilities.GameConstant.Companion.DEUCE
import com.dev.tennisgame.utilities.GameConstant.Companion.THREE_POINT
import com.dev.tennisgame.utilities.GameConstant.Companion.illegalScore
import com.dev.tennisgame.utilities.Score.FORTY
import com.dev.tennisgame.utilities.Score.THIRTY
import com.dev.tennisgame.utilities.Score.FIFTEEN
import com.dev.tennisgame.utilities.Score.LOVE

class TennisGame(private val playerOneName: String, private val playerTwoName: String) {

    var playerOneScore: Int = LOVE.value
    var playerTwoScore: Int = LOVE.value


    fun getScore(): String {
        if(playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2 ||
            playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2)
            return "${getPlayerWithHighestScore()} won the game!"
        if(isDeuce())
            return DEUCE
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

    fun getPlayerWithHighestScore(): String {
        return when {
            playerOneScore > playerTwoScore -> playerOneName
            else -> playerTwoName
        }
    }

    private fun isDeuce() = playerOneScore >= THREE_POINT && isPlayerScoresAreEqual()

    private fun isPlayerScoresAreEqual() = playerOneScore == playerTwoScore

    fun addScoreToPlayerOne(){
        playerOneScore++
    }

    fun addScoreToPlayerTwo(){
        playerTwoScore++
    }

}