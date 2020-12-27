package chap06.practice;

import java.util.Scanner;

public class Q3_Practice {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSearch(int[] arr) {

//        Enhance. 1
//        int limit = arr.length;
//        for (int i = 0; i < limit - 1; i++) {
//            System.out.println("Pass["+(i+1)+"]");
//            int exch = 0;
//
//            for (int j = limit - 1; j > i; j--) {
//                for (int k = 0; k < limit - 1; k++) {
//                    System.out.printf("%3d %c", arr[k], (k != j - 1 ? ' ' : (arr[j - 1] > arr[j]) ? '+' : '-'));
//                }
//                System.out.printf("%3d\n", arr[limit - 1]);
//
//                if (arr[j - 1] > arr[j]) {
//                    exch++;
//                    swap(arr, j - 1, j);
//                }
//            }
//            if (exch == 0) break;
//        }

//        Enhance. 2
        int limit = arr.length;
        int cnt = 1;
        int n = 0;
        int last;
        while (n < limit - 1) {
            System.out.println("Pass["+(cnt++)+"]");
            last = limit - 1;
            for (int j = limit - 1; j > n; j--) {

                for (int k = 0; k < limit - 1; k++) {
                    System.out.printf("%3d %c", arr[k], (k != j - 1 ? ' ' : (arr[j - 1] > arr[j]) ? '+' : '-'));
                }
                System.out.printf("%3d\n", arr[limit - 1]);

                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            n = last;
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
