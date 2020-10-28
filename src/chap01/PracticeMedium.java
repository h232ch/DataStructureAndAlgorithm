package chap01;




public class PracticeMedium {

    static int mediumOfThreeNum(int a, int b, int c){
        if(a>=b)
            if(b>=c)
                return b;
            else if(c>=a)
                return a;
            else
                return c;
        else if(c>=b)
            return b;
        else if(a>=c)
            return a;
        else
            return c;
    }

    static int mediumOfThreeNum2(int a, int b, int c){
        if((b>=a&&a>=c)||(c>=a&&a>=b))
            return a;
        else if((a>=b&&b>=c)||(c>=b&&b>=a))
            return b;
        else
            return c;
    }


    public static void main(String[] args){

        System.out.println("Medium Number : "+mediumOfThreeNum(10,200,15));
        System.out.println("Medium Nubmer2 : "+mediumOfThreeNum2(10,100,23));

    }
}
