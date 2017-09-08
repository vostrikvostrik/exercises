package multithread.exercise.exercise5;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: User
 * Date: 06.09.17
 * Time: 8:27
 */
public class FibonacciTasks implements Callable<Integer> {
    public static void main(String[] args) {
        ExecutorService ex=Executors.newCachedThreadPool();
        try{
            List<Future<Integer>> list=new ArrayList<Future<Integer>>();
            for(int i=0;i<10;i++){
                list.add(ex.submit(new FibonacciTasks(i+1)));
            }
            for(Future<Integer> f:list){
                System.out.println(f.get());
            }
        }catch(InterruptedException ie){
            System.out.println(ie);
        }catch(ExecutionException ee){
            System.out.println(ee);
        }finally{
            ex.shutdown();
        }
    }

    private Fibonacci f;
    public FibonacciTasks(int num){
        f=new Fibonacci(num);
    }

    @Override
    public Integer call(){
        int sum=0;
        while(f.hasNext()){
            sum+=f.next();
        }
        return sum;
    }
}
