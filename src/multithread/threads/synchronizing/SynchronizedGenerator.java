package multithread.threads.synchronizing;

import multithread.threads.sharingresources.EvenChecker;
import multithread.threads.sharingresources.IntGenerator;

/**
 * User: User
 * Date: 19.09.17
 * Time: 20:54
 */
public class SynchronizedGenerator extends IntGenerator {
    private int currentEvenValue = 0; //текущее четное число
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args){
        EvenChecker.test(new SynchronizedGenerator());
    }
}
