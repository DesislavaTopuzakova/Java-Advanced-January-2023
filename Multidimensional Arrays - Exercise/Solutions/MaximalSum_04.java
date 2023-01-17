package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
        int rows = numbers[0];
        int cols = numbers [1];

        int [][] matrix = new int [rows][rows];

        fillMatrixType1(scanner, matrix, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < rows - 2 ; row++) {
            for (int col = 0; col < cols - 2 ; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        +  matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if(sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }

        }

        System.out.println("Sum = " + maxSum);
        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2 ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixType1(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
