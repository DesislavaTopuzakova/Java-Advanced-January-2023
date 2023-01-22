package SetasAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"4 3"
        int sizeOfFirstSet = Integer.parseInt(input.split("\\s+")[0]); //брой елементи в първия сет
        int sizeOfSecondSet = Integer.parseInt(input.split("\\s+")[1]); //брой елементи във втория сет

        Set<Integer> firstSet = new LinkedHashSet<>(); //първия сет
        Set<Integer> secondSet = new LinkedHashSet<>(); //втори сет

        //1. напълня първия сет
        for (int number = 1; number <= sizeOfFirstSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }

        //2. напълня втория сет
        for (int number = 1; number <= sizeOfSecondSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }

        //set 1 => {1, 3, 5, 7}
        //set 2 => {3, 4, 5}
        //общите елементи за двата сета -> {3, 5}

        //начин 1:
        /*Set<Integer> duplicateElements = new LinkedHashSet<>(); //повтарящите се елементи
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicateElements.add(number);
                //или
                System.out.print(number + " ");

            }
        }
        //duplicateElements -> всички елементи, които ги има и в двата сета
        duplicateElements.forEach(el -> System.out.print(el + " "));*/

        //начин 2:
        firstSet.retainAll(secondSet);
        //retainAll -> премахва всички елементи от firstSet, които ги няма във втория
        //set 1 => {3, 5}
        //set 2 => {3, 4, 5}
        //firstSet -> остават само елементите, които ги има във втория
        firstSet.forEach(number -> System.out.print(number + " "));
    }
}
