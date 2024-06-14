public class Main {
    static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[]{
                new Employee("Васильев И.В.", (byte) 1, 30000),
                new Employee("Иванов Д.К.", (byte) 1, 42586),
                new Employee("Свердлов Л.С.", (byte) 2, 48735),
                new Employee("Родной Е.В.", (byte) 1, 96845),
                new Employee("Лисов М.Е.", (byte) 5, 53542),
                new Employee("Крабов С.Ш.", (byte) 3, 47650),
                new Employee("Аврик Т.Ф.", (byte) 2, 45850),
                new Employee("Виноградный О.В.", (byte) 1, 35457),
                new Employee("Шляп И.С.", (byte) 2, 68721),
                new Employee("Вишня Л.Г.", (byte) 4, 47866)
        };

        printEmployees();

        double totalCosts = getTotalSalaryCosts();
        System.out.printf("Сумма затрат на заработную плату в месяц: %.2f рублей\n", totalCosts);

        Employee employeeWithMinSalary = getEmployeeWithMinSalary();
        if (employeeWithMinSalary != null) {
            System.out.printf("Сотрудник с минимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    employeeWithMinSalary.getName(),
                    employeeWithMinSalary.getSalary()
            );
        }

        Employee employeeWithMaxSalary = getEmployeeWithMaxSalary();
        if (employeeWithMaxSalary != null) {
            System.out.printf("Сотрудник с максимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    employeeWithMaxSalary.getName(),
                    employeeWithMaxSalary.getSalary()
            );
        }

        double averageSalary = getAverageSalary();
        System.out.printf("Среднее значение зарплат: %.2f рублей\n", averageSalary);

        printEmployeesNames();

        indexSalaries(10.12);
        printEmployees();

        byte department = 2;
        Employee employeeWithMinSalaryByDepartment = getEmployeeWithMinSalaryByDepartment(department);
        if (employeeWithMinSalaryByDepartment != null) {
            System.out.printf("Сотрудник отдела %s с минимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    department,
                    employeeWithMinSalaryByDepartment.getName(),
                    employeeWithMinSalaryByDepartment.getSalary()
            );
        }
    }

    private static void printEmployees() {
        if (employees.length == 0) {
            System.out.println("Нет ни одного сотрудника");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static double getTotalSalaryCosts() {
        double totalCosts = 0;
        for (Employee employee : employees) {
            totalCosts += employee.getSalary();
        }

        return totalCosts;
    }

    private static Employee getEmployeeWithMinSalary() {
        if (employees.length == 0) return null;

        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    private static Employee getEmployeeWithMaxSalary() {
        if (employees.length == 0) return null;

        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }

        return employeeWithMaxSalary;
    }

    private static double getAverageSalary() {
        if (employees.length == 0) return 0f;
        return getTotalSalaryCosts() / employees.length;
    }

    private static void printEmployeesNames() {
        if (employees.length == 0) {
            System.out.println("Нет ни одного сотрудника");
            return;
        }

        System.out.println("Список сотрудников: ");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    private static void indexSalaries(double percent) {
        double index = 1 + 1 / percent;
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() * index);
        }
    }

    private static Employee getEmployeeWithMinSalaryByDepartment(byte department) {
        if (employees.length == 0) return null;

        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) continue;

            if (employeeWithMinSalary == null) {
                employeeWithMinSalary = employee;
            } else if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }
}
