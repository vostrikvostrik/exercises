package multithread.threads;

/**
 * User: User
 * Date: 11.09.17
 * Time: 9:23
 */
class UnresponsiveUI{
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception{
        while (d > 0){
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read(); // Never gets here
    }
}
public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI(){
        setDaemon(true); /*
        В Java процесс завершается тогда, когда завершается последний его поток. Даже если метод main() уже завершился,
        но еще выполняются порожденные им потоки, система будет ждать их завершения.
        Однако это правило не относится к особому виду потоков – демонам. Если завершился последний обычный поток процесса,
        и остались только потоки-демоны, то они будут принудительно завершены и выполнение процесса закончится.
        Чаще всего потоки-демоны используются для выполнения фоновых задач, обслуживающих процесс в течение его жизни.*/
        start();
    }
    public void run(){
        while (true){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception{
        //! new UnresponsiveUI(); //Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d); // Shows progress
    }
}
