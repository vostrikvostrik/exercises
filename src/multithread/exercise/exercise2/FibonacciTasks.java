package multithread.exercise.exercise2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 06.09.17
 * Time: 8:27
 */
public class FibonacciTasks {
    public static void main(String[] args) {
        singleThreadExecutor();
    }


    public static void basicThread() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Fibonacci(i + 1)).start();
        }
    }

    public static void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
            executorService.execute(new Fibonacci(i + 1));
        executorService.shutdown();
    }

    public static void singleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++)
            executorService.execute(new Fibonacci(i + 1));
        executorService.shutdown();
    }
}
