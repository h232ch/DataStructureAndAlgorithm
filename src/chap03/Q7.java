package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {


    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }
    }

    public static Comparator<PhyscData> COMPARATOR = new EyeCompare();
    private static class EyeCompare implements Comparator<PhyscData> {
        @Override
        public int compare(PhyscData o1, PhyscData o2) {
            return (o1.vision > o2.vision) ? 1 :
                    (o1.vision < o2.vision) ? -1 : 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("미스터김", 170, 1.1),
                new PhyscData("미스터김", 156, 1.3),
                new PhyscData("미스터김", 189, 1.4),
                new PhyscData("미스터김", 190, 1.5),
                new PhyscData("미스터김", 148, 1.6)
        };

        System.out.print("찾는 시력을 입력하세요 : ");
        double key = sc.nextDouble();

        int idx = Arrays.binarySearch(x, new PhyscData("", 0, key), COMPARATOR);
        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else
            System.out.println("찾는 데이터 : " + x[idx]);

    }
}
