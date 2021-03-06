package chap06;

import java.util.Scanner;

public class BubbleSort {

    public static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    } // j-1(앞), j(뒤) 값을 비교해서 j값이 작다면 j-1과u 바꿔주는 메서드

    public static void bubbleSort(int[] a, int n) {
        for (int i=0; i<n-1; i++) {
            for (int j=n-1; j>i; j--) {
                if(a[j-1] > a[j])
                    swap(a, j-1, j);
            }
            System.out.println("pass : "+i);
        }
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

    }
}
