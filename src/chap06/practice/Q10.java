package chap06.practice;

import java.util.Scanner;

public class Q10 {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {

        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", arr[i]);
        System.out.printf("%d}\n", arr[right]);

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }


    static void quickSortN(int[] arr, int left, int right) {

        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    static void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }
    // Overloading

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 입력 : ");
        int temp = sc.nextInt();
        int[] arr = new int[temp];

        for (int i = 0; i < temp; i++) {
            System.out.print("요수 입력 : ");
            arr[i] = sc.nextInt();
        }

        quickSort(arr, temp);
        System.out.println();

        for (int tmp : arr) {
            System.out.printf("%3d ", tmp);
        }

    }
}
