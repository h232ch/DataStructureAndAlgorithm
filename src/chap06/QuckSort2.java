package chap06;

import chap04.IntStack;

import java.util.Stack;

public class QuckSort2 {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = arr[(left + right) / 2];

            do {
                while (arr[pl] < x) pl++;
                while (arr[pr] > x) pr--;
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);

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
        int[] arr = {5,7,1,4,6};
        int leng = arr.length;

        quickSort(arr,0, leng - 1);
        for (int temp: arr) {
            System.out.println(temp);
        }
    }
}
