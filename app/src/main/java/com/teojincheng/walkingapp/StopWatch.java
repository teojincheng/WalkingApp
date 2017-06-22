package com.teojincheng.walkingapp;

import java.util.concurrent.TimeUnit;

/**
 * This class emulates a stopwatch.
 */

public class StopWatch {
    private long startTime = 0;
    private long endTime = 0;
    private boolean running = false;


    public void start() {
        this.startTime = System.nanoTime();
        this.running = true;
    }

    public void stop() {
        this.endTime = System.nanoTime();
        this.running = false;
    }

    public long getElapsedTime() {
        long elapsedTime = 0;
        if (running) {
            elapsedTime = System.nanoTime() - startTime;

        } else {
            elapsedTime = endTime - startTime;
        }

        long seconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

        return seconds;
    }


}
