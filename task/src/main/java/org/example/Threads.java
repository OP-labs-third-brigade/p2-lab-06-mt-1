package org.example;
public class Threads {
    public static long calculateSum (int var, long Num, int thread) throws InterruptedException {
        long sum = 0;
        SumThread[] threads = new SumThread[thread];
        for (int i = 0; i < thread; i++ ){
            threads[i]=new SumThread(i * Num / thread + 1,(i+1) * Num / thread, var);
            threads[i].start();
        }
        for (int i = 0; i < thread; i++){
            threads[i].join();
            sum+=threads[i].getSum();
        }
        return sum;
    }
}
