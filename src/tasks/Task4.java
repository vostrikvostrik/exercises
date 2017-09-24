package tasks;

import java.util.Arrays;
import java.util.List;

/**
 * User: User
 * Date: 15.09.17
 * Time: 9:59
 */
//Напишите функцию, которая принимает список не отрицательных целых чисел, упорядочивает их так,
// чтобы они составляли максимально возможное число. Например, [50, 2, 1, 9], наибольшее сформированное число равно 95021.
public class Task4 {
    public static void main(String[] args) {
        Integer[] number = {56,2,71,99};
        List<Integer> result =  Arrays.asList(Task4.ordering(number));
        System.out.print(result);
        System.out.print(Task4.maxNumber(number));
    }

    public static Long maxNumber(Integer[] numbers) {
        String number = "";
        numbers = ordering(numbers);
        for(int i=0;i<numbers.length ; i++){
            number+=numbers[i];
        }
        return new Long(number);
    }

    public static Integer[] ordering(Integer[] numbers) {
        Integer[] result = new Integer[numbers.length];
        if (numbers.length > 0) {

            for (int i = 0; i < numbers.length; i++) {
                int max = numbers[i];
                for (int j = i +1; j < numbers.length; j++) {
                    if (firstDigit(numbers[i])< firstDigit(numbers[j])) {
                        max = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = max;
                    }
                }
            }
        }
        return numbers;
    }

    public static int firstDigit(Integer number){
        int first = 0;
        while (number > 0){
            first = number;
            number = number / 10;
        }

        return first;
    }
}

