package org.example;

public class Loop {
    public static long calculateSum(int n, long N) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (long) i * n;
        }
        return sum;
    }
}

