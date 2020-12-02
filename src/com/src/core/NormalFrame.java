package com.src.core;


import com.src.frame.DoubleRoll;

public class NormalFrame implements DoubleRoll {
    private int firstRoll;
    private int secondRoll;

    public NormalFrame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    @Override
    public int firstRoll() {
        return firstRoll;
    }

    @Override
    public int secondRoll() {
        return secondRoll;
    }

    @Override
    public int baseScore() {
        return firstRoll + secondRoll;
    }
}
