package chap06.practice;

public class Q8 {

    public static int binSearch(int[] arr, int num) {
        int pl = 0;
        int pr = arr.length - 1;
        int pc;
        int pd;

        do {
            pc = (pl + pr) / 2;
            if (arr[pc] == num) return pc;
            else if (arr[pc] < num) pl = pc + 1;
            else pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    public static void binSearch2(int[] arr, int num) {
        int pl = 0;
        int pr = arr.length - 1;
        int pc;
        int pd;

        do {
            pc = (pl + pr) / 2;
            if (arr[pc] == num) break;
            else if (arr[pc] < num) pl = pc + 1;
            else pr = pc - 1;
        } while (pl <= pr);

        System.out.println(pc);
    }

    public static void insertSortWithBinSearch(int[] arr) {

        int leng = arr.length;
        int j;
        int pl;
        int pr;
        int pc;
        int pd;
        for (int i = 1; i < leng; i++) {
            int temp = arr[i];
            pl = 0;
            pr = i - 1;

            do {
                pc = (pl + pr) / 2;
                if (arr[pc] == temp)
                    break;
                else if (arr[pc] < temp)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);

            pd = (pl <= pr) ? pc + 1 : pr + 1;
            System.out.println(pd);

            for (j = i; j > pd; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {23,6,23,4,5,6,3,2,13};
        insertSortWithBinSearch(arr);

        for (int temp : arr) {
            System.out.printf("%3d", temp);
        }

    }
}
