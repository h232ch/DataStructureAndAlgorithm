package chap06.practice;

import java.util.Stack;

public class Q13 {


    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {

        if (right - left < 10) {
            System.out.println("Simple Insertion Sort...");
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j > 0 && arr[j-1] > temp; j--) {
                    arr[j] = arr[j-1];
                }
                arr[j] = temp;
            }

        } else {
            System.out.println("Quick Sort..");
            Stack<Integer> lstack = new Stack<>();
            Stack<Integer> rstack = new Stack<>();

            lstack.push(left);
            rstack.push(right);

            int count = 1;

            while (!lstack.isEmpty()) {

                for (int i = lstack.size() - 1; i >= 0; i--) {
                    if (i == lstack.size() - 1) System.out.println("Phase [" + count++ + "]");
                    System.out.printf("| %2d , %2d | %c", lstack.elementAt(i), rstack.elementAt(i), '\n');
                } System.out.println("-----------");

                int pl = left = lstack.pop();
                int pr = right = rstack.pop();
                int x = arr[(left + right) / 2];

                do {
                    while (arr[pl] < x) pl++;
                    while (arr[pr] > x) pr--;
                    if (pl <= pr)
                        swap(arr, pl++, pr--);
                } while (pl <= pr);

                if ((pl - left) > (right - pr)) {
                    if (left < pr) {
                        lstack.push(left);
                        rstack.push(pr);
                    }

                    if (pl < right) {
                        lstack.push(pl);
                        rstack.push(right);
                    }

                } else {
                    if (pl < right) {
                        lstack.push(pl);
                        rstack.push(right);
                    }

                    if (left < pr) {
                        lstack.push(left);
                        rstack.push(pr);
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {5,4,8,7,8,9,15,1,23,4,55};
        int leng = arr.length;

        quickSort(arr, 0, leng - 1);
        for (int tmp : arr)
            System.out.println(tmp);
    }
}
