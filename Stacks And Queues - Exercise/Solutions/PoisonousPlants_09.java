package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();
        int[] days = new int[plants.length];
        prevPlants.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (prevPlants.size() > 0 && plants[prevPlants.peek()] >= plants[x]) {

                maxDays = Integer.max(days[prevPlants.pop()], maxDays);
            }

            if (prevPlants.size() > 0) {
                days[x] = maxDays + 1;
            }

            prevPlants.push(x);
        }

        System.out.printf("%d", Arrays.stream(days).max().getAsInt());
    }
}
