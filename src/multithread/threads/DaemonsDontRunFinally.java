package multithread.threads;

import java.util.concurrent.TimeUnit;

/**
 * User: User
 * Date: 07.09.17
 * Time: 14:10
 */
class ADaemon implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }
        finally {
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
