package practice_all;

public class BinSearch2 {

    static int binSearch(int[] arr, int obj) { // O(log n)
        int pl = 0;
        int pr = arr.length - 1;

        do {
            int pc = (pl + pr) / 2;
            if (arr[pc] == obj) {
                return pc;
            } else if (arr[pc] < obj) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        return -1;
    }

    static int seqSearch(int[] arr, int obj) { // O(n)
        arr[arr.length - 1] = obj;
        int i = 0;
        for ( ; ; ) {
            if (arr[i] == obj) {
                break;
            }
            i++;
        }
        return i == arr.length - 1 ? -1 : i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(binSearch(arr, 7));
        System.out.println(seqSearch(arr, 7));
    }
}
