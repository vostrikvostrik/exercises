package multithread.threads;

import java.util.concurrent.ThreadFactory;

/**
 * User: User
 * Date: 06.09.17
 * Time: 20:13
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
