package practice_all;

import java.util.Scanner;

public class RingBufer {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Input Size : ");
        int max = sc.nextInt();
        int[] ring = new int[max];
        int i = 0;

        while (true) {

            int idx = i % max;
            System.out.printf("Input Number[%d] : ", idx);
            ring[idx] = sc.nextInt();
            i++;
        }
    }
}
