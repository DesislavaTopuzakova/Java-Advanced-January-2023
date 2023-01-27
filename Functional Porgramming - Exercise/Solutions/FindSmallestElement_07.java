package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //lastIndexOf -> връща последния индекс, на който срещаме дадения елемент
        //indexOf -> връща първия индекс, на който срещаме дадения елемент


        //начин 1:
        //лист -> отпечатвам най-десния (последния) индекс на най-малкото число
        /*Consumer<List<Integer>> printLastIndexOfMinElement = list -> {
            int minElement = Collections.min(list);
            System.out.println(list.lastIndexOf(minElement));
        };
        printLastIndexOfMinElement.accept(numbers);*/

        //начин 2:
        //лист -> връщам последния индекс, на който срещаме мининмалния елемент
        Function<List<Integer>, Integer> getLastIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        int lastIndex = getLastIndexOfMinElement.apply(numbers);
        System.out.println(lastIndex);

    }
}
