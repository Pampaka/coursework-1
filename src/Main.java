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
}