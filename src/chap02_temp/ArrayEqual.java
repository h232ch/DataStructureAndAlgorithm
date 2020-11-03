package chap02_temp;

public class ArrayEqual {
    static boolean equals(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){

        int[] a = {1,2,3,4,5};
        int[] b = a.clone();
        int[] c = {1,2,3,4,5};



        System.out.println(equals(a,b)?"It's equal":"It's different");
        System.out.println(equals(a,c)?"It's equal":"It's different");
        
    }
}
