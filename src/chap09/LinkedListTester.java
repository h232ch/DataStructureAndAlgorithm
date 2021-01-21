package chap09;

import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {

    static Scanner sc = new Scanner(System.in);

    // 데이터 (회원번호 + 이름)
    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no; // 회원번호
        private String name; // 이름

        // 문자열을 변환합니다.
        public String toString() {
            return "(" + no + ")" + name;
        }
        
        // 데이터를 입력합니다.
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요");
            if ((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = sc.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.println(sw);
                System.out.println(NAME);
                System.out.print("이름 : ");
                name = sc.next();
            }
        }

        // 회원번호로 순서를 매기는 Comparator
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
        private static class NoOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.no.compareTo(o2.no);
            }
        }

        // 이름으로 순서를 매기는 comparator
        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();
        private static class NameOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        }
        
        // 메뉴 열거형
        enum Menu { // 클래스처럼 보이게하는 상수 (서로 관련있는 상수를 모아 심볼릭한 명칭의 집합으로 정의한 것)
            ADD_FIRST("머리에 노드를 삽입"),
            ADD_LAST("꼬리에 노드를 삽입"),
            RMV_FIRST("머리 노드를 삭제"),
            RMV_LAST("꼬리 노드를 삭제"),
            RMV_CRNT("선택 노드를 삭제"),
            CLEAR("모든 노드를 삭제"),
            SEARCH_NO("번호로 검색"),
            SEARCH_NAME("이름으로 검색"),
            NEXT("선택 노드로 이동"),
            PRINT_CRNT("선택 노드를 출력"),
            DUMP("모든 노드를 출력"),
            TERMINATE("종료");

            private final String message; // 출력할 문자열
            
            static Menu MenuAt(int idx) { // 서수가 idx인 열거를 반환
                for (Menu m : Menu.values())
                    if (m.ordinal() == idx)
                        return m;
                return null;
            }

            Menu(String string) { //
                message = string;
            }

            String getMessage() {
                return message;
            }
        }

        static Menu SelectMenu() {
            int key;
            do {
                for (Menu m : Menu.values()) {
                    System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
                    if ((m.ordinal() % 3) == 2 &&
                    m.ordinal() != Menu.TERMINATE.ordinal())
                        System.out.println();
                }

                key = sc.nextInt();

                System.out.println(key);
                System.out.println(Menu.TERMINATE.ordinal());
                System.out.println(Menu.ADD_FIRST.ordinal());

                System.out.println(" : ");
            } while (key < Menu.ADD_FIRST.ordinal() ||
            key > Menu.TERMINATE.ordinal());
            return Menu.MenuAt(key);
        }

        public static void main(String[] args) {
            Menu menu; // 메뉴
            Data data; // 추가용 데이터 참조
            Data ptr; // 검색용 데이터 참조
            Data temp = new Data(); // 입력용 데이터

            LinkedList<Data> list = new LinkedList<Data>(); // 리스트를 생성

            do {
                switch (menu = SelectMenu()) {
                    case ADD_FIRST :
                        data = new Data();
                        data.scanData("머리에 삽입", Data.NO | Data.NAME);
                        list.addFirst(data);
                        break;

                    case ADD_LAST:
                        data = new Data();
                        data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                        list.addLast(data);
                        break;

                    case RMV_FIRST: // 머리 노드 삭제
                        list.removeFirst();
                        break;
                    
                    case RMV_LAST:
                        list.removeLast();
                        break;

                    case RMV_CRNT: // 선택 노드를 삭제
                        list.removeCurrentNode();
                        break;

                    case SEARCH_NO:
                        temp.scanData("검색", Data.NO);
                        ptr = list.search(temp, Data.NO_ORDER);
                        if (ptr == null)
                            System.out.println("그 이름의 데이터가 없습니다.");
                        else
                            System.out.println("검색 성공 : " + ptr);
                        break;

                    case SEARCH_NAME:
                        temp.scanData("검색", Data.NAME);
                        ptr = list.search(temp, Data.NAME_ORDER);
                        if (ptr == null)
                            System.out.println("그 이름의 데이터가 없습니다.");
                        else
                            System.out.println("검색 성공 : " + ptr);
                        break;

                    case NEXT:
                        list.next();
                        break;

                    case PRINT_CRNT:
                        list.printCurrentNode();
                        break;

                    case DUMP:
                        list.dump();
                        break;

                    case CLEAR:
                        list.clear();
                        break;
                }
            } while (menu != Menu.TERMINATE);
        }
    }

}
