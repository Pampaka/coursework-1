import java.util.Objects;

public class Employee {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private byte department;
    private int salary;

    public Employee(String name, byte department, int salary) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Департамент должен быть от 1 до 5");
        }

        this.id = idCounter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department &&
                salary == employee.salary && Objects.equals(name, employee.name);
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

    @Override
    public String toString() {
        return String.format("Сотрудник %s. Имя %s. Отдел %s. Зарплата %s",
                this.id,
                this.name,
                this.department,
                this.salary
        );
    }
}
