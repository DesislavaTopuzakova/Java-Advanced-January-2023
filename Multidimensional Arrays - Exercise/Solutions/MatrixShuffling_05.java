package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensionsInput = scanner.nextLine(); //"3 4".split(" ") -> ["3", "4"]
        int rows = Integer.parseInt(dimensionsInput.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensionsInput.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols];

        //1. попълваме матрицата с данни от конзолата
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            //валидираме команда
            //валидна
            if (validateCommand(command, rows, cols)) {
                String [] commandParts = command.split("\\s+");
                //command = "swap 1 2 2 3"
                //"swap 1 2 2 3".split(" ") -> ["swap", "1", "2", "2", "3"]

                //място, от което взимам първия елемент
                int row1 = Integer.parseInt(commandParts[1]); //ред, от който трябва да взема първия елемент
                int col1 = Integer.parseInt(commandParts[2]); //колона, от коята трябва да взема първия елемент

                //място, от което взимам втория  елемент
                int row2 = Integer.parseInt(commandParts[3]);  //ред, от който трябва да взема втория елемент
                int col2 = Integer.parseInt(commandParts[4]);  //колона, от коята трябва да взема втория елемент

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);

            }
            //невалидна
            else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validateCommand (String command, int rows, int cols) {
        //true -> ако командата е валидна
        //false -> ако командата не е валидна
        //command = "swap row1 col1 row2 col2"
        String [] commandParts = command.split("\\s+");
        //"swap 1 3 4 6".split(" ") -> ["swap", "1", "3", "4", "6"]

        //1. брой на параметрите / части на командата -> 5
        if (commandParts.length != 5) {
            return false;
        }

        //2. започва swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }

        //3. дали редовете и колоните дадени в командата ги има в матрицата
        int row1 = Integer.parseInt(commandParts[1]); // >= 0 && < бр. редове
        int col1 = Integer.parseInt(commandParts[2]); // >= 0 && < бр. колони
        int row2 = Integer.parseInt(commandParts[3]); // >= 0 && < бр. редове
        int col2 = Integer.parseInt(commandParts[4]); // >= 0 && < бр. колони

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }

        //командата е валидна по всички параметри
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
