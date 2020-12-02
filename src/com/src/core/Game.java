package com.src.core;

import com.src.frame.*;
import com.src.frame.FrameFactory;

import java.util.*;
import java.util.stream.IntStream;

public class Game {
    private static final int NR_OF_FRAMES = 10;
    private FrameFactory frameFactory = new DefaultFactory();
    private List<Frame> frames = new LinkedList<>();

    public void load(String scores) {
        Arrays.stream(scores.split(" "))
                .map(frameFactory::build)
                .forEach(frames::add);
    }

    public int score() {

        return IntStream.range(0, NR_OF_FRAMES)
                .mapToObj(this::asFrame)
                .map(this::scoreOfIndividualFrame)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private Frame asFrame(int frameIndex){
        return frames.get(frameIndex);
    }

    private int scoreOfIndividualFrame(Frame frame) {
        if (frame instanceof StrikeFrame) {
            return frame.baseScore() + rollTwice(nextFrame(frame));
        } else if (frame instanceof SpareFrame) {
            return frame.baseScore() + roll(nextFrame(frame));
        }
        return frame.baseScore();
    }

    private int roll(Frame frame) {
        return ((SingleRoll) frame).firstRoll();
    }

    private int rollTwice(Frame frame) {
        if (frame instanceof DoubleRoll) {
            return ((DoubleRoll) frame).firstRoll() + ((DoubleRoll) frame).secondRoll();
        }
        return ((SingleRoll) frame).firstRoll() + roll(nextFrame(frame));
    }

    private Frame nextFrame(Frame f) {
        return frames.get(frames.indexOf(f) + 1);
    }
}
