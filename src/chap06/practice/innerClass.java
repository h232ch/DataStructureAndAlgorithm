package chap06.practice;

public class innerClass {

    int base = 1;
    static int base2 = 2;

    class staticTest {
        int zero = base;
        int bio = base2;
    }

    static class statticTest2 {
//        int zero = base;  // Can't use non Static variable
        int zero = base2;
    }

    public static void main(String[] args) {
        innerClass inner = new innerClass();
        innerClass.staticTest st = inner.new staticTest();

        statticTest2 st2 = new statticTest2();
    }
}
