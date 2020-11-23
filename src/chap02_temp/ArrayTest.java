package chap02_temp;

public class ArrayTest {

    public static void main(String[] args){

//        int[] a = new int[4];
        int[] a={1,2,3,4};
        int max=a[0];
        for (int i=1; i<a.length; i++){
            if(max<a[i]) max=a[i];
        }
        System.out.println(max);
        // 위와같은 서칭 알고리즘을 주사라고함 (Traverse searching -> 횡단하다, 가로지르다

    }
}
