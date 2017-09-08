package multithread.threads;

import multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:23
 */
public class FixedThreadPool {
    public static void main(String... args){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<15;i++)
        {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
