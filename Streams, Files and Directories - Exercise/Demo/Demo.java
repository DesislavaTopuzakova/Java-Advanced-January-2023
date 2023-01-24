import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
       //WRITERS -> ПИШЕМ ВЪВ ФАЙЛОВЕТЕ
        String pathToFile = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demoFileWriter.txt";
        String pathToFile2 = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demoBufferedWriter.txt";
        //1. FileWriter
        File file = new File(pathToFile);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is a demo of file writer.");
        fileWriter.close();

        //2. BufferedWriter -> по-бърз от FileWriter
        File fileForBuffered = new File(pathToFile2);
        FileWriter fileWriter2 = new FileWriter(fileForBuffered);
        BufferedWriter bfWriter = new BufferedWriter(fileWriter2);
        bfWriter.write("This is a demo of buffered writer.");
        bfWriter.close();


    }
}
