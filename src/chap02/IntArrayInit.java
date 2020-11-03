package chap02;

public class IntArrayInit {

    public static void main(String[] args){
        int[] a = new int[5]; // 5개의 요소를 갖는 배열 생성 (요소는 0으로 초기화됨)
        int[] b = {1,2,3,4,5}; // 배열 생성과 동시에 원하는 값으로 초기화

        a = b.clone(); // b 배열을 a배열으로 복사

        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }

        int i=0;
        while(i<b.length){
            System.out.println(b[i]);
            i++;
        }

        i=0;
        do{
            System.out.println(b[i]);
            i++;
        }while(i<b.length);

        for(int value : b){
            System.out.println(value);
        }


    }
}
