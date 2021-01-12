package chap06.practice;

public class Q14 {

    static void swap(int[] arr, int idx1, int idx2) {

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void insertionSortCustom(int[] arr, int left, int right) {
        int gap = (left + right)/2;
        for (int i = gap; i <= right; i+=gap) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - gap] > temp; j-=gap)
                arr[j] = arr[j - gap];
            arr[j] = temp;
        }
    }

    static int selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) swap(arr, i, j);
            }
        }
        return arr[arr.length / 2];
    }

    static void insertionSort(int[] arr) {
        int leng = arr.length;

        for (int i = 1; i < leng; i++) {
            int temp = arr[i];
            int j;

            for (j = i; j > 0 && arr[j - 1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    static void quickSort(int[] arr, int left, int right) {

        if (right + left < 10)
            insertionSort(arr);

        else {

            insertionSortCustom(arr,left,right);
            swap(arr, (left + right) / 2, right - 1);

            int pl = left;
            int pr = right;
            int x = arr[(left + right) / 2];

//            int[] xarr = {arr[left], arr[(left+right)/2], arr[right]}; // Mid Version 1
//            int x = selectionSort(xarr);

            do {
                while (arr[pl] < x) pl++;
                while (arr[pr] > x) pr--;
                if (pl <= pr) swap(arr, pl++, pr--);
            } while (pl <= pr);

            if ((pr - left) > (right - pl)) {
                int temp = pl;
                pl = left;
                left = temp;

                temp = pr;
                pr = right;
                right = temp;
            }

            if (left < pr) quickSort(arr, left, pr);
            if (right > pl) quickSort(arr, pl, right);
        }
    }



    public static void main(String[] args) {
        int[] arr = {3,5,46,7,2,35,7,4,5,35,677,8,86,9,9,9,6,5645,65,4,4343,4,3,34,4,2,3,32,2,4,9};

        quickSort(arr, 0, arr.length - 1);
        for (int tmp : arr) System.out.println(tmp);


//        int[] tarr = {4,3,5,2,1,5,6,7,3};
//        insertionSortCustom(tarr, 0, tarr.length - 1);
//        swap(tarr, 4, 7);
//        for (int temp : tarr) System.out.println(temp);
    }


}
