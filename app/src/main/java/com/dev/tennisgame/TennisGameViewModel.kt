package com.dev.tennisgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.Score

class TennisGameViewModel : ViewModel() {

    lateinit var tennisGame : TennisGame

    val winnerDetails = MutableLiveData<String>()
    val scoreAdvantage = MutableLiveData<String>()
    val scoreDeuce = MutableLiveData<String>()
    val scoreEqual = MutableLiveData<String>()
    val scoreByPoints = MutableLiveData<String>()

    fun setPlayers(playerOneName: String, playerTwoName: String){
        tennisGame = TennisGame(playerOneName, playerTwoName)
    }

    private fun getScore() {
        when {
            tennisGame.hasWinner()              -> winnerDetails.value  = tennisGame.getPlayerWithHighestScore()
            tennisGame.hasAdvantage()           -> scoreAdvantage.value = tennisGame.getPlayerWithHighestScore()
            tennisGame.isDeuce()                -> scoreDeuce.value     = GameConstant.DEUCE
            tennisGame.isPlayerScoresAreEqual() -> scoreEqual.value     = getPlayerOneScore()
            else                                -> scoreByPoints.value  = "${getPlayerOneScore()}, ${getPlayerTwoScore()}"
        }
    }

    private fun getPlayerTwoScore() = tennisGame.translateToScore(tennisGame.playerTwoScore)

    private fun getPlayerOneScore() = tennisGame.translateToScore(tennisGame.playerOneScore)

    fun addScoreToPlayerOne() {
        tennisGame.playerOneScore++
        getScore()
    }

    fun addScoreToPlayerTwo() {
        tennisGame.playerTwoScore++
        getScore()
    }

    fun resetGame(){
        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        getScore()
    }
}