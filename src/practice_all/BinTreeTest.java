package practice_all;

public class BinTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> bt = new BinaryTree<>();
        bt.add(10, 20);
        bt.add(20, 20);
        bt.add(5, 20);
        bt.add(2, 20);
        bt.add(4, 20);
        bt.add(24, 20);

        bt.remove(4);
        bt.remove(2);

        bt.print();
    }
}