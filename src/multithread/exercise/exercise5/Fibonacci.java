package multithread.exercise.exercise5;

/**
 * User: User
 * Date: 06.09.17
 * Time: 8:51
 */
public class Fibonacci implements generics.fibonacci.Generator<Integer>, Runnable {
    private int count;
    private int index = 0;

    public Fibonacci(int num) {
        count = num;
    }

    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public Integer next() {
        return count-- > 0 ? fibo(++index) : -1;
    }

    public int fibo(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 1;
        }
        return fibo(num - 1) + fibo(num - 2);
    }

    @Override
    public void run() {
        while (hasNext()) {
            System.out.print(next() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(8);
        f.run();
    }
}

