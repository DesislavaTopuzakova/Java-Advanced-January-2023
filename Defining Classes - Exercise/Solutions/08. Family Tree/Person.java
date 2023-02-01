package definingClassesExercise.familyTree;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parentsList;
    private List<Person> childrenList;


    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void addToParentList(Person person) {
        if (isNew(person, parentsList)) {
            this.parentsList.add(person);
        }
    }

    public void addToChildrenList(Person person) {
        if (isNew(person, childrenList)) {
            this.childrenList.add(person);
        }
    }

    public boolean isNew(Person person, List<Person> personList) {
        for (Person p : personList) {
            if (p.equals(person)) {
                return false;
            }
        }
        return true;
    }



    public String getOutputForList(List<Person> list) {
        StringBuilder output = new StringBuilder();

        if (!list.isEmpty()) {
            for (Person p : list) {
                output.append(String.format("%s %s%n", p.getName(), p.getBirthday()));
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s%nParents:%n%sChildren:%n%s", name, String.join("/", birthday), getOutputForList(parentsList), getOutputForList(childrenList));
    }
}
