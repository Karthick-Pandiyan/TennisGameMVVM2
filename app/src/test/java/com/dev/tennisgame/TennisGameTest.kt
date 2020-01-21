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
}