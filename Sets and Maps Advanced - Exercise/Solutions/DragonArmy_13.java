package SetasAndMaps;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DragonArmy_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Double>>> dragons = new LinkedHashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            //{type} {name} {damage} {health} {armor}
            String type = tokens[0];
            String name = tokens[1];
            double damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            double health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            double armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>(){{
                    put(name, new ArrayList<>(){{
                        add(damage);
                        add(health);
                        add(armor);
                    }});
                }});
            }else{
                if(!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name, new ArrayList<>(){{
                        add(damage);
                        add(health);
                        add(armor);
                    }});
                }else {
                    dragons.get(type).get(name).add(0, damage);
                    dragons.get(type).get(name).add(1, health);
                    dragons.get(type).get(name).add(2, armor);
                }
            }
        }

        for (String type : dragons.keySet()) {
            double damageSum = 0;
            double healthSum = 0;
            double armorSum = 0;

            StringBuilder builder = new StringBuilder();

            for (String name : dragons.get(type).keySet()) {
                double tempDamage = dragons.get(type).get(name).get(0);
                double tempHealth = dragons.get(type).get(name).get(1);
                double tempArmor = dragons.get(type).get(name).get(2);

                builder.append(String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", name, tempDamage, tempHealth, tempArmor));

                damageSum += tempDamage;
                healthSum += tempHealth;
                armorSum += tempArmor;
            }
            damageSum /= dragons.get(type).keySet().size();
            healthSum /= dragons.get(type).keySet().size();
            armorSum /= dragons.get(type).keySet().size();

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, damageSum, healthSum, armorSum));
            System.out.print(builder.toString());


        }
    }
}
