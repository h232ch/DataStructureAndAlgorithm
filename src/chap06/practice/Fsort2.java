package chap06.practice;

import java.util.Scanner;

public class Fsort2 {

    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) // 1단계 : 도수분포표 만들기
            f[a[i]]++;
        
        for (int i = 0; i < max; i++) // 2단계 : 누적도수분포표 만들기
            f[i+1] += f[i];
        
        for (int i = n - 1; i >= 0; i--) // 3단계 : 목적 배열 만들기
            b[--f[a[i]]] = a[i];

        for (int i = 0; i < n; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 입렵 : ");
        int nx = sc.nextInt();
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                a[i] = sc.nextInt();
            } while (a[i] < 0);
        }

        int max = a[0];
        for (int i = 1; i < nx; i++)
            if (max < a[i]) max = a[i];

        fSort(a, nx, max);

        for (int tmp : a) System.out.println(tmp);
    }
}
