package StreamsFileasAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        //1. взимаме всички редове от файл input.txt
        //2. обхождаме всеки един ред -> правим всички букви главни -> записваме реда с главаните букви в нов файл
        String pathToFile = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //начин 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();*/

        //начин 2:
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = reader.readLine();
        //line == null -> нямаме такъв ред
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        writer.close();

    }
}
