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
        getTotalSalaryCosts();
        getEmployeeWithMinSalary();
        getEmployeeWithMaxSalary();
    }

    private static void printEmployees() {
        for (Employee employee : employees) {
            System.out.printf("Сотрудник %s. Имя %s. Отдел %s. Зарплата %s\n",
                    employee.getId(),
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary()
            );
        }
    }

    private static int getTotalSalaryCosts() {
        int totalCosts = 0;
        for (Employee employee : employees) {
            totalCosts += employee.getSalary();
        }

        System.out.printf("Сумма затрат на заработную плату в месяц: %s рублей\n", totalCosts);

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

        System.out.printf("Сотрудник с минимальной заработной платой в месяц: %s . ЗП: %s рублей\n",
                employeeWithMinSalary.getName(),
                employeeWithMinSalary.getSalary()
        );

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

        System.out.printf("Сотрудник с максимальной заработной платой в месяц: %s . ЗП: %s рублей\n",
                employeeWithMaxSalary.getName(),
                employeeWithMaxSalary.getSalary()
        );

        return employeeWithMaxSalary;
    }
}