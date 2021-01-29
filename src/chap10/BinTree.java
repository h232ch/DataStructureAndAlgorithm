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

    public boolean remove(K key) {
        Node<K, V> p = root; // 스캔중인 노드
        Node<K, V> parent = null; //스캔중인 노드의 부모 노드
        boolean isLeftChild = true; // p는 부모의 왼쪽자식 노드인가?

        while (true) {
            if (p == null) {  // p 값이 널이면 (리프 노드까지 모두 검색)
                System.out.println("There is no Key");
                return false; // 지울 값이 없음
            }
            int cond = comp(key, p.getKey()); // key < (-1) , = (0) , > (1)
            if (cond == 0) { // p.Key 값과 key값이 같으면 while문을 빠져나감
                break;
            } else {
                parent = p; // 가지로 내려가기 전에 부모를 설정 (pre p 추후 pre p 아래 p 노드를 삭제하거나 변경함)
                if (cond < 0) { // key가 작으면
                    isLeftChild = true; // 왼쪽 자식으로 내려감
                    p = p.left; // 왼쪽 서브트리에서 검색
                } else { // key가 크면
                    isLeftChild = false; // 오른쪽 자식으로 내려감
                    p = p.right; // 오른쪽 서브 트리에서 검색
                }
            }
        }

        if (p.left == null) { // p 왼쪽에 자식이 없음 ( p 노드는 리프 노드)
            if (p == root) {
                root = p.right; // p가 root일 경우 root를 p.right로 변경
            } else if (isLeftChild) {
                parent.left = p.right; // parent.left를 p.right(null)값으로 변경
            } else {
                parent.right = p.right; // parent.right를 p.right(null)값으로 변경
            }
        } else if (p.right == null) { // p 왼쪽에 자식이 있는 경우
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left; // p가 왼쪽에 있는 경우 parent.left를 p.left로 변경
                // parent.left를 p의 left 자식 노드를 변경
            } else {
                parent.right = p.left; // parent.right 값을 p.left 값으로 변경
            }
        } else {
            parent = p; // parent값을 p로 변경
            Node<K, V> left = p.left;
            isLeftChild = true;

            while (left.right != null) { // 왼쪽 서브트리에서 가장 큰 값을 검색
                parent = left; // parent를 아래로 내림
                left = left.right; // left.right를 left로 지정 (오른쪽으로 계속 내려감)
                isLeftChild = false;
            }

            p.key = left.key; // p의 키 값을 left(p.left.right 서브트리중 가장 큰 값)
            p.data = left.data; // left(p.left.right 서브트리 중 가장 큰 값).data를 p.data로 변경

            if (isLeftChild) {
                parent.left = left.left; // left는 while문 내에서 right으로 변경됨으로
                // parent. left = parent. right를 의미함 -> parent right를 
                // parent 자식 노드인 left의 left 값으로 변경 (null 혹은 노드 존재시 해당 노드)
            } else {
                parent.right = left.left; // parent.right 값을 parent.right.left로 변경
            }
        }
        return true;
    }

    // node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left); // 왼쪽 서브트리를 키 값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data); // Node 출력
            printSubTree(node.right); // 오른쪽 서브 트리를 키 값의 오름차순으로 출력
        }
    }

    public void print() {
        printSubTree(root);
    }

    private void printReverseSubTree(Node node) {
        if (node != null) {
            printReverseSubTree(node.right);
            System.out.println(node.key + " " + node.data);
            printReverseSubTree(node.left);
        }
    }

    public void printReverse() {
        printReverseSubTree(root);
    }

    public K getMinKey() {

        if (root != null) {
            Node<K, V> ptr;
            Node<K, V> pre;
            pre = ptr = root;

            while (ptr != null) {
                pre = ptr;
                ptr = ptr.left;
            }
            return pre.key;

        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    public K getMaxKey() {

        if (root != null) {
            Node<K, V> ptr;
            Node<K, V> pre;
            pre = ptr = root;

            while (ptr != null) {
                pre = ptr;
                ptr = ptr.right;
            }
            return pre.key;

        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    public V getDataWithMinKey() {
        Node<K, V> ptr;
        Node<K, V> pre;
        ptr = pre = root;

        while (ptr != null) {
            pre = ptr;
            ptr = ptr.left;
        }
        return pre.data;
    }

    public V getDataWithMaxKey() {
        Node<K, V> ptr;
        Node<K, V> pre;
        ptr = pre = root;

        while (ptr != null) {
            pre = ptr;
            ptr = ptr.right;
        }
        return pre.data;
    }



}
