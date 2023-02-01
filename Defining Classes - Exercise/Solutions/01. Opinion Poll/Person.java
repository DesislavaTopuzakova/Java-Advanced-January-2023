package OpinionPoll_01;

public class Person {
    //характеристики - име, възраст
    private String name;
    private int age;

    //конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getter -> върне стойността на полето name
    public String getName() {
        return name;
    }

    //getter -> връща стойността на полето age
    public int getAge() {
        return age;
    }

    //toString
    @Override
    public String toString() {
        //връща обектът под формата на текст
        //обект = тескт "{name} - {age}"
        return name + " - " + age;
    }
}
