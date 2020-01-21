package com.dev.tennisgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tennisGame: TennisGame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerOne = "John"
        val playerTwo = "Harry"
        tennisGame = TennisGame(playerOne, playerTwo)

        updateScore()
        btnPlayerOne.setOnClickListener {
            tennisGame.addScoreToPlayerOne()
            updateScore()
        }

        btnPlayerTwo.setOnClickListener {
            tennisGame.addScoreToPlayerTwo()
            updateScore()
        }

        tennisGame.winner.observe(this, Observer {
            btnPlayerOne.isEnabled = false
            btnPlayerTwo.isEnabled = false
        })
    }

    private fun updateScore(){
        txtScoreView.text = tennisGame.getScore()
    }
}
