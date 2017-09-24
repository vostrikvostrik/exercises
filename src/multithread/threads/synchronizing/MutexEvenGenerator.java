package multithread.threads.synchronizing;

import multithread.threads.sharingresources.EvenChecker;
import multithread.threads.sharingresources.IntGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: User
 * Date: 19.09.17
 * Time: 20:57
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock(); //повторно используемый
    @Override
    public int next() {
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
