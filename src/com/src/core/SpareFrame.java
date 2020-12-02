package com.src.core;

import com.src.frame.DoubleRoll;

public class SpareFrame implements DoubleRoll {
    private int firstRoll;

    public SpareFrame(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    @Override
    public int firstRoll() {
        return firstRoll;
    }

    @Override
    public int secondRoll() {
        return 10 - firstRoll;
    }

    @Override
    public int baseScore() {
        return 10;
    }
}
