package chap09.practice;

import java.util.Comparator;

public class LinkedListTesterQ {



    public static class diff implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 < o2) ? -1 : (o1 == o2) ? 0 : 1;
        }
    }
    public static Comparator<Integer> diffData = new diff();

    public static void main(String[] args) {

        LinkedListQ2<Integer> link = new LinkedListQ2<>();

        link.addLast(20);
        link.addLast(22);
        link.addLast(22);
        link.addLast(23);
        link.addLast(24);
        link.addLast(23);
//        link.purge2(diffData);



        link.dump();
        System.out.println(link.retrieve2(5));

    }
}
