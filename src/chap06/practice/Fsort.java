package chap06.practice;

public class Fsort {


    static void fSort(int[] a, int max) {

        int n = a.length;
        
        int[] f = new int[max + 1];
        int[] b = new int[n];

        for (int i = 0; i < max + 1; i++) // 1단계 : 도수분포표 작성
            f[a[i]]++;
        
        for (int i = 0; i < max; i++) // 2단계 : 누적도수분포표 작성
            f[i+1] += f[i];
        
        for (int i = n - 1; i >=0; i--) // 3단계 : 목적 배열 만들기
            b[--f[a[i]]] = a[i];

        for (int i = 0; i < n; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {

        int[] a = {3,5,1,2,4,6,7,8,8};
        fSort(a, 8);

        for (int tmp : a) System.out.println(tmp);
    }
}
