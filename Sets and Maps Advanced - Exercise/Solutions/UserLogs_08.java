package SetasAndMaps;

import java.util.*;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //username -> списък с всички ip-a
        //всяко ip -> брой на срещанията

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            //input = "IP={IP.Address} message={A&sample&message} user={username}"
            //input.split() -> ["IP={IP.Address}", "message={A&sample&message}", "user={username}"]
            //input.split()[0] -> "IP={IP.Address}".split("=") -> ["IP", "{ip addres}"]
            //input.split()[1] -> "message={A&sample&message}".split("=") -> ["message", "{message}"]
            //input.split()[2] -> "user={username}".split("=") -> ["user", "{username}"]
            String ip = input.split("\\s+")[0].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];

            //нямаме такъв username
                if (!data.containsKey(username)) {
                    //username -> празен мап за ip-тата
                    data.put(username, new LinkedHashMap<>());
                }

            //имаме такъв username -> мап с ip-та
            //data: username (key) -> данни за ip (value)
            Map<String, Integer> currentIps = data.get(username); // ip-тата на съответния username
            //въведеното ip да не е срещано
            if (!currentIps.containsKey(ip)) {
                currentIps.put(ip, 1);
            } else {
                currentIps.put(ip, currentIps.get(ip) + 1);
            }
            input = scanner.nextLine();
        }

        for (String username : data.keySet()) {
            //data.keySet() -> списък с всички usernames
            System.out.println(username + ": ");

            //ip-тата на username
            Map<String, Integer> currentIps = data.get(username); //map с ip-ата на дадения username

            int countIps = currentIps.size(); //брой на ip-тата = брой на записите в мап
            //currentIps: ip (key) -> count(value)
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    //Последното ip за отпечатване
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    //не ми е последното ip
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }
        }
    }
}
