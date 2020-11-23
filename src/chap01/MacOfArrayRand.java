package chap01;

import java.util.Random;
import java.util.Scanner;

public class MacOfArrayRand {

    static int maxOf(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length;i++){
            if(a[i] > max){
                max = a[i];
            }
        }return max;
    }

    public static void main(String[] args){
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Plz input Size Number");
        int num = sc.nextInt();

        int[] height = new int[num];

        System.out.println("The key values are ..");
        for (int i = 0; i < num; i++){
            height[i] = random.nextInt(90); // 요소값을 난수로 대입
            System.out.println("height["+height[i]+"]");
        }
        System.out.println("Max number is "+maxOf(height));
    }
}
