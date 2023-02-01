package Google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        //име на човека -> данни
        Map<String, Person> peopleData = new HashMap<>();
        while (!information.equals("End")) {
            //•	"{Name} company {companyName} {department} {salary}"
            //•	"{Name} pokemon {pokemonName} {pokemonType}"
            //•	"{Name} parents {parentName} {parentBirthday}"
            //•	"{Name} children {childName} {childBirthday}"
            //•	"{Name} car {carModel} {carSpeed}"
            String [] parameters = information.split("\\s+");
            String personName = parameters[0];
            //проверка има ли такъв човек в списъка
            if (!peopleData.containsKey(personName)) {
                peopleData.put(personName, new Person());
            }
            String typeCommand = parameters[1];//"company", "pokemon", "parents", "children", "car"
            switch (typeCommand) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleData.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Child child = new Child(childName, childBirthday);
                    peopleData.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleData.get(personName).setCar(car);
                    break;
            }

            information = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        //данните на човек
        Person personalData = peopleData.get(searchedPerson);
        System.out.println(personalData);

    }
}
