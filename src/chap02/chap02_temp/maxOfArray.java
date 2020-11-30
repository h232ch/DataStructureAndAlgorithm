package chap02.chap02_temp;

import java.util.Scanner;

public class maxOfArray {

    static int maxOf(int[] a){ // 매개변수 a는 전달되는 배열변수 height의 주소값을 갖는다. (Call by Reference 참조값을 넘겨줌)
        /**
         * Call by value와 Call by reference 는 각각의 특징이 있는데, Call by value의
         * 경우 데이터(값)을 복사해서 함수로 전달하기 때문에 원본의
         * 데이터(값)가 변경 될 가능성이 없지만, 인자를 넘겨줄 때 마다 메모리의
         * 공간을 할당하기 때문에 메모리 공간을 좀 더 잡아먹게 된다. Call by reference의
         * 경우 위에서 언급한 메모리 공간 할당의 문제를 벗어나게 되었지만 대신에
         * 원본의 데이터(값)를 훼손할 수 있다는 문제점이 있다. 그러므로 상황에 따라 적절하게 선택하여 사용하면 될 것이다.
         */
        
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Plz Input Array Size : ");

        int num = sc.nextInt();

        int[] height = new int[num];

        for(int i=0; i<num; i++){
            System.out.println("Plz Input height["+i+"]");
            height[i] = sc.nextInt();
        }
        System.out.println("Max Number of Height Array : "+maxOf(height));
    }
}
