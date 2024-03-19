package org.example;

public class Task2 {
    public static void main(String[] args) {
        long n = 3;
        long N = 100_000_000;
        long sum = 0;
        long startTime = System.currentTimeMillis();

        for (long i = 1; i <= N; i++) {
            sum += i * n;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Sum: " + sum);
        System.out.println("Execution time: " + elapsedTime + " milliseconds");
    }
}