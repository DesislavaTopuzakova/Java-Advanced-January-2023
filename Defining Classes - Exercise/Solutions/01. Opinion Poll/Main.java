package OpinionPoll_01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String personalInformation = scanner.nextLine(); //"Peter 12".split(" ") -> ["Peter", "12"]
            String name = personalInformation.split("\\s+")[0];
            int age = Integer.parseInt(personalInformation.split("\\s+")[1]);
            Person person = new Person(name, age);
            peopleList.add(person);
        }
        //филтрирай списъка -> само хората над 30
        peopleList = peopleList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());

        //сортирам списъка по име на хората
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        //отпечатваме списъка
        for (Person person : peopleList) {
            //име - възраст
            //обект под формата на текст
            System.out.println(person.toString());
        }
    }
}
