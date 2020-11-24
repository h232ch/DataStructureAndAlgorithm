package chap03;

import java.util.Scanner;

public class Q6 {

    static int binSearchX(int[] a, int n, int key){

        int st = 0;
        int la = n - 1;
        for (int i=0; st <= la; i++){
            int mid = (st + la) / 2;
            if (a[mid] == key && a[mid-1] == key) {
                for (int j = mid - 1; j >= 0; j--) {
                    if (j == 0 && a[j] ==key)
                        return j;
                    if (a[j-1] != key)
                        return j;
                } return mid-1;
            } else if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                st = mid + 1;
            } else {
                la = mid - 1;
            }
        } return -1;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int[] a = {2,2,2,2,2,2,2,8,9,10};
        int n = a.length;
        System.out.println(binSearchX(a,n,2));

        int sum = 20;
        System.out.println(sum>>>1);

    }
}
