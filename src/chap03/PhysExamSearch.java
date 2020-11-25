package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1 : (o1.height < o2.height) ? -1 : 0; // 삼항식 if, else if 조건 ? 조건 ? 1 : 0
                /*
                HeightOrderComparator 클래스는 PhyscData를 갖는 Comparator를 implements 하고
                compare를 구현한다. 이때 compare는 PhyscData형을 받아서 두 객체의 height를 비교하고
                클경우 1, 작을경우 -1, 그외 0을 리턴한다.

                binSearch(배열, 키, Coparator 객체) -> binSearch는 배열에서
                키값을 찾기위해 Comparator 객체를 사용하여 정렬후 compare를 사용하여 키값을 찾음)

                 */

            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            PhyscData[] x = {
                    new PhyscData("이나령", 162, 0.3),
                    new PhyscData("유지훈", 168, 0.4),
                    new PhyscData("김한결", 169, 0.8),
                    new PhyscData("홍준기", 171, 1.5),
                    new PhyscData("전서현", 173, 0.7),
                    new PhyscData("이호연", 174, 1.2),
                    new PhyscData("이수민", 175, 2.0),
            };

            System.out.print("몇 cm인 사람을 찾고 있나요? : ");
            int height = sc.nextInt();
            int idx = Arrays.binarySearch(
                    x,
                    new PhyscData("", height, 0.0),
                    PhyscData.HEIGHT_ORDER // HEIGHT_ORDER로 정렬된 x 배열에 대해 height 검색
            );

            if (idx < 0)
                System.out.print("요소가 없습니다.");
            else
                System.out.println("x[" + idx + "]에 있습니다.");
                System.out.println("찾은 데이터 : " + x[idx]); //
        }
    }
}
