package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] x = {
                "abstract", "assert",   "boolean",  "class",    "native"
        };

        System.out.print("원하는 키워드를 입력하세요 : ");
        String ky = sc.next();

        int idx = Arrays.binarySearch(x, ky );
        if (idx < 0)
            System.out.println("해당 키워드가 없습니다.");
        else
            System.out.println("해당 키워드는 x[" + idx + "]에 있습니다.");

        /* 스트링 클래스를 binarySearch에서 비교 가능한 이유는
         * 스트링 클래스가 Comparable<T> 인터페이스와 compareTo 메서드를 구현하고 있기 때문이다.
         * 해당 인터페이스 구현체와, 메서드를 통해 배열이 자연정렬되어 binSearch에서 비교 가능하게 함
         * 자연정렬로 정렬되지 않은 배열의 경우 제네릭 메서드를 사용하여 binSearch 수행
         * binSearch(T[] a, T key, Comparator<? super T> c) // T또는 T의 슈퍼클래스로 생성한 두객체의 대소관계를 판단하기 위한 comparator
         * comparator 내부에 compare 메서드가 있음
         * <? extends T> : 무엇이든 T의 서브클래스만 허용
         * <? super T> : 무엇이든 T의 상위클래스만 허용
         * <T extends Number> : Number의 서브클래스인 T만 허용
         * <T super Number> : Number를 상위클래스로하는 T만 허용
         */

    }
}
