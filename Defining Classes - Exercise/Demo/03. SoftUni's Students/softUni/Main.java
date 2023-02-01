package softUni;

public class Main {
    public static void main(String[] args) {

        // Initialize the repository
        SoftUni softUni = new SoftUni(7);

// Initialize entities
        Student student = new Student("Boryana", "Dimitrova", "JavaScript");
        Student studentTwo = new Student("Joana", "Jonkova", "Java");
        Student studentThree = new Student("Desislava", "Topuzakova", "FundamentalsInMathematics");
        Student studentFour = new Student("Alex", "Raykova", "Python");
        Student studentFive = new Student("Rosica", "Nenova", "C#");

// Register Student
        String adding = softUni.insert(student);
        System.out.println(adding); // Added student Boryana Dimitrova.
        String adding1 = softUni.insert(studentTwo);
        System.out.println(adding1); // Added student Joana Jonkova.
        softUni.insert(studentThree);
        softUni.insert(studentFour);
// Remove Student
        String removal = softUni.remove(studentTwo);
        System.out.println(removal); // Removed student Joana Jonkova.
        String removal1 = softUni.remove(studentFive);
        System.out.println(removal1); // Student not found.

// Get Student
        System.out.println(softUni.getStudent("Alex", "Raykova")); // Student: Alex Raykova, Best Course – Python

// Get Statistics
        System.out.println(softUni.getStatistics());
//Hall size: 3
//Student: Boryana Dimitrova, Best Course = JavaScript
//Student: Desislava Topuzakova, Best Course = FundamentalsInMathematics
//Student: Alex Raykova, Best Course = Python

    }
}
