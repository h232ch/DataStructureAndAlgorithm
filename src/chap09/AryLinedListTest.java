package chap09;

public class AryLinedListTest {

    public static void main(String[] args) {

        AryLinkedList<Integer> ary = new AryLinkedList<>(5);

        ary.addFirst(14);
        ary.addFirst(15);
        ary.addFirst(16);
        ary.addFirst(17);
        ary.addFirst(18);
        ary.dump();

        ary.removeLast();
        ary.dump();
        ary.removeLast();
        ary.dump();
        ary.removeLast();
        ary.dump();
        ary.removeLast();
        ary.dump();

        ary.addFirst(20);
        ary.dump();
        ary.addFirst(21);
        ary.dump();
        ary.addFirst(22);
        ary.dump();
        ary.addFirst(23);
        ary.dump();


    }
}
