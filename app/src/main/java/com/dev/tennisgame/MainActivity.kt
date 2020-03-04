package com.dev.tennisgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val tennisGameViewModel: TennisGameViewModel by lazy { ViewModelProvider(this).get(TennisGameViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerOne = "John"
        val playerTwo = "Harry"
        tennisGameViewModel.setPlayers(playerOne, playerTwo)

        btnPlayerOne.setOnClickListener {
            tennisGameViewModel.addScoreToPlayerOne()
        }

        btnPlayerTwo.setOnClickListener {
            tennisGameViewModel.addScoreToPlayerTwo()
        }

        tennisGameViewModel.winner.observe(this, Observer {
            tennisGameViewModel.resetGame()
        })
        tennisGameViewModel.score.observe(this, Observer {score ->
            txtScoreView.text = score
        })
    }
}
