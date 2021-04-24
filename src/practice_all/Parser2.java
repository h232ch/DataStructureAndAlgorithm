package practice_all;

import java.util.ArrayList;
import java.util.List;

public class Parser2 {

    public static List<Integer> strToIntList(List<String> strList) {
        List<Integer> intList = new ArrayList<>();

        for (String value : strList) {
            intList.add(Integer.parseInt(value));
        }

        return intList;
    }
}
