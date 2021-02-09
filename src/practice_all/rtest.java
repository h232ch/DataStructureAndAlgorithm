package practice_all;

public class rtest {

    int magicNum = 1;
    static int staticMagicNum = 10;

    class innerClass{
        int innerMagicNum = 10;
        private void print() {
            System.out.println(magicNum);
        }
    }

    class innerPrac {
        int innerInt = 1;
        class inner2Prac {
            int innerInnerInt = 1;
        }
    }

    static class staticInnerClass {

        int staticInnerMagicNum = 15;
        private void print() {
            System.out.println(staticInnerMagicNum); // Only static variable can be used in the staticInnerClass
        }

    }

    public static void main(String[] args) {

        rtest r1 = new rtest();
        rtest.innerClass inner = r1.new innerClass(); // innerClass
        rtest.staticInnerClass r1st = new rtest.staticInnerClass(); // staticInnerClass

        rtest r2 = new rtest();
        rtest.innerPrac inner2 = r2.new innerPrac();
        rtest.innerPrac.inner2Prac inner3 = inner2.new inner2Prac();

        rtest r3 = new rtest();
        rtest.innerClass inner4 = r3.new innerClass();

    }
}
