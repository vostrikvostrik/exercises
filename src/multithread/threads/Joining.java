package multithread.threads;

/**
 * User: User
 * Date: 10.09.17
 * Time: 17:51
 */
class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);

        } catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " +isInterrupted());
        }
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
        System.out.println(getName() + " has awakened");

    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args){
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();

    }
}
/*
Класс Thread содержит в себе скрытое булево поле, которое называется флагом прерывания.
Установить этот флаг можно вызвав метод interrupt() потока.
Проверить же, установлен ли этот флаг, можно двумя способами.
Первый способ — вызвать метод bool isInterrupted() объекта потока,
второй — вызвать статический метод bool Thread.interrupted().
Первый метод возвращает состояние флага прерывания и оставляет этот флаг нетронутым.
Второй метод возвращает состояние флага и сбрасывает его.
Заметьте что Thread.interrupted() — статический метод класса Thread,
и его вызов возвращает значение флага прерывания того потока, из которого он был вызван.
*/
