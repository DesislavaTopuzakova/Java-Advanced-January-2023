package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancesParenthesses_05 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine(); //"{[()]}".toCharArray() -> ['{', '[', '(' ...]

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>(); //стек с отворени скоби
        boolean areBalanced = false; //дали скобите са балансирани
        //true -> скобите са балансирани
        //false -> скобите не са балансирани

        for (char bracket : input.toCharArray()) {
            //скоба
            //отворена -> (, [, { -> stack
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openBracketsStack.push(bracket);
            }
            //затворена -> ), ], }
            else if (bracket == ')' || bracket == ']' || bracket == '}') {
                //затворената скоба съвапада с последната добавена отворена

                //!!!! проверка дали има елементи на мястото, от което ще премахваме / взимаме !!!!!
                if (openBracketsStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBracketsStack.pop();

                //проверка дали има баланс между текущата затворена и последната отворена
                //1. ( и )
                if (lastOpenBracket == '(' && bracket == ')') {
                    //баланс
                    areBalanced = true;
                }
                //2. [ и ]
                else if (lastOpenBracket == '[' && bracket == ']') {
                    //баланс
                    areBalanced = true;
                }
                //3. { и }
                else if (lastOpenBracket == '{' && bracket == '}') {
                    //баланс
                    areBalanced = true;
                } else {
                    //нямаме баланс
                    areBalanced = false;
                    break;
                }
            }
        }

        //преминали през всички скоби или сме намерили небалансирани скоби
        //ако има баланс -> YES
        if (areBalanced) {
            System.out.println("YES");
        }
        //ако няма баланс -> NO
        else {
            System.out.println("NO");
        }

    }
}
