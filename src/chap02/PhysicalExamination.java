package chap02;

import java.util.Scanner;

public class PhysicalExamination {

    static final int VMAX = 21;
    static class PhyscData {
        String name; // 이름
        int height; // 키
        double vision; // 시력

        PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 평균키
    static double aveHeight(PhyscData[] data){
        double sum = 0;

        for(int i = 0; i < data.length; i++){
            sum += data[i].height;
        }
        return sum / data.length;
    }

    //
    static void distVision(PhyscData[] data, int[] dist){
        int i = 0;
        dist[i] = 0;
        for(i = 0; i < data.length; i++){
            if(data[i].vision >= 0.0 && data[i].vision <= VMAX / 10.0)
                dist[(int)(data[i].vision * 10)]++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("박현규", 172, 0.3),
                new PhyscData("최윤아", 162, 0.7),
                new PhyscData("최윤미", 158, 1.2),
                new PhyscData("홍연의", 160, 0.4),
                new PhyscData("김영준", 180, 0.4),
                new PhyscData("박용규", 170, 1.5),
        };
        int[] vdist = new int[VMAX];

        System.out.println("신체검사 리스트");
        System.out.println("이름\t키\t시력\t");
        System.out.println("-------------------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

        }
        System.out.printf("\n평균 키 : %5.1fcm\n", aveHeight(x));
        distVision(x, vdist);

        System.out.println("\n시력 분포");
//        for(int i = 0; i < VMAX; i++){
//            System.out.printf("%3.1f~:%2d명\n", i / 10.0, vdist[i]);
//        }

        for(int i = 0; i < VMAX; i++){ // Q10 : 시력분포를 *으로 나타내시오
            System.out.printf("%3.1f~: ", i / 10.0);
            for(int j = 0; j < vdist[i]; j++){
                System.out.print("*");
            }
            System.out.printf("\n");
        }
    }
}
