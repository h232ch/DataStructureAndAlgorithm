package practice_all;

import java.util.Comparator;

public class AryLinkedList<E> {

    class Node<E> {
        private E data;
        private int next;
        private int dnext;

        public void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private int head;
    private int crnt;
    private int max;
    private int size;
    private int deleted;
    private Node<E>[] n;
    private static final int NULL = -1;

    public AryLinkedList(int capacity) {
        try {
            size = capacity;
            head = crnt = max = deleted = NULL;
            n = new Node[size];
            for (int i = 0; i < size; i++) {
                n[i] = new Node<>();
            }
        } catch (OutOfMemoryError error) {
            size = 0;
        }
    }

    private int getInsertIndex() {
        if (deleted == NULL) {
            if (max < size) {
                return ++max;
            } else {
                return NULL;
            }
        } else {
            int rec = deleted;
            deleted = n[deleted].dnext;
            return rec;
        }
    }

    private void deleteIndex(int idx) {
        if (deleted == NULL) {
            deleted = idx;
        } else {
            n[idx].dnext = deleted;
            deleted = idx;
        }
    }

    public void addFirst(E obj) {
        int rec = getInsertIndex();
        if (rec != NULL) {
            int ptr = head;
            n[rec].set(obj, ptr);
            head = crnt = rec;
        }
    }

    public void addLast(E obj) {
        int rec = getInsertIndex();
        if (rec != NULL) {
            int ptr = head;
            while (n[ptr].next != NULL) {
                ptr = n[ptr].next;
            }
            n[ptr].next = crnt = rec;
            n[rec].set(obj, NULL);
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            deleteIndex(head);
            head = n[head].next;
        }
    }

    public void removeLast() {
        if (head != NULL) {
            int ptr = head;
            int pre = ptr;
            while (n[ptr].next != NULL) {
                pre = ptr;
                ptr = n[ptr].next;
            }
            crnt = pre;
            deleteIndex(ptr);
            n[pre].next = NULL;
        }
    }

    public void remove(int p) {
        if (head != NULL) {
            int ptr = head;
            while (n[ptr].next != p) {
                if (ptr == NULL) {
                    return;
                }
                ptr = n[ptr].next;
            }
            deleteIndex(p);
            n[ptr].next = n[p].next;
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void printCurrentNode() {
        if (head != NULL) {
            System.out.println(n[crnt].data);
        }
    }

    public void clear() {
        while (head != NULL) {
            removeFirst();
        }
    }

    public void next() {
        if (n[crnt].next != NULL) {
            crnt = n[crnt].next;
        }
    }

    public E search(E obj) {
        if (head != NULL) {
            int ptr = head;
            while (ptr != NULL) {
                if (n[ptr].data == obj) {
                    return obj;
                }
                ptr = n[ptr].next;
            }
        }
        return null;
    }

    public void dump() {
        if (head != NULL) {
            int ptr = head;
            while (ptr != NULL) {
                System.out.println(n[ptr].data);
            }
        }
    }
}


