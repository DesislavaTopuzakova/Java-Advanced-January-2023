package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //бр. редове = бр. колони
        int [][] matrix = new int [n][n];

        //1. напълваме матрицата
        fillMatrix(matrix, scanner);
        //2. сума на числата на главния диагонал
        int sumPrimary = getSumElementsOnPrimaryDiagonal(matrix);
        //3. сума на числата на второстепенния диагонал
        int sumSecondary = getSumElementsOnSecondaryDiagonal(matrix);
        //4. принтираме абс. стойност на разликата
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumElementsOnSecondaryDiagonal(int [][] matrix) {
        int sum = 0; //сума на числата от второстепенния диагонал
        //всички елементи в матрицата -> сумирам тези, които са на второстепенния диагонал
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                if (col == matrix.length - row - 1) {
                    //елементът е на второстепенния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int [][] matrix) {
        int sum = 0; //сума на числата от главния диагонал
        //всички елементи в матрицата -> сумирам тези, които са на главния диагонал (кол = ред)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                if (row == col) {
                    //елементът е на главния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
