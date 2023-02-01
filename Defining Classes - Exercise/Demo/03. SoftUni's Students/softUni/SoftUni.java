package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    //ХАРАКТЕРИСТИКИ
    private int capacity;
    private List<Student> data;

    //конструктор
    public SoftUni(int capacity) {
        //нов празен обект
        this.capacity = capacity;
        //заменяме null с празен списък, за да мога да добавям в списъка
        this.data = new ArrayList<>();
    }

    //методи
    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        //o	Returns "Added student {firstName} {lastName}." –  if the student is successfully added.
        //o	Returns "Student is already in the hall." –  if the student is already in the hall.
        if (getCount() + 1 > this.capacity) {
            //не може да влезе още един студент
            return "The hall is full.";
        } else {
            //може да влезе в залата, но вече го има
            if (this.data.contains(student)) {
                return "Student is already in the hall.";
            } else {
                //може да влезе в залата и го вече го няма
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
    }

    public String remove(Student student) {
        //имаме такъв студент -> махаме от списъка
        if (this.data.contains(student)) {
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        //нямаме такъв студент
        else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.data ) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        this.data.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
        return sb.toString();
    }

}
