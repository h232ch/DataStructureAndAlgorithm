package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J4673 {

    static int[] selfNumber(int[] a) {
        boolean[] result = new boolean[10001];

        for (int i = 1; i <= a.length; i++) {
            int temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            sum += i;
            if (sum <= 10000) {
                result[sum] = true;
            }
        }

        for (int i = 1; i <= a.length; i++) {
            if (result[i] == false) {
                System.out.println(i);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[10000];
        selfNumber(a);
    }
}
