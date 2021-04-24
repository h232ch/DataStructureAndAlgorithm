package practice_all;

import java.util.Comparator;

public class BinTree<K, V> {

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

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return comparator == null ? ((Comparable<K>)key1).compareTo(key2) :
                comparator.compare(key1, key2);
    }

    public K search(K key) {
        Node<K, V> ptr = root;
        while (true) {
            if (root == null) {
                return null;
            }
            int cond = comp(key, ptr.getKey()   );
            if (cond == 0) {
                return key;
            } else if (cond < 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
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

        // TODO: 2021-03-11 삭제 노드와 삭ㅈ 노드의 부모를 찾는다.

        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null) {
                return false;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                break;
            } else if (cond < 0) {
                parent = p;
                p = p.left;
                isLeftChild = true;
            } else {
                parent = p;
                p = p.right;
                isLeftChild = false;
            }
        }

        if (p.left == null) {
            if (p == root) {
                p = p.right;
            } else if (isLeftChild) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if (p.right == null) {
            if (p == root) {
                p = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.right;
            }

        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;

            while (left.right != null) {
                parent = left;
                left = left.right;
            }

            p.key = left.getKey();
            p.data = left.getValue();

            if (isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }

        return true;
    }

    private void printSubTree(Node<K, V> n) {
        if (n != null) {
            printSubTree(n.left);
            System.out.println(n.getKey());
            printSubTree(n.right);
        }

    }

    public void print() {
        if (root != null) {
            printSubTree(root);
        }
    }
}
