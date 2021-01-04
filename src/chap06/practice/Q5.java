package chap06.practice;

import java.awt.datatransfer.FlavorListener;
import java.util.Scanner;

public class Q5 {


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSearch(int[] arr) {

        int limit = arr.length;
        int last;

        int n = 0;
        int cnt = 0;

        while (n < limit - 1) {

            if (cnt % 2 == 0) {
                System.out.println("PASS : " + cnt++);

                last = limit - 1;
                for (int j = limit - 1; j > n; j--) {
                    for (int k = 0; k < arr.length - 1; k++) {
                        System.out.printf("%3d %c", arr[k], (k != j - 1 ? ' ' : (arr[j - 1] > arr[j]) ? '+' : '-'));
                    }
                    System.out.printf("%3d\n", arr[arr.length - 1]);

                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j - 1, j);
                        last = j;
                    }
                }

                n = last;
            } else {
                System.out.println("PASS : " + cnt++);

                last = limit - 1;
                for (int j = n; j < limit - 1; j++) {
                    for (int k = 0; k < arr.length-1; k++) {
                        System.out.printf("%3d %c", arr[k], (k != j ? ' ' : (arr[j] > arr[j+1]) ? '+' : '-'));
                    }
                    System.out.printf("%3d\n", arr[arr.length-1]);

                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        last = j + 1;
                    }
                }
                limit = last;
            }
        }

    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("input the size of array : ");

        int temp = sc.nextInt();
        int[] arr = new int[temp];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("input number of array : ");
            arr[i] = sc.nextInt();
        }

        bubbleSearch(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("the number of array : " + arr[i]);
        }
    }
}
