package chap06.practice;

import java.util.Scanner;

public class Q19 {

        static void fSort (int[] a, int n, int min, int max){
            int[] f = new int[max - min + 1]; // 누적도수
            int[] b = new int[n]; // 작업용 목적배열

            System.out.println(max - min + 1);

            for (int i = 0; i < n; i++)
                f[a[i] - min]++; // 1단계

            System.out.println("1 단계 F (도수분포표) : ");
            for (int i = 0; i < n ; i++) // 2단계 출력
                System.out.printf("%2d %c", a[i], (i == n - 1) ? '\n' : ',');

            for (int i = 0; i < max - min; i++)
                f[i+1] += f[i]; // 2단계

            System.out.println("2 단계 F (누적도수분포표) : ");
            for (int i = 0; i < max - min + 1 ; i++) // 2단계 출력
                System.out.printf("%2d %c", f[i], (i == (max - min)) ? '\n' : ',');
            
            for (int i = n - 1; i >= 0; i--)
                b[--f[a[i] - min]] = a[i]; // 3단계
            for (int i = 0; i < n; i++)
                a[i] = b[i]; // 4단계
        }

        public static void main(String[] args) {
//            Scanner stdIn = new Scanner(System.in);
//
//            System.out.println("도수정렬 ");
//            System.out.print("요솟수：");
//            int nx = stdIn.nextInt();
//            int[] x = new int[nx];
//
//            for (int i = 0; i < nx; i++) {
//                do {
//                    System.out.print("x[" + i + "]：");
//                    x[i] = stdIn.nextInt();
//                } while (x[i] < 0);
//            }

            int[] x = {9,7,5,4,10};
            int nx = x.length;

            int max = x[0];
            for (int i = 1; i < nx; i++)
                if (x[i] > max)
                    max = x[i];

            int min = x[0];
            for (int i = 1; i < nx; i++)
                if (x[i] < min)
                    min = x[i];

            fSort(x, nx, min, max); // 배열 x를 도수정렬

            System.out.println("오름차순으로 정렬했습니다.");
            for (int i = 0; i < nx; i++)
                System.out.println("x[" + i + "]＝" + x[i]);
        }
    }
