package multithread.threads;

import multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:28
 */
public class SingleThreadExecutor {
    public static void main(String... args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++)
            executorService.execute(new LiftOff());
        executorService.shutdown();
    }
}
