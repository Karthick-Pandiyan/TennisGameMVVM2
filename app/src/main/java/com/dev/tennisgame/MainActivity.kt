package com.dev.tennisgame
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val tennisGameViewModel: TennisGameViewModel by lazy { ViewModelProvider(this).get(TennisGameViewModel::class.java) }

    @SuppressLint("SetTextI18n")
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

        tennisGameViewModel.winnerDetails.observe(this, Observer {
            tennisGameViewModel.resetGame()
        })

        tennisGameViewModel.scoreAdvantage.observe(this, Observer { playerName ->
            updateScore("${getString(R.string.advantage)} $playerName${getString(R.string.exclamation_symbol)}")
        })

        tennisGameViewModel.scoreDeuce.observe(this, Observer { deuce ->
            updateScore(deuce)
        })

        tennisGameViewModel.scoreEqual.observe(this, Observer { points ->
            updateScore("$points ${getString(R.string.all)}")
        })

        tennisGameViewModel.scoreByPoints.observe(this, Observer { points ->
            updateScore(points)
        })
    }

    private fun updateScore(score: String) {
        txtScoreView.text = score
    }
}
