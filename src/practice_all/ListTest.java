package practice_all;

import java.util.Comparator;

public class ListTest {

    static class CompNumber implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? 1 : o1 == o2 ? 0 : -1;
        }
    }


    public static void main(String[] args) {
        AryLinkedList list = new AryLinkedList(10);
        CompNumber compNumber = new CompNumber();

        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);

        list.addLast(50);
        list.addLast(51);
        list.addLast(52);

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.removeCurrentNode();

        list.dump();


        int i = 10;
        int j = 20;

        Integer i1 = new Integer(10);
        Integer ij = new Integer(20);

        ((Comparable<Integer>)i1).compareTo(ij);

        System.out.println(Integer.compare(i, j));
        System.out.println(i1.compareTo(i));
    }
}
