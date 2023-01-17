package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < rows; row++) {
            String[] data = scan.nextLine().split("");
            for (int col = 0; col < cols; col++) {
                if (data[col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                    matrix[row][col] = data[col];
                } else {
                    matrix[row][col] = data[col];
                }
            }
        }
        String[] commands = scan.nextLine().split("");
        boolean isDead = false;
        boolean hasWon = false;


        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];

            // move player
            if (cmd.equals("U")) {
                if (playerRow - 1 < 0) { // wins
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow - 1][playerCol].equals(".")) { //moves
                        matrix[playerRow - 1][playerCol] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerRow--;
                    } else { // dies
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerRow--;
                    }
                }
            } else if (cmd.equals("D")) {
                if (playerRow + 1 == rows) { //wins
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow + 1][playerCol].equals(".")) { //moves
                        matrix[playerRow + 1][playerCol] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerRow++;
                    } else { // dies
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerRow++;
                    }
                }

            } else if (cmd.equals("L")) {
                if (playerCol - 1 < 0) { //wins
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow][playerCol - 1].equals(".")) { //moves
                        matrix[playerRow][playerCol - 1] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerCol--;
                    } else { // dies
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerCol--;
                    }
                }

            } else if (cmd.equals("R")) {
                if (playerCol + 1 == cols) { //wins
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow][playerCol + 1].equals(".")) { //moves
                        matrix[playerRow][playerCol + 1] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerCol++;
                    } else { // dies
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerCol++;
                    }
                }
            }


            //bunnies multiply
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if(matrix[row][col].equals("B")){
                        //UP
                        if(row-1 >= 0){
                            if (matrix[row-1][col].equals("P")){
                                isDead = true;
                                matrix[row-1][col] = "Bn";
                            } else if (matrix[row-1][col].equals(".")){
                                matrix[row-1][col] = "Bn";
                            }
                        }
                        //DOWN
                        if (row+1 < matrix.length){
                            if(matrix[row+1][col].equals("P")){
                                isDead = true;
                                matrix[row+1][col] = "Bn";
                            } else if (matrix[row+1][col].equals(".")){
                                matrix[row+1][col] = "Bn";
                            }
                        }
                        //LEFT
                        if (col -1 >= 0){
                            if (matrix[row][col-1].equals("P")){
                                isDead = true;
                                matrix[row][col-1] = "Bn";
                            } else if (matrix[row][col-1].equals(".")) {
                                matrix[row][col-1] = "Bn";
                            }
                        }
                        //RIGHT
                        if (col +1 < matrix[row].length){
                            if(matrix[row][col+1].equals("P")){
                                isDead = true;
                                matrix[row][col+1] = "Bn";
                            } else if (matrix[row][col+1].equals(".")) {
                                matrix[row][col+1] = "Bn";
                            }
                        }
                    }
                }
            }

            matrix = growTheBunnies(matrix);

            if(isDead){
                printMatrix(matrix);
                System.out.printf("dead: %d %d", playerRow, playerCol);
                break;
            } else if (hasWon){
                printMatrix(matrix);
                System.out.printf("won: %d %d",playerRow,playerCol);
                break;
            }
        }
    }

    private static String[][] growTheBunnies(String[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c].equals("Bn")){
                    matrix[r][c] = "B";
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
