package multithread.threads.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 12.09.17
 * Time: 20:12
 */
public class SettingDefaultHandler {
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
