package chap10.practice;

import java.util.Scanner;

public class test {

    enum Menu {
        ADD("삽입"),
        REMOVE("종료"),
        SEARCH("검색"),
        PRINT("표시"),
        TERMINATE("종료");

        private final String message;
        Menu(String string) { // 생성자
            message = string;
        }

        String getMessage() {
            return message;
        }

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }
    }

    static Menu SelectMenu() {
        int key;
        Scanner sc = new Scanner(System.in);
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d)%s ", m.ordinal(), m.getMessage());
            }
            System.out.printf(" : ");
            key = sc.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu = SelectMenu();
        System.out.println(menu);
    }
}
