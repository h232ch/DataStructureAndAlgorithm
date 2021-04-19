package chap06;

import java.util.Scanner;

public class Fsort {

    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) // 1단계 : 도수분포표 작성, a{1,3,5,6,6} -> f{0,1,0,1,0,1,2}
            f[a[i]]++;

        for (int i = 1; i <= max; i++) // 2단계 : 누적도수분포표 작성 f{0,1,1,2,2,3,5} (도수분포표를 누적해서 더함)
            f[i] += f[i - 1];
        
        for (int i = n - 1; i >= 0; i--) // 3단계 : 목적 배열 만들기 (누적도수분포표 기준)
            // a{1,3,5,6,6} -> f{0,1,1,2,2,3,5} -> b{1,3,5,6,6}  (a의 4번 요소의 값을 f 요소의 값의 자리로(6 -> f{--5 = 4}, b의 4번 요소 자리에 6입력 (이후에는 3이됨)
            b[--f[a[i]]] = a[i];

        for (int i = 0; i < n; i++) // 4단계 : 배열 복사
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++) {
            if (x[i] > max) max = x[i];
        }

        fSort(x, nx, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);

    }
}
