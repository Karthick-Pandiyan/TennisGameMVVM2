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

    @Test
    fun `Given addScoreToPlayerOne function should add one point when player one scored a point`(){
        val expectedResult = Score.FIFTEEN.value

        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.addScoreToPlayerOne()
        val actualResult = tennisGame.playerOneScore

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given addScoreToPlayerTwo function should add one point when player two scored a point`(){
        val expectedResult = Score.FIFTEEN.value

        tennisGame.playerTwoScore = Score.LOVE.value
        tennisGame.addScoreToPlayerTwo()
        val actualResult = tennisGame.playerTwoScore

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given getScore function should return expected score when player one wins the first ball`(){
        val expectedResult = "$FIFTEEN, $LOVE"

        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        tennisGame.addScoreToPlayerOne()
        val actualResult = tennisGame.getScore()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given getScore function should return expected score when player two wins the first ball`(){
        val expectedResult = "$LOVE, $FIFTEEN"

        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        tennisGame.addScoreToPlayerTwo()
        val actualResult = tennisGame.getScore()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given getScore function should return expected score when player 1 and player 2 won the first ball`(){
        val expectedResult = "$FIFTEEN $ALL"

        tennisGame.playerOneScore = Score.LOVE.value
        tennisGame.playerTwoScore = Score.LOVE.value
        tennisGame.addScoreToPlayerOne()
        tennisGame.addScoreToPlayerTwo()
        val actualResult = tennisGame.getScore()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given getScore function should return expected score when both players are in Deuce`(){
        val expectedResult = "Deuce"

        tennisGame.playerOneScore = Score.FORTY.value
        tennisGame.playerTwoScore = Score.FORTY.value
        val actualResult = tennisGame.getScore()

        Assert.assertEquals(expectedResult, actualResult)
    }
}