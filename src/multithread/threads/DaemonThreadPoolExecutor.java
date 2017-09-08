package multithread.threads;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: User
 * Date: 07.09.17
 * Time: 9:22
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor{
    public DaemonThreadPoolExecutor(){
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS , new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }

}
