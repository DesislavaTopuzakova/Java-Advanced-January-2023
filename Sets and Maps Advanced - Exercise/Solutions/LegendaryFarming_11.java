package SetasAndMaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> legendaryMat = new HashMap<>();
        HashMap<String, Integer> junkMat = new HashMap<>();

        legendaryMat.put("shards", 0);
        legendaryMat.put("fragments", 0);
        legendaryMat.put("motes", 0);

        boolean isCollected = false;
        while (!isCollected) {
            String[] tokens = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < tokens.length && !isCollected; i += 2) {
                String mat = tokens[i + 1];
                int amount = Integer.parseInt(tokens[i]);

                if ("shards".equals(mat) || "fragments".equals(mat) || "motes".equals(mat)) {
                    amount += legendaryMat.get(mat);
                    if (amount >= 250) {
                        amount -= 250;
                        isCollected = true;
                        switch (mat) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                    }
                    legendaryMat.put(mat, amount);
                } else {
                    if (junkMat.containsKey(mat)) {
                        junkMat.put(mat, junkMat.get(mat) + amount);
                    } else {
                        junkMat.put(mat, amount);
                    }
                }
            }
        }

        legendaryMat.entrySet().stream().sorted((e1, e2) -> {
                    if (e2.getValue().compareTo(e1.getValue()) == 0){
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().compareTo(e1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junkMat.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
