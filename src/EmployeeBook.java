public class EmployeeBook {
    public Employee[] employees;

    public EmployeeBook() {
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
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean addEmployee(String name, byte department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee employee = new Employee(name, department, salary);
                employees[i] = employee;
                return true;
            }
        }

        return false;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }

        return false;
    }

    public void printEmployees() {
        boolean hasEmployees = false;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
                hasEmployees = true;
            }
        }

        if (!hasEmployees) {
            System.out.println("Нет ни одного сотрудника");
        }
    }

    public double getTotalSalaryCosts() {
        double totalCosts = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalCosts += employee.getSalary();
            }
        }

        return totalCosts;
    }

    public Employee getEmployeeWithMinSalary() {
        if (employees.length == 0) return null;

        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee == null) continue;

            if (employeeWithMinSalary == null) {
                employeeWithMinSalary = employee;
            } else if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaxSalary() {
        if (employees.length == 0) return null;

        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee == null) continue;

            if (employeeWithMaxSalary == null) {
                employeeWithMaxSalary = employee;
            } else if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }

        return employeeWithMaxSalary;
    }

    public double getAverageSalary() {
        if (employees.length == 0) return 0f;

        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) count++;
        }
        return getTotalSalaryCosts() / count;
    }

    public void printEmployeesNames() {
        System.out.println("Список сотрудников: ");
        boolean hasEmployees = false;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
                hasEmployees = true;
            }
        }

        if (!hasEmployees) {
            System.out.println("Нет ни одного сотрудника");
        }
    }

    public void indexSalaries(double percent) {
        double index = 1 + 1 / percent;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    public Employee getEmployeeWithMinSalaryByDepartment(byte department) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) continue;

            if (employeeWithMinSalary == null) {
                employeeWithMinSalary = employee;
            } else if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(byte department) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) continue;

            if (employeeWithMaxSalary == null) {
                employeeWithMaxSalary = employee;
            } else if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }

        return employeeWithMaxSalary;
    }

    public double getTotalSalaryCostsByDepartment(byte department) {
        double totalCosts = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalCosts += employee.getSalary();
            }
        }

        return totalCosts;
    }

    public double getAverageSalaryByDepartment(byte department) {
        int count = 0;
        double totalCosts = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalCosts += employee.getSalary();
                count++;
            }
        }

        return totalCosts / count;
    }

    public void indexSalariesByDepartment(double percent, byte department) {
        double index = 1 + 1 / percent;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    public void printEmployeesByDepartment(byte department) {
        boolean hasEmployees = false;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.toStringMainData());
                hasEmployees = true;
            }
        }

        if (!hasEmployees) {
            System.out.println("В отделе нет ни одного сотрудника");
        }
    }

    public void printEmployeesSalaryLt(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.printf("Сотрудник %s. Имя %s. Зарплата %.2f\n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void printEmployeesSalaryGte(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.printf("Сотрудник %s. Имя %s. Зарплата %.2f\n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSalary()
                );
            }
        }
    }
}
