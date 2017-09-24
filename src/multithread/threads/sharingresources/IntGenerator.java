package multithread.threads.sharingresources;

/**
 * User: User
 * Date: 12.09.17
 * Time: 20:29
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    //Allow this to be canceled:
    public void cancel(){canceled = true;}
    public boolean isCanceled(){return canceled;}
}
