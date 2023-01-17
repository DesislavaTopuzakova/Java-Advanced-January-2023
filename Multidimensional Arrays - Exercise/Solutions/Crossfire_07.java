package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //вход
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+"); // 3 4 1
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]); //индексът на елемента в листа
            int radius = Integer.parseInt(tokens[2]);

            //destroy up, down
            for (int currentRow = row - radius; currentRow <= row + radius ; currentRow++) {
                if(isInMatrix(currentRow, col, matrix)) { //валидираме реда от който ще вземем
                    matrix.get(currentRow).remove(col);
                }
            }

            //destroy left. right
            for (int currentColumn = col + radius; currentColumn >-  col - radius; currentColumn--) {
                if(isInMatrix(row, currentColumn, matrix)) { //валидираме колоната от който ще вземем
                    matrix.get(row).remove(currentColumn);
                }
            }

            matrix.removeIf(List::isEmpty);


            command = scanner.nextLine();

        }

        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    //fill matrix
    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }

    //print matrix
    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row ) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
