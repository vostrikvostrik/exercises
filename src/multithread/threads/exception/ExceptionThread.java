package multithread.threads.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 11.09.17
 * Time: 20:03
 */
public class ExceptionThread implements Runnable {
    public void run(){
        throw new RuntimeException();
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
