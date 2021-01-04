package chap06;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {12,34,64,3,6,63,3,4};
        shellSort(arr);

        for (int temp : arr) {
            System.out.println(temp);
        }
    }
}
