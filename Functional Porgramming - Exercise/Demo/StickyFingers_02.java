package FunctionalProgramming;

import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine()); //брой редове = брой колони
        String [] directions = scanner.nextLine().split(",");
        //"up,right,down,down,left".split(",") -> ["up", "right", "down", "down", "left"]

        //1. приготвяме полето (матрица)
        String [][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        //2. намираме от къде започва да се движи крадецът
        int rowThief = -1; //текущ ред на крадец
        int colThief = -1; //текущ колона на крадец

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("D")) {
                    rowThief = row;
                    colThief = col;
                    break;
                }
            }
        }

        int totalStolenMoney = 0; //общо откраднати пари
        //3. изпълняваме посоките
        for (String direction :  directions) {
            //direction = left/right/up/down
            switch(direction) {
                case "left":
                    if (colThief - 1 < 0) {
                        //излизам от матрицата
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        //мога да се придвижа
                        matrix[rowThief][colThief] = "+";
                        //премествам
                        colThief--;
                    }
                    break;
                case "right":
                    if (colThief + 1 >= size) {
                        //излизам от матрицата
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        //мога да се придвижа
                        matrix[rowThief][colThief] = "+";
                        //премествам
                        colThief++;
                    }
                    break;
                case "up":
                    if (rowThief - 1 < 0) {
                        //излизам от матрицата
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        //мога да се придвижа
                        matrix[rowThief][colThief] = "+";
                        //премествам
                        rowThief--;
                    }
                    break;
                case "down":
                    if (rowThief + 1 >= size) {
                        //излизам от матрицата
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        //мога да се придвижа
                        matrix[rowThief][colThief] = "+";
                        //преместваме
                        rowThief++;
                    }
                    break;
            }
            //знам къде се е преместил крадецът
            //ред: rowThief, колона: colThief

            String currentPosition = matrix[rowThief][colThief]; //на какво е стъпил моя крадец
            if (currentPosition.equals("$")) {
                //стигнали сме къща -> ограбваме
                int stolenMoney = rowThief * colThief; //колко пари са откраднати от тази къща
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
                totalStolenMoney += stolenMoney;
                matrix[rowThief][colThief] = "D";
            } else if (currentPosition.equals("P")) {
                //стигнали полиция -> хващат ни и прекратяваме
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                matrix[rowThief][colThief] = "#";
                printMatrix(matrix);
                return;
            } else if (currentPosition.equals("+")) {
                matrix[rowThief][colThief] = "D";
            }

        }
        //минаваме през всички посоки и не сме хванати
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
