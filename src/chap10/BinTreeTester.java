package chap10;

import java.util.Comparator;
import java.util.Scanner;

public class BinTreeTester {

    static Scanner stdIn = new Scanner(System.in);

    // 데이터 (회원번호 + 이름)
    static class Data {
        public static final int NO = 1; // 번호 입력 받습니까?
        public static final int NAME = 2; // 이름을 입력 받습니까?

        private Integer no; // 회원번호 (키 값)
        private String name; // 이름

        // 키값
        Integer keyCode() {
            return no;
        }

        // 문자열을 반환합니다.
        public String toString() {
            return name;
        }

        // 데이터를 입력합니다.
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요");
            if ((sw & NO) == NO) { // 비트연산 1100 & 1000 = 1000;
                System.out.printf("번호 : ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) { // 1100 & 0100 = 0100;
                System.out.printf("이름 : ");
                name = stdIn.next();
            }
        }
    }

    enum Menu {
        ADD("삽입"),
        REMOVE("종료"),
        SEARCH("검색"),
        PRINT("표시"),
        MIN("최소값"),
        MAX("최대값"),
        MIN_DATA("최소값의 데이터"),
        MAX_DATA("최대값의 데이터"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }

        Menu(String string) { // 생성자
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    // 메뉴 선택
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
            }
            System.out.printf(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
        // enm ordinal = stirng 순서
        return Menu.MenuAt(key);
    }



    public static void main(String[] args) {

        class dataComp implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? -1 : (o1 > o2) ? 1 : 0;
            }
        }
        final dataComp INT_COMP = new dataComp();

        Menu menu; // 메뉴
        Data data; // 추가용 데이터 참조
        Data ptr; // 검색용 테이터 참조
        Data temp = new Data(); // 입력용 데이터
        BinTree<Integer, Data> tree = new BinTree<>(INT_COMP);

        do {
            switch (menu = SelectMenu()) {
                case ADD:
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME); // "1000 | 0100 = 1100"
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE:
                    temp.scanData("삭제", Data.NO); // 1000
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH:
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.keyCode());
                    if (ptr != null) {
                        System.out.println("그 번호의 이름은 " + ptr + "입니다.");
                    } else {
                        System.out.println("해당 데이터가 없습니다.");
                    }
                    break;

                case MIN:
                    System.out.println("Min Key is " + tree.getMinKey());
                    break;

                case MAX:
                    System.out.println("Max Key is " + tree.getMaxKey());
                    break;

                case MIN_DATA:
                    System.out.println("Min Data is " + tree.getDataWithMinKey());
                    break;

                case MAX_DATA:
                    System.out.println("Max Data is " + tree.getDataWithMaxKey());
                    break;

                case PRINT: // 모든 노드를 키 값의 오름차순으로 출력
                    tree.print();
//                    tree.printReverse();
                    break;
            }
        } while (menu != Menu.TERMINATE);

    }
}
