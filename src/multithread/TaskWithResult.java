package multithread;

import java.util.concurrent.Callable;

/**
 * User: User
 * Date: 05.09.17
 * Time: 23:34
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "result of TaskWithResult " + id;
    }
}


