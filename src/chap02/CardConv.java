package chap02;

public class CardConv {

    static char[] cardConvR(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            d[digits++] = dchar.charAt(x%r);
            x /= r;
        }while (x != 0);
        return d;
    }

    public static void main(String[] args){
        char[] d = new char[32];
        for(char c : cardConvR(59, 16, d)){
            System.out.print(c+" ");
        }
    }
}
