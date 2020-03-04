package com.dev.tennisgame

import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.Score

class TennisGame(private val playerOneName: String, private val playerTwoName: String) {

    var playerOneScore: Int = Score.LOVE.value
    var playerTwoScore: Int = Score.LOVE.value

    fun translateToScore(score: Int): String {
        return when (score){
            Score.FORTY.value       -> GameConstant.FORTY
            Score.THIRTY.value      -> GameConstant.THIRTY
            Score.FIFTEEN.value     -> GameConstant.FIFTEEN
            Score.LOVE.value        -> GameConstant.LOVE
            else                    -> GameConstant.illegalScore(score)
        }
    }

    fun getPlayerWithHighestScore() = when { playerOneScore > playerTwoScore -> playerOneName else -> playerTwoName }
    internal fun hasWinner() = isPlayerTwoWinner() || isPlayerOneWinner()
    internal fun hasAdvantage() = isPlayerTwoHasAdvantage() || isPlayerOneHasAdvantage()
    internal fun isDeuce() = playerOneScore >= GameConstant.THREE_POINT && isPlayerScoresAreEqual()
    internal fun isPlayerScoresAreEqual() = playerOneScore == playerTwoScore
    internal fun isPlayerOneWinner() = playerOneScore >= GameConstant.FOUR_POINT && playerOneScore >= playerTwoScore + GameConstant.TWO_POINT
    internal fun isPlayerTwoWinner() = playerTwoScore >= GameConstant.FOUR_POINT && playerTwoScore >= playerOneScore + GameConstant.TWO_POINT
    internal fun isPlayerOneHasAdvantage() = playerOneScore >= GameConstant.FOUR_POINT && playerOneScore == playerTwoScore + GameConstant.ONE_POINT
    internal fun isPlayerTwoHasAdvantage() = playerTwoScore >= GameConstant.FOUR_POINT && playerTwoScore == playerOneScore + GameConstant.ONE_POINT
}