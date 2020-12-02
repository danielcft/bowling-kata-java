package com.src.core;

import com.src.frame.SingleRoll;

public class StrikeFrame implements SingleRoll {

    @Override
    public int firstRoll() {
        return 10;
    }

    @Override
    public int baseScore() {
        return 10;
    }
}
