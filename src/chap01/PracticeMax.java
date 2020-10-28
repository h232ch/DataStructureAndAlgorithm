package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeMax {
    static int maxOfFourNum(int a, int b, int c, int d){

        List<Integer> list = new ArrayList<>(Arrays.asList(a,b,c,d));
        int max = list.get(0);

        for(int i=0; i<list.size()-1; i++){
            int nextNum = list.get(i+1);
            if(nextNum>max){
                max=nextNum;
            }
        }
        return max;
    }

    static int minOfFourNum(int a, int b, int c, int d){

        List<Integer> list = new ArrayList<>(Arrays.asList(a,b,c,d));
        int max = list.get(0);

        for(int i=0; i<list.size()-1; i++){
            int nextNum = list.get(i+1);
            if(nextNum<max){
                max=nextNum;
            }
        }
        return max;
    }

    static int minOfThreeNum(int a, int b, int c){
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
        int max = list.get(0);

        for(int i=0; i<list.size()-1; i++){
            int nextNum = list.get(i+1);
            if(nextNum<max){
                max = nextNum;
            }
        }
        return max;
    }

    static int medianOfThreeNum(int a, int b, int c){

        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
        int max = list.get(0);
        int min = list.get(0);
        int median = 0;
        for(int i = 0; i<list.size()-1; i++){
            int nextNum = list.get(i+1);
            if(nextNum>max){
                max = nextNum;
            }
            if(nextNum<min){
                min = nextNum;
            }
        }
        for(int i=0; i<list.size(); i++){
            int cNum = list.get(i);
            if(cNum<max && cNum>min){
                median=cNum;
            }
        }
        return median;
    }


    public static void main(String[] args){
        System.out.println("Max Number Of Four : "+maxOfFourNum(45,87,15,648));
        System.out.println("Min Number Of Four : "+minOfFourNum(45,87,15,648));
        System.out.println("Min Number of Three : "+minOfThreeNum(45,87,15));
        System.out.println("Median Number of Three : "+medianOfThreeNum(14,15,1234));

    }
}
