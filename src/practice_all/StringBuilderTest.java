package practice_all;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringBuilderTest {

    static class Person {
        private int age;
        private int num;

        public Person(int age, int num) {
            this.age = age;
            this.num = num;
        }

    }


    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "testz";

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() + "  " + s2.hashCode());

        Person person = new Person(10, 20);
        Person person2 = new Person(30, 30);
        Person person3 = new Person(10, 20);
        Person person1 = new Person(20, 30);

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());

        List<Integer> list = new ArrayList<>();

    }
}
