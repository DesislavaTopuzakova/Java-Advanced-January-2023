package SetasAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine(); //име на човек

        //име на човек -> email на човек
        Map<String, String> emailsData = new LinkedHashMap<>();

        //1. съхраняваме данните за хората и техните имейли
        while (!name.equals("stop")) {
            String email = scanner.nextLine(); //email на човек
            emailsData.put(name, email);
            name = scanner.nextLine();
        }

        //2. премахвам всички записи, на които value (email) завършва на uk, us, com
        //removeIf -> премахва всички записи, които отговарят на условието
        emailsData.entrySet().removeIf(entry ->
                                        entry.getValue().endsWith("uk")
                                                || entry.getValue().endsWith("us")
                                                || entry.getValue().endsWith("com"));
        //запис: име(key) -> имейл(value)
        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
