package pro.sky.calculator.employee_work.employee;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer department;
    private Integer salary;

    public Employee(String firstName, String lastName, Integer department, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee emp)) return false;
        return firstName.equals(emp.firstName) && lastName.equals(emp.lastName);
    }

    @Override
    public int hashCode() {
        return 31 * firstName.hashCode() + lastName.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Employee(firstName='%s', lastName='%s')",
                firstName, lastName);
    }
}
