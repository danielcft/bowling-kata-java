package com.test.core;

import com.src.core.DefaultFactory;
import com.src.core.NormalFrame;
import com.src.core.SpareFrame;
import com.src.core.StrikeFrame;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrameFactoryTest {

    @Test
    public void lowerCaseStrike() {
        testStrike("X");
    }

    @Test
    public void upperCaseStrike() {
        testStrike("x");
    }

    private void testStrike(String x) {
        var frame = new DefaultFactory().build(x);

        assertTrue(frame instanceof StrikeFrame);
        assertEquals(frame.baseScore(), 10);
    }

    @Test
    public void spare() {
        IntStream.rangeClosed(1, 9).forEach(this::testSpare);
    }

    private void testSpare(int firstRoll) {
        var frame = new DefaultFactory().build(firstRoll + "/");

        assertTrue(frame instanceof SpareFrame);
        assertEquals(firstRoll, ((SpareFrame) frame).firstRoll());
        assertEquals(10 - firstRoll, ((SpareFrame) frame).secondRoll());
        assertEquals(10, frame.baseScore());
    }

    @Test
    public void spareWithGutter() {
        var frame = new DefaultFactory().build("-/");

        assertTrue(frame instanceof SpareFrame);
        assertEquals(0, ((SpareFrame) frame).firstRoll());
        assertEquals(10, ((SpareFrame) frame).secondRoll());
        assertEquals(10, frame.baseScore());
    }

    @Test
    public void normal() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i + j <= 10) {
                    testNormal(i, j);
                }
            }
        }
    }

    public void testNormal(int firstRoll, int secondRoll) {
        var frame = new DefaultFactory().build(String.format("%s%s", firstRoll, secondRoll));

        assertTrue(frame instanceof NormalFrame);
        assertEquals(firstRoll + secondRoll, frame.baseScore());
        assertEquals(firstRoll, ((NormalFrame) frame).firstRoll());
        assertEquals(secondRoll, ((NormalFrame) frame).secondRoll());
    }

    @Test
    public void normalWithGutterOnFirstRoll() {
        IntStream.rangeClosed(1, 9).forEach(this::testNormalWithGutterOnFirstRoll);

    }

    private void testNormalWithGutterOnFirstRoll(int secondRoll) {
        var frame = new DefaultFactory().build(String.format("-%s", secondRoll));

        assertTrue(frame instanceof NormalFrame);
        assertEquals(secondRoll, frame.baseScore());
        assertEquals(0, ((NormalFrame) frame).firstRoll());
        assertEquals(secondRoll, ((NormalFrame) frame).secondRoll());
    }

    @Test
    public void testNormalWithGutterOnSecondRoll() {
        IntStream.rangeClosed(1, 9).forEach(this::testNormalWithGutterOnSecondRoll);
    }

    private void testNormalWithGutterOnSecondRoll(int firstRoll) {
        var frame = new DefaultFactory().build(String.format("%s-", firstRoll));

        assertTrue(frame instanceof NormalFrame);
        assertEquals(firstRoll, frame.baseScore());
        assertEquals(firstRoll, ((NormalFrame) frame).firstRoll());
        assertEquals(0, ((NormalFrame) frame).secondRoll());
    }
}
