package practice_all;

import chap06.Partition;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lambdaPrac {



    public static void main(String[] args) {


        // Before lambda
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Welcome to the world");
            }
        }).start();

        // After lambda
        new Thread(() -> {
            System.out.println("Welcome to the world 2");
        }).start();

        // 함수형 인페이스 Match 사용
        // 인터페이스의 구현체를 초기화와 동시에 생성하여 사용함
        LambdaMatch match = ((first, second) -> first + second); // 익명 클래스의 역할과 같음
        System.out.println(match.Calc(4, 2));

        LambdaMatch matchMin = ((first, second) -> first - second);
        System.out.println(matchMin.Calc(10, 5));

        // Stream
        // filter : 조건
        // count : 실행 (스트림 마지막에 1회 실행)
        IntStream.range(1, 11).filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        // 0-1000 까지의 값중 500 이상, 짝수, 5의 배수인 수의 합을 구함
        System.out.println(
                IntStream.range(0, 1001)
                        .skip(500)
                        .filter(i -> i % 2 == 0)
                        .filter(i -> i % 5 == 0)
                        .sum()
        );


        List<String> strList = Arrays.asList("1,2,3,4,5,6".split(","));
        List<Integer> intList = Parser2.strToIntList(strList);

        int sum = 0;

        for (Integer val : intList) {
            sum += val;
        }

        System.out.println(sum);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Stream<Integer> stream = list.stream(); // list를 스트림으로 변경
        stream.forEach((Integer i) -> {
            System.out.println(i);
        });

        Stream.of("b1", "a2", "a3", "a4")
                .map(s -> s.substring(1)) // Stream.of의 데이터가 s로 입력됨
                .mapToInt(Integer::parseInt) // 2번째 문자를 String에서 ㅗ
                .forEach(System.out::println);

        Stream.of("a1", "a2", "a3", "a4")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println); // 앞의 함수가 처리한 결과값에 대해 결과 처리후 종료 (반복문을 빠저나가는 효과)

        Stream.of("d2", "a2", "b1", "b3", "c") 
                .map(s -> {
                    System.out.println("map : " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch : " + s);
                    return s.startsWith("A");
                });

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c1", "c2");

        myList.stream() // myList를 스트림으로 생성
                .filter(s -> s.startsWith("c")) // 생성한 스트림을 filter를 적용해서 "c"로 시작하는 문자열 검색
                .map(String::toUpperCase) // 결과를 스트링, 대문자로 표기
                .sorted() // 결과를 정렬해서
                .forEach(System.out::println); // 출력한다.

        myList.stream()
                .findFirst() // 첫번째 원소를 받는다.
                .ifPresent(System.out::println); // 첫번째 원소 존재시 출력 후 종료

        IntStream.range(1, 5)
                .forEach(System.out::println);

        Arrays.stream(new int[]{1, 3, 5})
                .map(n -> 2 * n + 1) // n은 요소, -> 뒤는 리턴값, 모두 받아 스트림에 저장
                .average() // 해당 스트림에서 원소의 평균을 구함
                .ifPresent(System.out::println);

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter : " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach : " + s));


        System.out.println(Integer.MIN_VALUE);

        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testList.add(i);
        }

        int a = 10;
        a = (short) 10;

        short b = 10;
        b = (int) 10;

        int c = (int) b; // 업캐스틩 이경우 캐스팅을 명시할 필요 없음음

        // 업캐스팅 사용 이유는 다형성성

      System.out.println(a + b);

        // 아래 코드는 에러 발생 (toArray의 리턴값은 Object 형으로 상위 -> 하위(Integer)로 캐스팅 불가
//        Integer[] testArray1 = (Integer[]) testList.toArray();

        Integer i = new Integer(10);

    }
}

