package chap06.practice;

public class BubbleLast {


    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
        return arr;
    }

    static int[] bubbleSortV2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    static int[] bubbleSOrtV3(int[] arr) {
        int n = 0;
        while (n < arr.length - 1) {
            int last = arr.length - 1;
            for (int j = arr.length - 1; j > n; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            n = last;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {12,3,45,3,56,6,4,32,4,5};
        for (int temp : bubbleSortV2(arr)) {
            System.out.printf("%3d", temp);
        } // 순회횟수 (n - 1 회), 비교횟수 (n(n - 1)회) = O(n2)
    }
}
