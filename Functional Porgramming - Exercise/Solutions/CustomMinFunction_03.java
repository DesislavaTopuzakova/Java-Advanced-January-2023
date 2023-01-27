package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //начин 1: без функционално програмиране
        //System.out.println(Collections.min(numbers));

        //начин 2:
        //лист -> отпечатаме минималното число
        /*Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        //printMinNumber приема лист и отпечатва минималния елемент в листа
        printMinNumber.accept(numbers);*/

        //начин 3:
        //лист -> връща минималния елемент в списъка
        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        //getMinNumber приема лист и да връща стойност (цяло число), която е минималния елемент
        int minElement = getMinNumber.apply(numbers);
        System.out.println(minElement);
    }
}
