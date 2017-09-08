package multithread.threads;

/**
 * User: User
 * Date: 07.09.17
 * Time: 18:51
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        //Store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }
    @Override
    public String toString(){
        return "#" + getName() + "(" + countDown + "),";
    }
    public void run(){
        while (true){
            System.out.print(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new SimpleThread();
        }
    }
}
