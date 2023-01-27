package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //начин 1: без functional programming
        /*for (String name : names) {
            System.out.println(name);
        }*/

        //начин 2:
        //име -> печатам
        /*Consumer<String> printName = name -> System.out.println(name);
        //printName приема String name и я отпечатва

        for (String name : names) {
            printName.accept(name);
        }*/

        //начин 3:
        //масив с имена -> печатам всяко едно име
        Consumer<String[]> printArray = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        //printArray приема масив от текстове и го отпечатва
        printArray.accept(names);

    }
}
