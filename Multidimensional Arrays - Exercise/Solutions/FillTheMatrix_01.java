package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни
        //"3, A".split(", ") -> ["3", "A"]
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(", ")[0]); //бр.редове = бр. колони
        String pattern = input.split(", ")[1];//шаблон за попълване -> "A" или "B"

        int [][] matrix = new int [n][n];

        if (pattern.equals("A")) {
            //pattern А -> по колони
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            //pattern B -> по колони
            //четна (2-ра, 4-та, 6-та, 8-та, ...) -> редове от последен към първи
            //нечетна (1-ва, 3-та, 5-та, ...) -> редове от първия към последния
            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1; //числа за попълване на матрицата
        for (int col = 0; col < matrix.length; col++) {
            //col + 1 -> пореден номер на колоната
            if ((col + 1) % 2 == 0) {
                //поредния номер на колоната е четен (2-ра, 4-та, 6-та, 8-та, ...) -> редове от последен към първи
                //2-ра -> индекс 1
                //4-та ->
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                //поредния номер на колоната е нечетен (1-ва, 3-та, 5-та, ...) -> редове от първия към последния
                for (int row = 0; row <= matrix.length - 1; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int [][] matrix) {
        int startNumber = 1;
        //бр. редове = бр. колони -> matrix.length
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
