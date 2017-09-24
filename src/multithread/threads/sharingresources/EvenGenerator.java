package multithread.threads.sharingresources;

import static java.lang.Thread.yield;

/**
 * User: User
 * Date: 12.09.17
 * Time: 20:49
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;// Danger point here!  Increment - it's not an atomic in Java!
        yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
