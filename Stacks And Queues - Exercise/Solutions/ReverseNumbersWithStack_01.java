package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"1 2 3 4 5"
        //1. всички числа да ги сложим в стек
        //2. повтаряме: вадим число от стека -> докато стека е пълен
        // спираме: стекът стане празен -> stack.isEmpty()
        String input = scanner.nextLine(); //"1 2 3 4 5"
        String[] inputNumbers = input.split("\\s+"); //["1", "2", "3", "4", "5"]

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : inputNumbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
