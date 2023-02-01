import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String employeeData = scanner.nextLine();
            String[] parameters = employeeData.split(" ");
            //вианги имаме name, salary, position, department
            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];
            Employee employee = null;
            //6 параметъра -> name, salary, position, department, email, age
            if(parameters.length == 6) {
                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);
               employee = new Employee(name, salary, position, department, email, age);
            }
            //5 параметъра -> name, salary, position, department, email / age
            else if (parameters.length == 5) {
                String parameterForth = parameters[4];
                if(parameterForth.contains("@")) {
                    String email = parameterForth;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(parameterForth);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            //4 параметъра -> name, salary, position, department
            else if (parameters.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            // обект Employee


            //име на отдел -> отедел

            //проверка дали го няма
            if(!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }

            //добавим служителя в списъка със служителите на отдела
            departments.get(department).getEmployees().add(employee);

        }

        //отдел -> Отдел (име, списък със служители)
        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
