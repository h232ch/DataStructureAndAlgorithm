package chap06.practice;

import java.util.Scanner;

public class Q3 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = 0;
        while (n < arr.length - 1) {
            int last = arr.length - 1; // Point : Basement..!!!
            for (int j = arr.length - 1; j > n; j--) {

                for (int k = 0; k < arr.length-1; k++) {
                    System.out.printf("%3d %c", arr[k], k != j-1 ? ' ' : arr[j - 1] > arr[j] ? '+' : '-');
                }
                System.out.printf("%3d\n", arr[arr.length-1]);

                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = n;
                }
            }
            n = last;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬");
        System.out.print("요솟수 : ");

        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
