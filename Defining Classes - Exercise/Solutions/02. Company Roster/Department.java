import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public double getAverageSalary() {
        /*double sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary / employees.size();*/
        return this.employees
                .stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0.0);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public String getName() {
        return this.name;
    }
}
