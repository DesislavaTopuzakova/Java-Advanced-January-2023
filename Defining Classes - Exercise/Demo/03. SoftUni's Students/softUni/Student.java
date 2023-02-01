package softUni;

public class Student {
    //ХАРАКТЕРИСТИКИ (ПОЛЕТА)
    private String firstName;
    private String lastName;
    private String bestCourse;

    //конструктор
    public Student(String firstName, String lastName, String bestCourse) {
        //нов празен обект
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestCourse = bestCourse;
    }

    //getters (взимате стойност на полето) and setters (задаваме стойност на полето)


    //field firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //field lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //field bestCourse
    public String getBestCourse() {
        return bestCourse;
    }

    public void setBestCourse(String bestCourse) {
        this.bestCourse = bestCourse;
    }

    @Override
    public String toString() {
        //представя всеки един обект под формата на текст
        //"Student: {firstName} {lastName}, Best Course = {bestCourse}"
        return String.format("Student: %s %s, Best Course = %s", this.firstName, this.lastName, this.bestCourse);
    }
}
