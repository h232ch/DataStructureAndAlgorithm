package chap02;

public class CloneArray {
    public static void main(String[] args) {
        int[] a = new int[5]; // 5개의 요소를 갖는 배열 생성 (요소는 0으로 초기화됨)
        int[] b = {1, 2, 3, 4, 5}; // 배열 생성과 동시에 원하는 값으로 초기화

        a=b.clone(); // Heap 공간에 존재하는 a 배열 요소값의 메모리 주소에 b의 요소값을 복제 (서로 다른 메모리를 참조한다)
        a[3]=0;

        System.out.println("a = ");
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] );
        }
        System.out.println();
        System.out.println("b = "); // 변경되지 않음
        for (int i=0; i<b.length; i++){
            System.out.print(b[i] );
        }
    }
}
