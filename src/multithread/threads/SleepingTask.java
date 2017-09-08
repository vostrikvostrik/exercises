package multithread.threads;

import multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * User: User
 * Date: 06.09.17
 * Time: 14:14
 */
public class SleepingTask extends LiftOff {
    public void run(){
        try{
            while(countDown-- > 0){
                System.out.print(status());
                //Old-style:
                //Thread.sleep(100);
                //Java SE5/6-style:
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String... args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
