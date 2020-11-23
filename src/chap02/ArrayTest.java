package chap02;

public class ArrayTest {
    public static void main(String[] args){
        int[][] a = {{1,2,3},{1,2,3}};
        int[][] b = a.clone();

        System.out.println(a[0][0]);
        System.out.println(b[0][0]);

        System.out.println(a.equals(b));


        System.out.println(a[0]); // 다차원 배열의 경우 구성 요소는 복사되고 요소는 참조한다
        System.out.println(b[0]);

        double[] dNum = {1.0, 2.0, 3.0, 4.0};

        for(int i = 0; i< dNum.length; i++){
            System.out.println("a["+ i + "] = " + dNum[i]);
        }
        double sum = 0;

        for (double i: dNum){
            sum+=i;
        }
        System.out.println("모든 요소의 합은 " + sum + " 입니다.");

    }
}
