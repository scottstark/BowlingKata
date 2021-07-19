package com.example.MyTestGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void beforeEach() {
        game = new Game();
    }

    @Test
    void canRole() {
        game.roll(0);
    }

    @Test
    void canScoreGutterGame() {
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.score(), 0);
    }

    @Test
    void canScoreGameOfOnes() {
        game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertEquals(game.score(), 20);
    }

    @Test
    void canScoreSpareFollowedByThree() {
        game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.score(), 16);
    }

    @Test
    void canScoreStrikeFollowedByThreeThenThree() {
        game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.score(), 22);
    }

    @Test
    void canScorePerfectGame() {
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertEquals(game.score(), 300);
    }
}