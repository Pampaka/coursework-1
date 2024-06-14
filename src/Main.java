public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.printEmployees();

        double totalCosts = employeeBook.getTotalSalaryCosts();
        System.out.printf("Сумма затрат на заработную плату в месяц: %.2f рублей\n", totalCosts);

        Employee employeeWithMinSalary = employeeBook.getEmployeeWithMinSalary();
        if (employeeWithMinSalary != null) {
            System.out.printf("Сотрудник с минимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    employeeWithMinSalary.getName(),
                    employeeWithMinSalary.getSalary()
            );
        }

        Employee employeeWithMaxSalary = employeeBook.getEmployeeWithMaxSalary();
        if (employeeWithMaxSalary != null) {
            System.out.printf("Сотрудник с максимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    employeeWithMaxSalary.getName(),
                    employeeWithMaxSalary.getSalary()
            );
        }

        double averageSalary = employeeBook.getAverageSalary();
        System.out.printf("Среднее значение зарплат: %.2f рублей\n", averageSalary);

        employeeBook.printEmployeesNames();

        employeeBook.indexSalaries(10.12);
        employeeBook.printEmployees();

        byte department = 2;
        Employee employeeWithMinSalaryByDepartment = employeeBook.getEmployeeWithMinSalaryByDepartment(department);
        if (employeeWithMinSalaryByDepartment != null) {
            System.out.printf("Сотрудник отдела %s с минимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    department,
                    employeeWithMinSalaryByDepartment.getName(),
                    employeeWithMinSalaryByDepartment.getSalary()
            );
        }

        Employee employeeWithMaxSalaryByDepartment = employeeBook.getEmployeeWithMaxSalaryByDepartment(department);
        if (employeeWithMaxSalaryByDepartment != null) {
            System.out.printf("Сотрудник отдела %s с максимальной заработной платой в месяц: %s ЗП: %.2f рублей\n",
                    department,
                    employeeWithMaxSalaryByDepartment.getName(),
                    employeeWithMaxSalaryByDepartment.getSalary()
            );
        }

        double totalCostsByDepartment = employeeBook.getTotalSalaryCostsByDepartment(department);
        System.out.printf("Сумма затрат на заработную плату в месяц по отделу %s: %.2f рублей\n",
                department,
                totalCostsByDepartment
        );

        double averageSalaryByDepartment = employeeBook.getAverageSalaryByDepartment(department);
        System.out.printf("Среднее значение зарплат по отделу %s: %.2f рублей\n",
                department,
                averageSalaryByDepartment
        );

        employeeBook.indexSalariesByDepartment(10.12, department);
        employeeBook.printEmployeesByDepartment(department);

        System.out.println();
        employeeBook.printEmployeesSalaryLt(40000);

        System.out.println();
        employeeBook.printEmployeesSalaryGte(40000);

        boolean addResult = employeeBook.addEmployee(new Employee("Неуловимый М.В.", (byte) 5, 52121));
        System.out.println(addResult);
        employeeBook.removeEmployee(6);
        addResult = employeeBook.addEmployee(new Employee("Пойманный М.В.", (byte) 5, 52121));
        System.out.println(addResult);
    }
}
