package com.dev.tennisgame

import com.dev.tennisgame.utilities.GameConstant
import com.dev.tennisgame.utilities.GameConstant.Companion.illegalScore
import com.dev.tennisgame.utilities.Score.FORTY
import com.dev.tennisgame.utilities.Score.THIRTY
import com.dev.tennisgame.utilities.Score.FIFTEEN
import com.dev.tennisgame.utilities.Score.LOVE

class TennisGame {

    fun translateToScore(score: Int): String {
        return when (score){
            FORTY.value -> GameConstant.FORTY
            THIRTY.value -> GameConstant.THIRTY
            FIFTEEN.value -> GameConstant.FIFTEEN
            LOVE.value -> GameConstant.LOVE
            else -> illegalScore(score)
        }
    }
}