package StreamsFileasAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        //1. всички редове от файл input.txt
        //2. за всеки ред -> намирам суамта от аscii -> принтираме сумата

        String pathToFile = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        //начин 1:
       /* for (String line : allLines) {
            //line = "Michael Angelo, "
            int sum = 0; //сума от кодовете на символите на този ред
            for (char symbol : line.toCharArray()) {
                sum += (int) symbol;
            }
            System.out.println(sum);
        }*/

        //начин 2:
        allLines.forEach(line -> {
                    int sum = 0; //сума от кодовете на символите на този ред
                    for (char symbol : line.toCharArray()) {
                        sum += (int) symbol;
                    }
                    System.out.println(sum);
                });

        //начин 3:
        /*allLines.stream()
                .map(line -> line.toCharArray())
                .forEach(arr -> { //за всеки един масив от символи
                    int sum = 0; //сума от кодовете на символите на този ред
                    for (char symbol : arr) {
                        sum += (int) symbol;
                    }
                    System.out.println(sum);
                });*/
    }
}
