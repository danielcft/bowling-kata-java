package com.test.core;

import com.src.core.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void minimum() {
        // Arrange
        Game game = new Game();

        // Act
        game.load("- - - - - - - - - -");

        // Assert
        assertEquals(0, game.score());
    }

    @Test
    public void testMaximum() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("X X X X X X X X X X X X");

        // Assert
        assertEquals(300, score.score());
    }

    @Test
    public void onePointPerFrame() {
        // Arrange
        Game game = new Game();

        // Act
        game.load("1- -1 1- -1 1- -1 1- -1 1- -1");

        // Assert
        assertEquals(10, game.score());
    }

    @Test
    public void onePointPerRoll() {
        // Arrange
        Game game = new Game();

        // Act
        game.load("11 11 11 11 11 11 11 11 11 11");

        // Assert
        assertEquals(20, game.score());
    }

    @Test
    public void spareFirst() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("1/ 11 11 11 11 11 11 11 11 11");

        // Assert
        assertEquals(29, score.score());
    }

    @Test
    public void spareLast() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("11 11 11 11 11 11 11 11 11 1/ 1");

        // Assert
        assertEquals(29, score.score());
    }

    @Test
    public void strikeFirst() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("X 11 11 11 11 11 11 11 11 11");

        // Assert
        assertEquals(30, score.score());
    }

    @Test
    public void strikeLast() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("11 11 11 11 11 11 11 11 11 X 11");

        // Assert
        assertEquals(30, score.score());
    }

    @Test
    public void maximumWithNoStrikesOrSpares() {
        // Arrange
        Game score = new Game();

        // Act
        score.load("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");

        // Assert
        assertEquals(90, score.score());
    }

    @Test
    public void spares() {
        testSpares("1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1", 110);
        testSpares("2/ 2/ 2/ 2/ 2/ 2/ 2/ 2/ 2/ 2/ 2", 120);
        testSpares("3/ 3/ 3/ 3/ 3/ 3/ 3/ 3/ 3/ 3/ 3", 130);
        testSpares("4/ 4/ 4/ 4/ 4/ 4/ 4/ 4/ 4/ 4/ 4", 140);
        testSpares("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5", 150);
        testSpares("6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6/ 6", 160);
        testSpares("7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/ 7/ 7", 170);
        testSpares("8/ 8/ 8/ 8/ 8/ 8/ 8/ 8/ 8/ 8/ 8", 180);
        testSpares("9/ 9/ 9/ 9/ 9/ 9/ 9/ 9/ 9/ 9/ 9", 190);
    }

    private void testSpares(String score, int expected) {
        Game game = new Game();
        game.load(score);

        assertEquals(game.score(), expected);
    }


    @Test
    public void test1() {
        Game game = new Game();
        game.load("15 23 2/ 1- 2- X 5- 1- 2- 61");

        assertEquals(6 + 5 + 11 + 1 + 2 + 15 + 5  + 1 + 2 + 7, game.score());
    }

}
