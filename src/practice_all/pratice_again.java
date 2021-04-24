package practice_all;

public class pratice_again {


    static void swap(int[] a, int i, int j) {
        int temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void bubble(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, min, i);
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {5, 4, 7, 3, 6, 7, 8, 4, 3,};
        selectionSort(a);
        for (int temp : a) {
            System.out.printf("%3d", temp);
        }
    }
}
