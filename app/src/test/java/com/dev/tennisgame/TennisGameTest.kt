package com.dev.tennisgame

import org.junit.Assert
import org.junit.Test

class TennisGameTest {

    private val tennisGame = TennisGame()

    @Test
    fun `Given translateToScore function returns illegal score when invalid score passed`(){
        val expectedResult = "Illegal score: 5"

        val actualResult = tennisGame.translateToScore(5)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Love when score is 0`(){
        val expectedResult = "Love"

        val actualResult = tennisGame.translateToScore(0)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Fifteen when score is 1`(){
        val expectedResult = "Fifteen"

        val actualResult = tennisGame.translateToScore(1)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given translateToScore function should return Thirty when score is 2`(){
        val expectedResult = "Thirty"

        val actualResult = tennisGame.translateToScore(2)

        Assert.assertEquals(expectedResult, actualResult)
    }
}