package practice_all;

public class cardConv {

    static char[] conv = new char[32];
    static char[] cardConv(int objNum, int convNum) {
        int digit = 0;
        String convMap = "0123456789ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        while (objNum > 0) {
            int tempNum = objNum % convNum;
            objNum /= convNum;
            conv[digit++] = convMap.charAt(tempNum);
//            System.out.println("tempNum : " + tempNum);
//            System.out.println("objNum : " + objNum);
        }

        return conv;
    }

    public static void main(String[] args) {
        System.out.println(cardConv(10,16));
    }
}
