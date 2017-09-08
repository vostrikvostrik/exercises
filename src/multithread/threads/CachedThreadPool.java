package multithread.threads;

import multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:15
 */
public class CachedThreadPool {
    public static void main(String... args){
        ExecutorService executorService = Executors.newCachedThreadPool(); //кэширующий пул потоков,
        // который создает потоки по мере необходимости, но переиспользует неактивные потоки
        // (и подчищает потоки, которые были неактивные некоторое время)
        for(int i=0;i<3;i++)
            executorService.execute(new LiftOff());
        executorService.shutdown();
    }
}
