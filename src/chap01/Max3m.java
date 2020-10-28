package chap01;

public class Max3m {

    static int max(int a, int b, int c){
        int max = a;
        if(b>max) b=max;
        if(c>max) c=max;
        return max;
    }

    public static void main(String[] args){

        System.out.println("max3(3,2,1) = "+max(3,2,1));
        System.out.println("max3(10,12,9) = "+max(10,12,9));
        System.out.println("max3(515,2,1) = "+max(515,2,1));

    }
}
