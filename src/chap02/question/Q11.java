package chap02.question;

public class Q11 {

    static class YMD {

        int y; int m; int d;
        YMD(int y, int m, int d){
            this.y = y; // 년
            this.m = m; // 월(1~12)
            this.d = d; // 일(1~31)
        }

        int after(int n){
            int fell = n+d;
            if(fell>31){
                m++; d=fell-31;
            }
            else{
                d+=n;
            }
            return d;
        }

        int before(int n){
            int fell = d-n;
            if(fell<0){
                m--; d=31+fell;
            }else {
                d-=n;
            }
            return d;
        }
    }

    public static void main(String[] args){
        YMD ymd = new YMD(2020, 5, 20);
        ymd.before(25);
        System.out.println(ymd.y+" "+ymd.m+" "+ymd.d);
    }
}
