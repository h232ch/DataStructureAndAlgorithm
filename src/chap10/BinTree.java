package chap10;

import java.util.Comparator;

public class BinTree<K, V> {

    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        // Constructor
        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root; // 루트
    private Comparator<? super K> comparator = null; // 비교자

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) :
                comparator.compare(key1, key2);
    }

    public V search(K key) { // 이진검색트리에서 key값을 찾는다
        Node<K, V> p = root;

        while (true) {
            if (p == null) { // key값 존재하지 않음
                return null;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) { // key와 p가 같으면 0
                return p.getValue();
            } else if (cond < 0) { // key 쪽이 작으면 -1
                p = p.left; // 왼쪽 서브 트리에서 검색
            } else { // key 쪽이 크면 1
                p = p.right; // 오른쪽 서브 트리에서 검색
            }
        }
    }

    // node를 루트로 하는 서브 트리에 노드 <K, V>를 삽입
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return;
        } else if (cond < 0) {
            if (node.left == null) {
                node.left = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.left, key, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(key, data, null, null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }

    // ROOT가 NULL인 경우 노를 ROOT 노드에 생성
    public void add(K key, V data) {
        if (root == null) {
            root = new Node<K, V>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

}
