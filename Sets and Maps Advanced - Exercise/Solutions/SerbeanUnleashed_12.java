package SetasAndMaps;

import java.util.*;

public class SerbeanUnleashed_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("End")) {
            //Lepa Brena @Sunny Beach 25 3500
            if(!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' '){
                input = scanner.nextLine();
                continue;
            }

            String singer = input.substring(0, input.indexOf("@") - 1);
            int firstIndexOfNumber = 0;
            //@Sunny Beach 25
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if(Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' '){
                    firstIndexOfNumber = i;
                    break;
                }
            }

            if(firstIndexOfNumber == 0) {
                input = scanner.nextLine();
                continue;
            }

            String venue = input.substring(input.indexOf("@") + 1, firstIndexOfNumber - 1);
            String numbers = input.substring(firstIndexOfNumber);//"25 3000"
            String [] numbersArray = numbers.split("\\s+");
            if(numbersArray.length != 2) {
                input = scanner.nextLine();
                continue;
            }
            int price = Integer.parseInt(numbersArray[0]);
            int capacity = Integer.parseInt(numbersArray[1]);

            //venue -> {singer -> price}

            if (!concerts.containsKey(venue)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                concerts.put(venue, singers);
            } else {
                LinkedHashMap<String, Integer> currentSingers = concerts.get(venue);
                if (currentSingers.containsKey(singer)) {
                    currentSingers.put(singer, currentSingers.get(singer) + price * capacity);
                } else {
                    currentSingers.put(singer, price * capacity);
                }

                concerts.put(venue, currentSingers);
            }
            input = scanner.nextLine();
        }

        for (String venue : concerts.keySet()) {
            System.out.println(venue);

            LinkedHashMap<String, Integer> singers = concerts.get(venue);
            singers.entrySet().stream().sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                    .forEach(singer -> System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue())));

        }
    }




}
