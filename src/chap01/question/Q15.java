package chap01.question;

public class Q15 {

    static void triangleLB(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void triangleLU(int n){
        for(int i=1; i<=n; i++){
            for(int j=0; j<=n-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void triangleRU(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j<=(n-i)){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void triangleRB(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j<=(n+1)-i){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void sparta(int n){
        int sw=(n/2)+1;
        for(int i=1; i<=sw; i++){
            for(int j=1; j<=n; j++){
                if(j<=sw-i){
                    System.out.print(" ");
                }else if(j>=sw+i){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void npira(int n){
        int sw=(n/2)+1;
        for(int i=1; i<=sw; i++){
            for(int j=1; j<=n; j++){
                if(j<=sw-i){
                    System.out.print(" ");
                }else if(j>=sw+i){
                    System.out.print(" ");
                }else {
                    System.out.print(i);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){

        // Q15 직각 이등변 감각형을 출력
        triangleLB(5);
        triangleLU(5);
        triangleRU(5);
        triangleRB(5);

        sparta(17);
        npira(17);
    }
}
