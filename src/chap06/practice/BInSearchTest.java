package chap06.practice;

public class BInSearchTest {
    public static int binSearch(int[] arr, int num) {

        int pl = 0;
        int pr = arr.length - 1;
        int pc = -1;

        while (pl <= pr) {
            pc = (pl + pr) / 2;

            System.out.println("PL : " + pl + ", PR : " + pr + ", PC : " + pc);

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%3c%3c", (i == pc) ? 'C' : ' ', (i != arr.length-1) ? ' ' : '\n');
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%3d%3c", arr[i], (i != arr.length-1) ? ' ' : '\n');
            }

            if (arr[pc] == num) return pc;
            else if (arr[pc] < num) pl = pc + 1;
            else pr = pc - 1;
        }

        return pc;
    }

    public static void main(String[] args) {

        int[] arr = {2,2,3,5,6,7,9,10};
        System.out.println(binSearch(arr, 1));
    }
}
