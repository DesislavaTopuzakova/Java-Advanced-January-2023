package SetasAndMaps;

import java.util.*;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TreeMap <Character, Integer> symbolsCount = new TreeMap<>();
        //символ -> бр. срещанията

        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            //символът вече да съм го срещала
            if (symbolsCount.containsKey(currentSymbol)) {
                int currentCount = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentCount + 1);
            }//символът да не съм го срещала
            else {
                symbolsCount.put(currentSymbol, 1);
            }
        }
        //символ: бр.срещания time/s
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
