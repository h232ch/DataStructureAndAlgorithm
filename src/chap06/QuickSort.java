package chap06;

import java.util.Scanner;

public class QuickSort {

    static void swap(int[] a, int idx1, int idx2) {
        // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void partition(int[] a, int n) {

        int pl = 0; // 왼쪽 커서
        int pr = n - 1; // 오른쪽 커서
        int x = a[n / 2]; // 피벗값

        do {
            while (a[pl] < x) pl++; // 왼쪽 커서가 피벗보다 작을때까지 반복
            while (a[pr] > x) pr--; // 오른쪽 커서가 피벗보다 클때까지 반복
            if (pl <= pr) // 왼쪽 커서가 오른쪽 커서보다 작거나 같다면 Swap 호출
                swap(a, pl++, pr--);
        } while (pl <= pr);

        System.out.println("피벗의 값은 " + x + "입니다.");

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl - 1; i++) // a[0] ~ a[pl - 1];
            System.out.print(a[i] + " ");
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗과 일치하는 그룹");
            for (int i = pr + 1; i <= pl - 1; i++) // a[pr + 1] ~ a[pl - 1];
                System.out.print(a[i] + " ");
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }


    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("배열을 나눕니다.");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);

    }
}
