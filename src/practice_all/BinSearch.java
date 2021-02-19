package practice_all;

public class BinSearch {

    static int binSearch(int[] arr, int obj) {

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
    } // n(log n)

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        System.out.println(binSearch(arr, 5));
    }
}
