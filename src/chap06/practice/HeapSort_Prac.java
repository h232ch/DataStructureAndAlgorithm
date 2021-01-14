package chap06.practice;

public class HeapSort_Prac {


    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) { // n / 2회 부모 노드의 자식 노드만 비교
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;
            if (temp >= arr[child])
                break;
            arr[parent] = arr[child];
        }
        arr[parent] = temp;
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) { // n / 2회 downHeap 진행
            downHeap(arr, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {2,45,4,536,34,4,6,7,43,3};
        heapSort(arr);
        for (int temp : arr) System.out.println(temp);
    }
}
