package chap02;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTest2 {
    public static void main(String[] args){
        int[][] a = {{1,2,3,4}, {5,6,7}};
        int[][] b = a.clone(); // 얇은복사 : 요소의 주소값을 같는 변수가 생성됨 , 깊은 복사는 새로운 조수값에 요소가 저장되고 그 주소값을 같는 변수가 생성됨
        // 얇은복사에서 b[0][0]을 삭제할 경우 a[0][0] 또한 삭제됨 (이유 : 같은 메모리를 참조하고 있기 때문이다.)

        System.out.println(a);
        System.out.println(b);

        System.out.println(a[0]);
        System.out.println(b[0]);

        b[0][0] = 10;
        System.out.println(a[0][0]);

        double[] dNum = {1.0, 2.0, 3.0};
        int sum = 0;
        for(double n : dNum){
            System.out.println("dNum["+n+"]");
            sum += n;
        }
        System.out.print("dNum의 Sum값 : "+sum);
        System.out.println();

        sum = 0;
        for(int i = 0; i < dNum.length; i++){
            System.out.println("dNum["+dNum[i]+"]");
            sum += dNum[i];
        }

        System.out.print("dNum의 Sum값 : "+sum);
        System.out.println();

        Iterator<Double> itr = Arrays.stream(dNum).iterator();
        // Collection Framework에서 요소를 읽어오기 위해 제공하는 라이브러리
        while (itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}
