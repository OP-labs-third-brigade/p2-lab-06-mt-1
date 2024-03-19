package org.example;

public class Task3 {
    private static final int N = 100_000_000;
    private static final int n = 3;

    public static void main(String[] args) {
        int[] kValues = {2, 4, 8, 16, 32};

        for (int k : kValues) {
            long startTime = System.currentTimeMillis();
            long sum = parallelSum(k);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("k = " + k + ", Sum = " + sum + ", Execution time = " + elapsedTime + " milliseconds");
        }
    }

    private static long parallelSum(int k) {
        SummationThread[] threads = new SummationThread[k];
        for (int i = 0; i < k; i++) {
            threads[i] = new SummationThread(i, k);
            threads[i].start();
        }

        long totalSum = 0;
        for (int i = 0; i < k; i++) {
            try {
                threads[i].join();
                totalSum += threads[i].getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalSum;
    }

    private static class SummationThread extends Thread {
        private final int threadId;
        private final int k;
        private long sum;

        public SummationThread(int threadId, int k) {
            this.threadId = threadId;
            this.k = k;
        }

        @Override
        public void run() {
            sum = 0;
            for (int i = threadId + 1; i <= N; i += k) {
                sum += (long) i * n;
            }
        }

        public long getSum() {
            return sum;
        }
    }
}
