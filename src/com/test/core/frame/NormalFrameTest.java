package com.test.core.frame;

import com.src.frame.DoubleRoll;
import com.src.frame.Frame;
import com.src.core.NormalFrame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalFrameTest {

    @Test
    public void normal() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i + j <= 10){
                    assertNormal(i, j);
                }
            }
        }
    }

    private void assertNormal(int firstRoll, int secondRoll) {
        Frame frame = new NormalFrame(firstRoll, secondRoll);

        assertEquals(((DoubleRoll) frame).firstRoll(), firstRoll);
        assertEquals(((DoubleRoll) frame).secondRoll(), secondRoll);

        assertEquals(frame.baseScore(), firstRoll + secondRoll);
    }
}
