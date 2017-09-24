package tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * User: User
 * Date: 15.09.17
 * Time: 9:41
 */
//Напишите функцию, которая посчитает первые 100 чисел Фибоначчи.
// По определению первые два числа в последовательности Фибоначчи равны 0 и 1,
// и каждое последующее число представляет собой сумму двух предыдущих.
// В качестве примера здесь приведены первые 10 чисел Фибоначчи: 0, 1, 1, 2, 3, 5, 8, 13, 21 и 34
public class Task3 {
    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci(100);
         System.out.print(fibonacci.fibonacci);
    }
}

class Fibonacci{
    List<Long> fibonacci = new ArrayList<Long>();
    public Fibonacci(int count){
        fibonacci.add(0L);
        fibonacci.add(1L);
        for(int i= 2 ; i < count; i++){
            fibonacci.add(nextInt(fibonacci.get( i - 1), fibonacci.get(i - 2)));
        }
    }



    Long nextInt(Long prev, Long preprev){
        return prev + preprev;
    }

}
