package chap06.practice;

import java.util.Stack;

public class Q14_B {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static int midVaule(int[] arr, int a, int b, int c) {
        if (arr[b] < arr[a]) swap(arr,b,a);
        if (arr[c] < arr[b]) swap(arr,c,b);
        if (arr[b] < arr[a]) swap(arr,b,a);

        return b;
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;

            for (j = i; j > 0 && arr[j-1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        int count = 1;

        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {

            for (int i = lstack.size() - 1; i >= 0; i--) {
                if (i == lstack.size() - 1) System.out.println("Phase [" + count++ + "]");
                System.out.printf("| %2d , %2d | %c", lstack.elementAt(i), rstack.elementAt(i), '\n');
            } System.out.println("-----------");


            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int m = midVaule(arr, left, (pl + pr) / 2, pr);
            int x = arr[m];
            swap(arr, m, right - 1);
            pl++; pr--;

            do {
                while (arr[pl] < x) pl++;
                while (arr[pr] > x) pr--;
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);

            if (pr - left < right - pl) { // If right size is bigger than left, push right before pushing left
                int temp;
                temp = left;
                left = pl;
                pl = temp;

                temp = right;
                right = pr;
                pr = temp;
            }

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }

            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,4,67,3,2,2,3425,6,345,76,367,3,66,76,86,4789,598,9,3};
        quickSort(arr, 0 , arr.length-1);
        for (int tmp : arr) System.out.println(tmp);
    }
}
