package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"5 2 13"

        //1 начин
        int n = scanner.nextInt(); //брой на елементите, които трябва да добавя -> push
        int s = scanner.nextInt(); //брой на елементите, които тярбва да махна -> pop
        int x = scanner.nextInt(); //число, което проверявам дали го има

        //2 начин
        //scanner.nextLine() -> "5 2 13".split(" ") -> ["5", "2", "13"]

        //нов стек
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //ДОБАВЯНЕ (push) -> n на брой пъти
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }

        //ПРЕМАХВАНЕ (pop) -> s на брой пъти
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }

        //ПРОВЕРКА ЗА НАЛИЧИЕ НА ЧИСЛОТО X В СТЕКА
        //ИМА
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            //НЯМА -> принтираме най-малкия елемент в стека
            if (stack.isEmpty()) {
                //празен стек
                System.out.println(0);
            } else {
                //имаме елементи
                System.out.println(Collections.min(stack));
            }
        }
    }
}
