package com.test.core.frame;

import com.src.core.SpareFrame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpareFrameTest {

    @Test
    public void spare() {
        for (int i = 1; i < 10; i++) {
            assertSpare(i);
        }
    }

    public void assertSpare(int firstRoll) {
        SpareFrame spareFrame = new SpareFrame(firstRoll);

        assertEquals(firstRoll, spareFrame.firstRoll());
        assertEquals(10 - firstRoll, spareFrame.secondRoll());
        assertEquals(10, spareFrame.baseScore());
    }

}
