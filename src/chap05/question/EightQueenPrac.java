package chap05.question;

public class EightQueenPrac {


    static int[] pos = new int[3];

    public static void print(){
        for (int t : pos) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void set(int n) {
        for (int j = 0; j < 3; j++){
            pos[n] = j;
            if (n == 2) {
                print();
            } else {
                set(n+1);
            }
        }
    }

    public static int set2(int n) {
        if (n < 3) {
//            System.out.println(n);
            return set2(n + 1);
        } else
            return 2;
    }

    public static void nQueen(int n) {
        while (n < 4) {

        }
    }


    public static void main(String[] args) {
        System.out.println(set2(0));
    }
}
