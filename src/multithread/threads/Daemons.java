package multithread.threads;

import java.util.concurrent.TimeUnit;

/**
 * User: User
 * Date: 07.09.17
 * Time: 13:59
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for(int i =0 ;i < t.length; i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }
        for(int i =0 ;i < t.length; i++){
            System.out.println("t["+i+"].isDaemon()=" + t[i].isDaemon() +",");
        }
        while (true)
            Thread.yield();//Заставляет процессор переключиться на обработку других потоков системы
    }
}
class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        while (true){
            Thread.yield();//Заставляет процессор переключиться на обработку других потоков системы
        }
    }
}

public class Daemons{
  public static void main(String[] args) throws Exception{
      Thread d = new Thread(new Daemon());
      d.setDaemon(true);
      d.start();
      System.out.println("d.isDaemon() = " + d.isDaemon() + ",");
      //Allow the daemon threads to
      //finish their startup processes:
      TimeUnit.SECONDS.sleep(1);
  }
}
