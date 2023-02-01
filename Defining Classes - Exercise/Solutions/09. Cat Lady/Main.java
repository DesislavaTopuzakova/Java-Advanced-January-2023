package definingClassesExercise.catLady;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Cat> catMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            Cat cat = null;

            switch (breed) {
                case "Siamese":
                    cat = new Siamese(data[1], Double.parseDouble(data[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(data[1], Double.parseDouble(data[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(data[1], Double.parseDouble(data[2]));
                    break;
                default:
                    throw new RuntimeException("Unknown breed!");
            }
            catMap.put(data[1], cat);
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        if (catMap.containsKey(name)) {
            System.out.println(catMap.get(name).toString());
        }
    }

}

