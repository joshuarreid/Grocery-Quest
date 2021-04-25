package model;

import java.util.concurrent.TimeUnit;

public class Statistics {
    private int antimaskers;
    private int items;
    private long startTime;
    private long endTime;
    private long timeElapsed;

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

    public long getTimeElapsed(){
        return TimeUnit.SECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);
    }

    public int getAntimaskers(){
        return antimaskers;
    }

    public int getItems(){
        return items;
    }


}
