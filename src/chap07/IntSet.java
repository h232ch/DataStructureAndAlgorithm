package chap07;

import chap01.Max3;
import chap07.practice.IntSetPrac;

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

    // 집합 s에 복사합니다.
    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num; // 복사할 요수 개수
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    // 집합 s를 복사합니다.
    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num; // 복사할 요소 개수
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--num]; // idx에 set의 마지막 요소를 넣어주고 num을 1 감소시킴
            return true;
        }
    }

    public boolean equalTo(IntSet s) {
        if (num != s.num)
            return false; // 요소의 개수가 같지 않으면

        for (int i = 0; i < num; i++) { // i값을 1씩 증가시키며 j값과 비교
            int j = 0;
            for( ; j < s.num; j++) // j값을 1씩 증가시키며 i값과 비교
                if (set[i] == s.set[j]) 
                    break;
            if (j == s.num) // j값이 s.num과 같다면 s.set 요소가 set과 일치하지 않음을 의미함
                return false;
        }
        return true;
    }

    // 집합 s1과 s2의 합집합(s1, s2의 합)을 복사합니다.
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    // "{a b c}" 형식의 문자열로 표현을 바꿈
    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i = 0; i < num; i++)
            temp.append(set[i] + " ");
        temp.append("}");
        return temp.toString();
    }

    public boolean retain(IntSet s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (!s.contains(set[i])) {
                remove(set[i]);
                flag = true;
            }
        return flag;
    }

}
