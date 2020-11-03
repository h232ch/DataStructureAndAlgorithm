package chap02;

public class Class {
    
    int x; // x는 int형 필드
    long y; // y는 long형 필드
    double z; // z는 double형 필드

    public static void main(String[] args){
        // 클래스는 임의의 데이터형을 자유로이 조합하여 만들 수 있는 자료구조이다.
        Class c = new Class(); // 변수를 선언하고 인스턴스를 생성함 (인스턴스란? 클래스가 메모리상에 올라간 상태)
        System.out.println(c.x);
    }
}
