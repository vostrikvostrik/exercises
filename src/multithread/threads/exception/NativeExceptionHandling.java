package multithread.threads.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 11.09.17
 * Time: 20:10
 */
public class NativeExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled!");
        }
    }
}
