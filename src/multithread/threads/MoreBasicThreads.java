package multithread.threads;

import multithread.LiftOff;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:12
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i =0; i<5;i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
