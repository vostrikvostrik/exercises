package arrays;

/**
 * User: User
 * Date: 14.09.17
 * Time: 14:22
 */
/*
Задача:
Как изменить порядок элементов в строке на обратный без использования вспомогательных классов
Решение:

* */
public class Reverse {
    public static String reverseByArray(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }
    public static void main(String[] args) {
        String string = "Java test";
        System.out.println(reverseByArray(string));
    }
}
