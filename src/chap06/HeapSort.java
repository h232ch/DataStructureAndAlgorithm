package chap06;

import java.util.Scanner;

public class HeapSort {


    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void downHeap(int[] a, int left, int right) { // DownHeap은 맨 아래 부모 leap에서 위로 올라감 (10개의 leap ->
        System.out.println(left + " " + right);
        int temp = a[left]; // 삽입 정렬과 비슷한 구조
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) { // 힙을 만드는 과정은 n/2회 수행하면 됨
            int cl = parent * 2 + 1; // 왼쪽 자식
            int cr = cl + 1; // 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 오른쪽이 존재하지 않을 경우 대비, cr > cl 값 비교
            System.out.println(child);
            if (temp >= a[child]) // 
                break;
            a[parent] = a[child];
        }
        a[parent] = temp; // 삽입 정렬과 비슷한 구조
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            downHeap(a, i, n - 1);

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("힙정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
