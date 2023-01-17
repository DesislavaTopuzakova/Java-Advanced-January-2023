package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrDim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[][] isOccupied = new boolean[arrDim[0]][arrDim[1]];
        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int desiredRow = Integer.parseInt(tokens[1]);
            int desiredCol = Integer.parseInt(tokens[2]);
            boolean hasFoundPlace = false;
            int traveledDistance = 1;
            traveledDistance += Math.abs(desiredRow - entryRow);

            if (!isOccupied[desiredRow][desiredCol]) {
                traveledDistance += desiredCol;
                isOccupied[desiredRow][desiredCol] = true;
                hasFoundPlace = true;
            } else {
                for (int offset = 1; offset < isOccupied[desiredRow].length && !hasFoundPlace; offset++) {
                    if (desiredCol - offset > 0 && !isOccupied[desiredRow][desiredCol - offset]){
                        isOccupied[desiredRow][desiredCol - offset] = true;
                        hasFoundPlace = true;
                        traveledDistance += desiredCol - offset;
                    }

                    if (!hasFoundPlace && desiredCol + offset < isOccupied[desiredRow].length
                            && !isOccupied[desiredRow][desiredCol + offset]){
                        isOccupied[desiredRow][desiredCol + offset] = true;
                        hasFoundPlace = true;
                        traveledDistance += offset + desiredCol;
                    }
                }
            }
            if (hasFoundPlace){
                System.out.println(traveledDistance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }
        }
    }
}