package tasks.Task5.t2;

// Employee class responsible only for managing employee details
 class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

// SalaryCalculator class responsible for salary calculation
 class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        switch (employee.getRole()) {
            case "Manager":
                return 7000;
            case "Developer":
                return 5000;
            default:
                return 3000;
        }
    }
}

// Main class to demonstrate the separation of responsibilities
public class SRPDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", "Developer");
        Employee emp2 = new Employee("Anna", "Manager");

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        System.out.println(emp1.getName() + "'s Salary: " + salaryCalculator.calculateSalary(emp1));
        System.out.println(emp2.getName() + "'s Salary: " + salaryCalculator.calculateSalary(emp2));
    }
}
