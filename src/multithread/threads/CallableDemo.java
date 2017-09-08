package multithread.threads;

import multithread.TaskWithResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:37
 */
public class CallableDemo{
    public static void main(String... args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        for(int i=0; i < 10; i++){
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : futures){
            try{
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch (InterruptedException e){
                System.out.println(e);
                return;
            } catch (ExecutionException e){
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }

        }
    }
}
