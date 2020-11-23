package chap02;

public class PrimeNumber3 {

    public static void main(String[] args){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        /*
        2를 제외한 짝수는 소수가 없다, 홀수 소수의 제곱은 소수가 아니다 (3*3)
        N이 소수인지 판단하기 위해서는 N의 제곱근(n==25 : 5) 하위의 소수와 나누어보면 됨
        제곱근을 구하지 않고 소수를 제곱하여 비교함 (3*3 <= 25, 5*5 <=25)
        위 조건을 포함하여 코드 수행시 계산값을 현저히 줄일 수 있음

         */

        for (int n = 5 ; n <= 1000; n += 2){
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++){
                counter += 2;
                if (n % prime[i] == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                prime[ptr++] = n;
                counter++;
            }
        }
        for(int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }
        System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
    }
}
