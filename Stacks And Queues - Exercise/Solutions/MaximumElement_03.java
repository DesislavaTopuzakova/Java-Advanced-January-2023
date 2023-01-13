package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= n; count++) {
            String command = scanner.nextLine();
            //"1 X" -> push x to stack
            //"2" -> pop of stack
            //"3" -> print max element only if stack is not empty
            if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                //проверка дали имаме елементи
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }
            } else {
                //command = "1 97" .split -> ["1", "97"]
                int x = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(x);
            }
        }
    }
}
