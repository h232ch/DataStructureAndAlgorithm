package chap02;

public class PrimeNumberPrac {
    static int[] primeNumber(int objNum){

        int ptr = 0;
        int counter = 0;
        int checkNum;
        int[] primeNum = new int[30]; // 어떠한 값의 소수여부 판단은 해당 값을 해당 값 이하의 소수값과 나누어 떨어지는지 확인하면 됨
        primeNum[ptr++] = 2; // 소수를 저장할 공간을 생성하고 0번째 요소에 2를 넣는다 (2는 짝수이면서 소수인 유일한 짝수 소수값)

        for (int i = 3; i <= objNum; i+=2){ // 2를 제외한 소수는 홀수이다를 전제로 3, 5, 7.. 2씩 증가하는 반복문 작성
            for (checkNum = 1; checkNum < ptr; checkNum++){ // ptr을 사용하여 primeNum에 저장되어있는 소수를 하나씩 꺼내온뒤 i값과 나누어봄
                counter++;
                if(i%primeNum[checkNum] == 0) // 만약 0으로 떨어진다면, 소수가 아님으로 판단하고 반복문을 빠져나감
                    break;
            }
            if(checkNum==ptr){ // 반복문이 종료된 후 checkNum값과 ptr값을 비교하여 동일하다면 소수로 판단
                primeNum[ptr++] = i;
            }
        }
        return primeNum;
    }
    public static void main(String[] args){
        for(int num: primeNumber(100)){
            System.out.print(num+" ");
        }


    }
}
