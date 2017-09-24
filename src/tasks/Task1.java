package tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: User
 * Date: 14.09.17
 * Time: 17:11
 */
//Напишите три функции, которые вычисляют сумму чисел в данном списке, используя цикл for, цикл while и рекурсию.
public class Task1 {

    public static void main(String[] args){
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(34);
        integerList.add(26);
        integerList.add(40);

        System.out.println("sumFor=" + sumFor(integerList));
        System.out.println("sumWhile=" + sumWhile(integerList));
        System.out.println("sumRecursive=" + sumRecursive(integerList , 0));
    }

    public static Integer sumFor(List<Integer> integerList){
        Integer result = 0;
        for(int i = 0; i < integerList.size(); i ++)
            result +=integerList.get(i);
        return result;
    }

    public static Integer sumWhile(List<Integer> integerList){
        Integer result = 0;
        Iterator<Integer> integerIterator = integerList.iterator();
        while (integerIterator.hasNext())
            result += integerIterator.next();
        return result;
    }

    public static Integer sumRecursive(List<Integer> integerList, Integer result){
        if (!integerList.isEmpty())
        {
            Integer integer =  integerList.get(0);
            integerList.remove(0);
            result = integer +  sumRecursive(integerList, result);
        }
        return result;
    }


}
