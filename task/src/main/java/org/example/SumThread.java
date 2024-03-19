package org.example;

public class SumThread extends Thread {
    private final long start;
    private final long end;
    private final int n;
    private long sum;

    public SumThread(long start, long end, int n) {
        this.start = start;
        this.end = end;
        this.n = n;
    }

    public void run() {
        for (long i = start; i <= end; i++) {
            sum += i*n;
        }
    }

    public long getSum() {
        return sum;
    }
}
