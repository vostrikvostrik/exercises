package multithread.threads;

import multithread.LiftOff;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:10
 */
public class BasicThreads {
    public static void main(String... args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
