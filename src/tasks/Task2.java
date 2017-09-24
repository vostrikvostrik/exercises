package tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * User: User
 * Date: 14.09.17
 * Time: 17:24
 */
//Напишите функцию, которая объединяет два списка, чередуя элементы.
// Например, с учетом двух списков [a, b, c] и [1, 2, 3] функция должна вернуть [a, 1, b, 2, c, 3].
public class Task2 {
    public static void main(String[] args){
        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        List<String> result = new ArrayList<String>();

        for(int i = 0, sizeS = stringList.size(), sizeI = integerList.size();i < (sizeI > sizeS ? sizeI : sizeS) ; i++){
                if(i < sizeS - 1 )
                    result.add(stringList.get(i));
                if(i < sizeI - 1)
                    result.add(integerList.get(i).toString());
        }
        System.out.println(result);
    }
}
