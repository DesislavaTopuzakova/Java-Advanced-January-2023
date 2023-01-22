package SetasAndMaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Demo_Sort {
    public static void main(String[] args) {
        //човек -> сума за плащане
        Map<String, Integer> people = new HashMap<>();

        //1. sorted by keys in ascending order (нарастващ) -> а към z
        people.entrySet().stream().sorted(comparingByKey());

        //2. sorted by keys in descending order (намаляващ) -> z към а
        people.entrySet().stream().sorted(Collections.reverseOrder(comparingByKey()));

        //3. sorted by value in ascending order -> от най-малка към най-голяма сума
        people.entrySet().stream().sorted(comparingByValue());

        //3. sorted by value in descending order -> от най-голяма към най-малка сума
        people.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()));

        //съхраняваме в нов мап вече сортирания
        Map<String, Integer> sortedMap =  people.entrySet().stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        //съхраняваме в същия мап вече сортирания
        people = people.entrySet().stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    }
}
