package com.test.core.frame;

import com.src.core.StrikeFrame;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrikeFrameTest {

    @Test
    public void strike() {
        StrikeFrame strikeFrame = new StrikeFrame();

        assertEquals(10, strikeFrame.baseScore());
        assertEquals(10, strikeFrame.firstRoll());
    }
}
