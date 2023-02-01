package ObjectsAndClasses.CarsSalesman;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ДВИГАТЕЛИ
        List<Engine> engines = new ArrayList<>();
        int enginesCount = Integer.parseInt(scanner.nextLine());
        for (int engineCount = 1; engineCount <= enginesCount ; engineCount++) {
            //"{Model} {Power} {Displacement} {Efficiency}".split(" ")
            //1. ["model", "power", "displacement", "efficiency"]
            //2. ["model", "power", "efficiency"]
            //3. ["model", "power", "displacement"]
            //required: model, power
            //optional: displacement, efficiency
            String [] engineData = scanner.nextLine().split("\\s+");
            //required
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            //optional
            int displacement = 0;
            String efficiency = null;

            //проверка дали са ми въведени displacement и efficiency
            if (engineData.length == 4) {
                //["model", "power", "displacement", "efficiency"]
                //displacement и efficiency са въведени
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3){
                //["model", "power", "displacement"] -> ["model", "432", "54"]
                //["model", "power", "efficiency"] -> ["model", "432", "b"]
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }

            }

            //model, power, displacement, efficiency
            Engine engine = new Engine(model, power, displacement, efficiency);
            //добавям двигателя в списъка
            engines.add(engine);
        }

        //КОЛИ
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int carCount = 1; carCount <= carsCount; carCount++) {
            //"{Model} {Engine} {Weight} {Color}"
            String[] carData = scanner.nextLine().split("\\s+");
            //1. ["{Model}", "{Engine Model}", "{Weight}", "{Color}"]
            //2. ["{Model}", "{Engine Model}", "{Weight}"]
            //3. ["{Model}", "{Engine Model}", "{Color}"]
            //required
            String carModel = carData[0];
            String engineModel = carData[1]; //модел на двигателя
            //optional
            int weight = 0;
            String color = null;

            //проверка какво ни е въведено
            if (carData.length == 4) {
                //1. ["{Model}", "{Engine Model}", "{Weight}", "{Color}"]
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                //2. ["{Model}", "{Engine Model}", "5464"]
                //3. ["{Model}", "{Engine Model}", "red"]
                if (Character.isDigit(carData[2].charAt(0))) {
                    //2. ["{Model}", "{Engine Model}", "5464"] -> има въведено тегло
                    weight = Integer.parseInt(carData[2]);
                } else {
                    //3. ["{Model}", "{Engine Model}", "red"] -> имаме въведен цвят
                    color = carData[2];
                }
            }

            //намеря кой е двигателя от въведените
            //списък с налични двигатели -> намеря двигателя
            Engine carEngine = null; //двигателя на колата
            for (Engine engine : engines) {
                if (engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(carModel, carEngine, weight, color);
            System.out.print(car.toString());
        }
    }
}
