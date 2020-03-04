package com.dev.tennisgame
import androidx.lifecycle.MutableLiveData
import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.Score

class TennisGame(private val playerOneName: String, private val playerTwoName: String) {

    val winner = MutableLiveData<String>()
    val gameScore = MutableLiveData<String>()
    var playerOneScore: Int = Score.LOVE.value
    var playerTwoScore: Int = Score.LOVE.value

    fun getScore(): String {
        val score = when {
            hasWinner() -> getWinnerDetails()
            hasAdvantage() -> "${GameConstant.ADVANTAGE} ${getPlayerWithHighestScore()}${GameConstant.EXCLAMATION_SYMBOL}"
            isDeuce() -> GameConstant.DEUCE
            isPlayerScoresAreEqual() -> "${translateToScore(playerOneScore)} ${GameConstant.ALL}"
            else -> "${translateToScore(playerOneScore)}, ${translateToScore(playerTwoScore)}"
        }
        gameScore.value = score
        return score
    }

    fun translateToScore(score: Int): String {
        return when (score){
            Score.FORTY.value     -> GameConstant.FORTY
            Score.THIRTY.value    -> GameConstant.THIRTY
            Score.FIFTEEN.value   -> GameConstant.FIFTEEN
            Score.LOVE.value      -> GameConstant.LOVE
            else            -> GameConstant.illegalScore(score)
        }
    }

    fun getPlayerWithHighestScore(): String {
        return when {
            playerOneScore > playerTwoScore -> playerOneName else -> playerTwoName
        }
    }

    private fun getWinnerDetails(): String {
        winner.value = getPlayerWithHighestScore()
        return "${getPlayerWithHighestScore()} ${GameConstant.WON_THE_GAME}"
    }

    private fun hasWinner() = isPlayerTwoWinner() || isPlayerOneWinner()
    private fun hasAdvantage() = isPlayerTwoHasAdvantage() || isPlayerOneHasAdvantage()
    private fun isDeuce() = playerOneScore >= GameConstant.THREE_POINT && isPlayerScoresAreEqual()
    private fun isPlayerScoresAreEqual() = playerOneScore == playerTwoScore
    private fun isPlayerOneWinner() = playerOneScore >= GameConstant.FOUR_POINT && playerOneScore >= playerTwoScore + GameConstant.TWO_POINT
    private fun isPlayerTwoWinner() = playerTwoScore >= GameConstant.FOUR_POINT && playerTwoScore >= playerOneScore + GameConstant.TWO_POINT
    private fun isPlayerOneHasAdvantage() = playerOneScore >= GameConstant.FOUR_POINT && playerOneScore == playerTwoScore + GameConstant.ONE_POINT
    private fun isPlayerTwoHasAdvantage() = playerTwoScore >= GameConstant.FOUR_POINT && playerTwoScore == playerOneScore + GameConstant.ONE_POINT
}