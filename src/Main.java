class Employee {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int department;
    private double salary;

    // Конструктор
    public Employee(String name, int department, double salary) {
        this.id = idCounter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            this.department = department;
        } else {
            System.out.println("Некорректный номер отдела.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Зарплата не может быть отрицательной.");
        }
    }

    public String toString() {
        return "ID: " + id + ", Ф.И.О: " + name + ", Отдел: " + department + ", Зарплата: " + salary;
    }

    // Переопределение метода equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class Main {
    // Объявляем массив сотрудников как поле класса
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        // Добавление сотрудников
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 70000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 3, 60000);
        employees[3] = new Employee("Попов Алексей Алексеевич", 4, 65000);
        employees[4] = new Employee("Добрыня Данил Борисович", 5, 55000);

        printAllEmployees();
        System.out.println("Сумма затрат на зарплату в месяц: " + calculateTotalSalary());

        Employee minSalaryEmployee = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + (minSalaryEmployee != null ? minSalaryEmployee.getName() : "Нет данных"));

        Employee maxSalaryEmployee = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + (maxSalaryEmployee != null ? maxSalaryEmployee.getName() : "Нет данных"));

        System.out.println("Среднее значение зарплат: " + calculateAverageSalary());
        printEmployeeNames();
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary() {
        double totalSalary = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        return (count > 0) ? totalSalary / count : 0;
    }

    public static void printEmployeeNames() {
        System.out.println("Ф.И.О. сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }
}