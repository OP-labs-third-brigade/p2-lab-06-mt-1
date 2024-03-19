package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        long N = 100_000_000;


        long start = System.nanoTime();
        long sum = Expression.calculateSum(n, N);
        long end = System.nanoTime();
        long elapsedTimeFormula = end - start;
        System.out.println("Method 1: Sum using formula: " + sum);
        System.out.println("Execution time using formula: " + elapsedTimeFormula + " nanoseconds\n");


        start = System.nanoTime();
        sum = Loop.calculateSum(n, N);
        end = System.nanoTime();
        long elapsedTimeSingleThread = (end - start) / 1_000_000;
        System.out.println("Method 2: Sum using single-thread loop: " + sum);
        System.out.println("Execution time using single-thread loop: " + elapsedTimeSingleThread + " milliseconds\n");


        int[] kValues = {2, 4, 8, 16, 32};
        for (int k : kValues) {
            start = System.nanoTime();
            sum = Threads.calculateSum(n, N, k);
            end = System.nanoTime();
            long elapsedTimeMultipleThreads = (end - start) / 1_000_000;
            System.out.println("Method: Sum with k=" + k + ": " + sum);
            System.out.println("Execution time with k=" + k + ": " + elapsedTimeMultipleThreads + " milliseconds\n");
        }
    }
}