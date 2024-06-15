import java.util.Objects;

public class Employee {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private byte department;
    private double salary;

    public Employee(String name, byte department, double salary) {
        this.validateDepartment(department);

        this.id = idCounter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(byte department) {
        this.validateDepartment(department);
        this.department = department;
    }

    public byte getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    private void validateDepartment(byte department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
    }

    public String toStringMainData() {
        return String.format("Сотрудник %s. Имя %s. Зарплата %.2f",
                this.id,
                this.name,
                this.salary
        );
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %s. Имя %s. Отдел %s. Зарплата %.2f",
                this.id,
                this.name,
                this.department,
                this.salary
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
