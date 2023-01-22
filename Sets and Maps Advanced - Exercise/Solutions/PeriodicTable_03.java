package SetasAndMaps;

import java.util.*;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> uniqueElements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine()); //брой на редовете с химични елементи

        for (int row = 1; row <= n; row++) {
            String []chemicalElements = scanner.nextLine().split("\\s+"); // "Mo O Ce".split("\\s+") -> ["Mo", "O", "Ce"]
            //начин 1:
            /*for (String el : chemicalElements) {
                uniqueElements.add(el);
            }*/

            //начин 2:
            //Collections.addAll(Arrays.asList(chemicalElements), uniqueElements);

            //начин 3:
            uniqueElements.addAll(Arrays.asList(chemicalElements));
        }

        //сет с всички хим. елементи по 1 път
        uniqueElements.forEach(el -> System.out.print(el + " "));
    }
}
