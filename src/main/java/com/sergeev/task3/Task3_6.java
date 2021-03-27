package main.java.com.sergeev.task3;

import java.util.List;
import java.util.Objects;

/**
 * Task calculates the general number of employees with salary >= threshold for all departments
 * whose code starts with string "111-".
 */
public class Task3_6 {

    public static void main(String[] args) {
        Employee employeeFirst = new Employee("William", 20000l);
        Employee employeeSecond = new Employee("Sophia", 10000l);
        Employee employeeThird = new Employee("John", 50000l);

        Department departmentFirst = new Department("dep-1", "111-1", List.of(employeeFirst, employeeSecond));
        Department departmentSecond = new Department("dep-2", "222-1", List.of(employeeThird));
        List<Department> departments = List.of(departmentFirst, departmentSecond);

        System.out.println(calcNumberOfEmployees(departments, 20000));
    }

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(d -> d.getCode().startsWith("111-"))
                .flatMap(d -> d.getEmployees().stream())
                .filter(e -> e.getSalary() >= threshold).count();
    }

    static class Department {

        private String name;
        private String code;
        List<Employee> employees;

        public Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(employees, that.employees);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, code, employees);
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }

    static class Employee {

        private String name;
        private Long salary;

        public Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
