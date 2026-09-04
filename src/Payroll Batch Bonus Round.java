class Employee {
    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary; // field vs parameter clash resolved with this
    }

    public void raiseSalary(double salary) {
        this.salary += salary; // use this to refer to field
    }

    public void printFinalSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("E-101", 40000),
                new Employee("E-102", 55000),
                new Employee("E-103", 62000),
                new Employee("E-104", 48000)
        };

        for (Employee e : employees) {
            e.raiseSalary(5000);
            e.printFinalSalary();
        }
    }
}
