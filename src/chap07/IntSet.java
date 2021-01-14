package chap07;

import chap01.Max3;

import java.sql.Struct;

public class IntSet {

    public int max; // 집합의 최대 개수
    public int num; // 집합의 요소 개수
    private int[] set; // 집합 본체

    // 생성자
    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max]; // 집합 배열 생성
        } catch (OutOfMemoryError error) { // 배열 생성 실패
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n)
                return i; // 검색 성공
        return  -1; // 검색 실패
    }

    // 집합에 n이 있는지 없는지 확인합니다.
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean add(int n) {
        if (num >= max || contains(n) == true)
            return false;
        else {
            set[num++] = n;
            return true;
        }
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--num];
            return true;
        }
    }


}
