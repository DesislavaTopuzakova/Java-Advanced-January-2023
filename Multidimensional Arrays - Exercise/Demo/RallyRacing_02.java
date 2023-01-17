package assArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой редове = брой колони
        String carNumber = scanner.nextLine(); //номер
        int km = 0; // изминати километри от колата

        String [][] trace = new String [n][n];
        fillMatrix(trace, scanner);

        int currentRow = 0; //ред, на който се намира колата
        int currentCol = 0; //колона, на която се намира колата

        //намираме тунелите -> 2 тунела
        //тунел 1 -> ред, колона
        //тунел 2 -> ред, колона
        //лист с 4 елемента ->
        // 1ви елемент (ред на тунел1), 2ри елемент (колона на тунел1)
        // 3ти елемент (ред на тунел2), 4ти елемент (колона на тунел2)
        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelsCoordinates);

        //започваме движения
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {

            switch(direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            //currentRow, currentCol -> къде се намира колата след преместване
            //там, където е преместена какво има?
            String movedPlace = trace[currentRow][currentCol]; //място по трасето, на което сме се преместили

            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            } else if (movedPlace.equals("T")) {
                    //стигаме до тунел -> отиваме до другия тунел
                    //координатите на колата = кординатите на втория тунел
                    //tunnelCoordinates -> лист с 4 елемента ->
                    // 1ви елемент (ред на тунел1), 2ри елемент (колона на тунел1)
                    // 3ти елемент (ред на тунел2), 4ти елемент (колона на тунел2)
                    currentRow = tunnelsCoordinates.get(2);
                    currentCol = tunnelsCoordinates.get(3);
                    km += 30;
                    //заместваме тунелите с точка, защото вече сме преминали
                    trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = "."; //замествам първия тунел с .
                    trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = "."; //замествам втория тунел с .
            }

            direction = scanner.nextLine();
        }

        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", km);

        //там където е колата да слагаме C
        trace[currentRow][currentCol] = "C";

        //принтираме финалното трасе
        printMatrix(trace);
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                String currentElement = trace[row][col];
                if (currentElement.equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }
            }
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
