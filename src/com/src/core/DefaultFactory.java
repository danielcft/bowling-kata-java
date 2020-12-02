package com.src.core;

import com.src.frame.Frame;
import com.src.frame.FrameFactory;

public class DefaultFactory implements FrameFactory {
    public Frame build(String score) {
        score = score.toUpperCase();
        if (score.equals("X")) {
            return new StrikeFrame();
        } else if (score.contains("/")) {
            var firstRoll = score.charAt(0) == '-' ? 0 : Character.getNumericValue(score.charAt(0));
            return new SpareFrame(firstRoll);
        } else {
            return new NormalFrame(getFirst(score), getSecond(score));
        }
    }

    private static int getFirst(String score) {
        if (score.charAt(0) == '-' || score.equals("-")) {
            return 0;
        }
        return Character.getNumericValue(score.charAt(0));
    }

    private static int getSecond(String score) {
        if (score.length() == 1 || score.equals("-") || score.charAt(1) == '-') {
            return 0;
        }
        return Character.getNumericValue(score.charAt(1));
    }
}
