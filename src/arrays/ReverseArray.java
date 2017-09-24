package arrays;

/**
 * User: User
 * Date: 15.09.17
 * Time: 17:51
 */
public class ReverseArray {
    /* Function to reverse arr[] from start to end*/
    static void reverseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }

    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 25, 6,78};
        printArray(arr, 7);
        reverseArray(arr, 0, 6);
        System.out.println("Reversed array is ");
        printArray(arr, 7);
    }
}
