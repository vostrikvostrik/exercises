package multithread.threads.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: User
 * Date: 12.09.17
 * Time: 20:31
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident){
        generator = g;
        id = ident;
    }
    @Override
    public void run() {
        while(!generator.isCanceled()){
            int val = generator.next();
            if (val % 2 != 0){
                System.out.println(val + " not even!");
                generator.cancel(); // Cancels all EvenCheckers
            }
        }
    }

    //Test any type of IntGenerator:
    public static void test(IntGenerator gp, int count){
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i =0; i< count; i++){
            executorService.execute(new EvenChecker(gp,i));
        }
        executorService.shutdown();
    }

    //Default value for count:
    public static void test(IntGenerator gp){
        test(gp, 10);
    }
}
