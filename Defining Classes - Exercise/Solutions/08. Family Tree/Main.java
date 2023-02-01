package definingClassesExercise.familyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String info = input;
        input = scanner.nextLine();
        LinkedHashMap<String, List<String>> childrenByParents = new LinkedHashMap<>();
        List<Person> personList = new ArrayList<>();
        Set<String> inputSet = new LinkedHashSet<>();

        while (!input.equals("End")) {

            if (input.contains(" - ")) {
                String parentData = input.split(" - ")[0];
                String childData = input.split(" - ")[1];
                childrenByParents.putIfAbsent(parentData, new ArrayList<>());
                childrenByParents.get(parentData).add(childData);
                inputSet.add(parentData);
                inputSet.add(childData);
            } else {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthday = data[data.length - 1];
                Person person = new Person(name, birthday);
                personList.add(person);
            }
            input = scanner.nextLine();
        }

        for (String inputInfo : inputSet) {
            Person currentPerson = getPersonInfo(inputInfo, personList);

            for (Map.Entry<String, List<String>> entry : childrenByParents.entrySet()) {
                Person parent = getPersonInfo(entry.getKey(), personList);

                for (String childInfo : entry.getValue()) {
                    Person child = getPersonInfo(childInfo, personList);

                    if (currentPerson == child) {
                        currentPerson.addToParentList(parent);
                    } else if (currentPerson == parent) {
                        currentPerson.addToChildrenList(child);
                    }
                }
            }

        }

        System.out.println(getPersonInfo(info, personList).toString());
    }

    private static Person getPersonInfo(String info, List<Person> personList) {
        Person currentPerson = null;
        for (Person person : personList) {
            if (person.getName().equals(info) || person.getBirthday().equals(info)) {
                currentPerson = person;
            }
        }
        return currentPerson;
    }


}
