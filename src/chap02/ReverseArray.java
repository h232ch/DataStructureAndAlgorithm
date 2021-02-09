package chap02;

public class ReverseArray {


    static void rcopy(int[] a, int[] b){
        int temp;

        for(int i = 0; i<=(a.length/2); i++){
            temp = a[i];
            b[i] = a[a.length-(i+1)];
            b[a.length-(i+1)] = temp;
        }

        for(int num: b){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        rcopy(a, b);
    }

}
