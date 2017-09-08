package multithread;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:04
 */
public class LiftOff implements Runnable {
    protected int countDown = 10; //Default
    private  static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id + "(" + (countDown > 0 ? countDown : "LiftOff") + "),";
    }
    public void run(){
        while (countDown -- > 0){
            System.out.print( status() );
            Thread.yield();
        }
    }
}
