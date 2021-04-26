package model;

import java.util.concurrent.TimeUnit;

public class Statistics {
    private static int antimaskers;
    private static int items;
    private long startTime;
    private long endTime;
    private static long timeElapsed;

    public Statistics() {
        this.antimaskers = 0;
        this.items = 0;
        this.startTime = 0;
        this.endTime = 0;
        this.timeElapsed = 0;
    }

    public void addAntimasker(){
        this.antimaskers++;
    }

    public void addItem(){
        this.items++;
    }

    public void startTime(){
        startTime = System.nanoTime();
    }

    public void endTime(){
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
    }

    public static long getTimeElapsed(){
        return TimeUnit.SECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);
    }

    public static int getAntimaskers(){
        return antimaskers;
    }

    public static int getItems(){
        return items;
    }


}
