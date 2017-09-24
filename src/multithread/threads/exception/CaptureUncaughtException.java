package multithread.threads.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * User: User
 * Date: 11.09.17
 * Time: 20:14
 */
class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("ExceptionThread2 eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("MyUncaughtExceptionHandler caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t =new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("HandlerThreadFactory eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
      public static void main(String[] args){
          ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
          executorService.execute(new ExceptionThread2());
      }
}
