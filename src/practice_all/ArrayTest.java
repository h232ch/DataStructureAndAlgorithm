package practice_all;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayTest {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);

        int[] i = {1,2,3,4,5};
        int[] j = new int[5];

        j = i.clone();
        j[3] = 0;

        for (int temp : i) {
            System.out.println(temp);
        }
        System.out.println();

        for (int temp : j) {
            System.out.println(temp);
        }
        System.out.println();

        int[] arr1 = new int[5];
        int[] arr2 = {1,2,3,4,5};

        arr1 = arr2.clone();
        arr2[2] = 5;

        for (int temp : arr1) {
            System.out.printf("%d", temp);
        }
        System.out.println();

        for (int temp : arr2) {
            System.out.printf("%d", temp);
        }
        System.out.println();
    }
}
