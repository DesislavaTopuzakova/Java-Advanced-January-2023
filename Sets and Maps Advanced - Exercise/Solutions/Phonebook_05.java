package SetasAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //име на човек -> телефонен номер
        Map<String, String> phonebook = new HashMap<>();
        String data = scanner.nextLine();

        //1. запълване на phonebook
        while (!data.equals("search")) {
            //data = "John-0888080808".split("-") -> ["John", "0888080808"]
            String name = data.split("-")[0];
            String phoneNumber = data.split("-")[1];
            phonebook.put(name, phoneNumber);
            data = scanner.nextLine();
        }

        //2. търсене в phonebook
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            //ако името го има в phonebook (име -> номер): "{name} -> {number}"
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            }
            //ако името го няма в phonebook: "Contact {name} does not exist."
            else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }

    }
}
