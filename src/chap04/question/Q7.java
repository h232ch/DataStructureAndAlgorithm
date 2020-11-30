package chap04.question;

public class Q7 {

    public static void main(String[] args) {

        Q7Deck deck = new Q7Deck(4);

        System.out.println(deck.enque(1, 1));
        System.out.println(deck.enque(1, 1));
        System.out.println(deck.enque(2, 1));
        System.out.println(deck.enque(2, 1));

        System.out.println(deck.deque(2));
        System.out.println(deck.deque(2));

        System.out.println(deck.enque(2, 1));
        System.out.println(deck.enque(2, 1));

        System.out.println(deck.deque(1));
        System.out.println(deck.deque(1));

        System.out.println(deck.enque(1, 1));
        System.out.println(deck.enque(1, 1));
    }
}
