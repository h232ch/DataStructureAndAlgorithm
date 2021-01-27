package chap09.practice;

public class AryLinkedListQ4<E> {

    static class Node<E> {
        private E data;
        private int next;
        private int dnext;

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;
    private int head;
    private int crnt;
    private int max;
    private int size;
    private int deleted;
    private final static int NULL = -1;

    public AryLinkedListQ4(int capacity) {
        head = crnt = max = deleted = -1;
        try {
            size = capacity;
            n = new Node[size];
            for (int i = 0; i < size; i++) {
                n[i] = new Node<>();
            }
        } catch (OutOfMemoryError error) {
            size = 0;
        }
    }

    private int insertIndex() {
        if (deleted == NULL) {
            if (max < size - 1) {
                return ++max;
            } else {
                return NULL;
            }
        } else {
            int rec = deleted;
            deleted = n[rec].dnext;
            n[rec].dnext = NULL; // Added Code (Deleting pre deleted's dnext value);
            return rec;
        }
    }

    private void deleteIndex(int idx) {
        if (deleted == NULL) {
            deleted = idx;
            n[idx].dnext = NULL;
        } else {
            n[idx].dnext = deleted;
            deleted = idx;
        }
    }

    public void addFirst(E data) {
        int rec = insertIndex();
        if (rec != NULL) {
            n[rec].set(data, head);
            head = crnt = rec;
        } else {
            System.out.println("The array is full");
        }
    }

    public void addLast(E data) {
        int rec = insertIndex();
        if (rec != NULL) {
            if (head == NULL) {
                addFirst(data);
            } else {
                int ptr = n[head].next;
                while (ptr != NULL) {
                    ptr = n[ptr].next;
                }
                n[ptr].next = crnt = rec;
                n[rec].set(data, NULL);
            }
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            deleteIndex(head);
            head = crnt = n[head].next;
        } else {
            System.out.println("THere is no data to remove");
        }
    }

    public void removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL) {
                removeFirst();
            } else {
                int ptr = head;
                int pre = head;
                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;
                deleteIndex(ptr);
                crnt = pre;
            }
        }
    }
}
