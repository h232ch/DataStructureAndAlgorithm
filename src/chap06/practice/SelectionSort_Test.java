package chap06.practice;

public class SelectionSort_Test {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        int leng = arr.length;

        for (int i = 0; i < leng - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < leng ; j++) {
                if (arr[j] < arr[temp])
                    temp = j;
            }
            swap(arr, i, temp);
        }
    }
}
