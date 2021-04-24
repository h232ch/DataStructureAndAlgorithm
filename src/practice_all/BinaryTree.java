package practice_all;

import java.util.Comparator;

public class BinaryTree<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

    }

    private Node<K, V> root;
    private Comparator<? super K> comparator;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return comparator == null ? ((Comparable<K>) key1).compareTo(key2) :
                comparator.compare(key1, key2   );
    }

    public V search(K key) {
        Node<K, V> p = root;
        while (true) {
            if (p == null) {
                return null;
            }

            int cond = comp(key, p.getKey());
            if (cond == 0) {
                return p.getValue();
            } else if (cond < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return;
        } else if (cond < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, data, null, null);
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

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    public boolean remove(K key) {

        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftNode = true;

        // TODO: 2021-03-10 값을 검색

        while (true) {
            if (p == null) {
                return false;
            }

            int cond = comp(key, p.key);
            if (cond == 0) {
                break;
            } else if (cond < 0) {
                parent = p;
                p = p.left;
                isLeftNode = true;
            } else {
                parent = p;
                p = p.right;
                isLeftNode = false;
            }
        }

        // TODO: 2021-03-10 노드 1개일때 삭제 조건

        // TODO: 2021-03-10 노드 2개일때 삭제 조건

        if (p.left == null) {
            if (p == root) {
                p = p.right;
            } else if (isLeftNode) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if (p.right == null) {
            if (p == root) {
                p = p.left;
            } else if (isLeftNode) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftNode = true;

            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftNode = false;
            }

            p.key = left.key;
            p.data = left.data;

            if (isLeftNode) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }
        return true;
    }

    private void printSubTree(Node<K, V> node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.getKey());
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }
}
