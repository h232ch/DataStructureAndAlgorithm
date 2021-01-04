package chap06.practice;

public class binSearch {

    public static int binSer(int[] a, int num) {
        int pl = 0;
        int pr = a.length - 1;
        int pc = -1;

        do {
            pc = (pl + pr) / 2;
            if (a[pc] == num) break;
            else if (a[pc] < num) pl = pc + 1;
            else pr = pc - 1;
        } while (pl <= pr);
        return pc;
    }

    public static void main(String[] args) {

        int[] arr = {2,4,8,10,12,14,16,18};
        System.out.println(binSer(arr, 3));


    }
}
