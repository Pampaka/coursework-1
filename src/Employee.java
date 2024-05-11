import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private int id;
    private String name;
    private byte department;
    private int salary;

    public Employee(String name, byte department, int salary) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public byte getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
