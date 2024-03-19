package org.example;

public class Task1 {
    public static void main(String[] args) {
        int n = 3;
        int N = 100_000_000;

        long startTime = System.nanoTime();

        long sum = (long) (n + N * n) * N / 2;

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println("Sum: " + sum);
        System.out.println("Execution time: " + elapsedTime + " nanoseconds");
    }
}