package chap03;

public class Q5 {


    static int binSearchX(int[] a, int key){

        int st = 0;
        int la = a.length-1;

        for (int i = 0; st <= la; i++){
            int mid = (st+la)/2;
            if (key == a[mid])
                // to do 
                return mid;
            else if (key < a[mid])
                la = mid - 1;
            else
                st = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        int key = 3;

        System.out.println(binSearchX(arr,key));
    }
}
