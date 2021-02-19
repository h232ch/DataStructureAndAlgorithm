package practice_all;

public class QuickSort {


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 4, 76, 87, 6, 5, 3, 3};
        quickSort(arr, 0, arr.length - 1);
        for (int temp : arr) {
            System.out.printf("%3d", temp);
        }
    }
}
