package practice_all;

public class LinkedList<E> {

    class Node<E> {
        private Node<E> next;
        private E data;

        public Node(E data, Node<E> next) {
            this.next = next;
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public void addFirst(E obj) {
        if (head != null) {
            head = crnt = new Node<>(obj, head.next);
        }
    }

    public void addLast(E obj) {
        if (head != null) {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node<>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                Node<E> pre = ptr;
                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                crnt = pre;
                pre.next = null;
            }
        }
    }

    public void remove(Node<E> p) {
        if (head != null) {
            Node<E> ptr = head;
            while (ptr.next != p) {
                if (ptr == null) {
                    return;
                }
            }
            crnt = ptr;
            ptr.next = p.next;
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void printCurrentNode() {
        System.out.println(crnt.data);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
    }

    public void next() {
        if (crnt != null && crnt.next != null) {
            crnt = crnt.next;
        }
    }

    public E search(E obj) {
        if (head != null) {
            Node<E> ptr = head;
            while (ptr != null) {
                if (ptr.data == obj) {
                    return obj;
                }
                ptr = ptr.next;
            }
        }
        return null;
    }

    public void dump() {
        Node<E> ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
