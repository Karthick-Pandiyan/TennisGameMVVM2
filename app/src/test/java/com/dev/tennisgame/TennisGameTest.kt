package com.dev.tennisgame

import com.dev.tennisgame.utilities.GameConstant.Companion.ALL
import com.dev.tennisgame.utilities.GameConstant.Companion.FIFTEEN
import com.dev.tennisgame.utilities.GameConstant.Companion.FORTY
import com.dev.tennisgame.utilities.GameConstant.Companion.LOVE
import com.dev.tennisgame.utilities.GameConstant.Companion.THIRTY
import com.dev.tennisgame.utilities.GameConstant.Companion.illegalScore
import com.dev.tennisgame.utilities.Score
import org.junit.Assert
import org.junit.Test

class TennisGameTest {

    private val tennisGame = TennisGame()

    @Test
    fun `Given translateToScore function returns illegal score when invalid score passed`(){
        val expectedResult = illegalScore(5)

        val actualResult = tennisGame.translateToScore(5)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Love when score is 0`(){
        val expectedResult = LOVE

        val actualResult = tennisGame.translateToScore(Score.LOVE.value)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Fifteen when score is 1`(){
        val expectedResult = FIFTEEN

        val actualResult = tennisGame.translateToScore(Score.FIFTEEN.value)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Thirty when score is 2`(){
        val expectedResult = THIRTY

        val actualResult = tennisGame.translateToScore(Score.THIRTY.value)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Forty when score is 3`(){
        val expectedResult = FORTY

        val actualResult = tennisGame.translateToScore(Score.FORTY.value)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given getScore function should return Love all when both player scores are equal to 0`(){
        val expectedResult = "$LOVE $ALL"

        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        val actualResult = tennisGame.getScore()

        Assert.assertEquals(expectedResult, actualResult)
    }
}