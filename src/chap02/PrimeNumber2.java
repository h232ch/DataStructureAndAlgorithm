package chap02;

public class PrimeNumber2 {


    public static void main(String[] args){

        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        for (int n=3; n<=1000; n+=2){ // 4, 6, 8, 10.. 2의 배수는 모두 소수가 아님으로 제외 (계산의 반이 줄어듬)
            int i;
            for(i=1; i<ptr; i++){
                counter++;
                if(n%prime[i] == 0){
                    break;
                }
            }
            if(ptr == i){
                prime[ptr++] = n; // prime 배열에 소수를 입력한다.
            }
        }

        for (int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }
        System.out.println("나눗셈을 실행한 횟수 : " + counter);
    }
}
