package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        int n = Integer.parseInt(scanner.nextLine()); //дължина за сравнение
        String[] names = scanner.nextLine().split("\\s+");

        //име -> true (дължина <= n) / false (дължина > n)
        Predicate<String> checkValidLength = name -> name.length() <= n;
        //останат само имената, които отговарят на условието
        Arrays.stream(names).filter(checkValidLength) //филтрираме
                            .forEach(System.out::println); //отпечатваме останалите елементи
        //обхождат се всички елементи по отделно
        //true -> оставя елемента в списъка
        //false -> премахва от списъка
    }
}
