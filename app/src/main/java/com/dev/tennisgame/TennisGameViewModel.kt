package com.dev.tennisgame
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.tennisgame.utilities.Score

class TennisGameViewModel : ViewModel() {

    lateinit var tennisGame : TennisGame

    fun setPlayers(playerOneName: String, playerTwoName: String){
        tennisGame = TennisGame(playerOneName, playerTwoName)
    }

    val score : MutableLiveData<String> = tennisGame.gameScore

    val winner : MutableLiveData<String> = tennisGame.winner

    fun addScoreToPlayerOne() {
        tennisGame.playerOneScore++
        tennisGame.getScore()
    }

    fun addScoreToPlayerTwo() {
        tennisGame.playerTwoScore++
        tennisGame.getScore()
    }

    fun resetGame(){
        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        tennisGame.getScore()
    }
}