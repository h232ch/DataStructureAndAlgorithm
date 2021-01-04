package chap06.practice;

public class InsertionSort_test2 {

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void insertionEnhanced(int[] arr) {

        int leng = arr.length;

        for (int i = 1; i < leng; i++) {

            int pl = 0;
            int pr = leng - 1;
            int pc;
            int temp = arr[i];

            do {
                pc = (pl + pr) / 2;
                if (arr[pc] == temp) break;
                else if (arr[pc] < temp) pl = pc + 1;
                else pr = pc - 1;
            } while (pl <= pr);


        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,2,2,4,52,34};
        insertionSort(arr);

        for (int temp : arr) {
            System.out.printf("%3d", temp);
        }
    }
}
