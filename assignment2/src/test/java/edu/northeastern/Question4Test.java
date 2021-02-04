package edu.northeastern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question4Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void salaryGreaterThanFiveThousandTest1() {
        Question4 question4 = new Question4();
        Employee[] employees = {
                new Employee(27, "Abraham", 25, 25000.0),
                new Employee(25, "Malisa", 27, 30000.0),
                new Employee(30, "Cindy", 30, 5000.0),
                new Employee(17, "David", 47, 4000.0),
                new Employee(22, "Elina", 36, 7000.0),
        };
        double sumOfSalaries = question4.salaryGreaterThanFiveThousand(employees);
        assertEquals(62000.0, sumOfSalaries);
    }

    @Test
    void fizzBuzz() {
        Question4 question4 = new Question4();
        Employee employee = new Employee(27, "Abraham", 25, 25000.0);
        question4.fizzBuzz(employee);
        assertEquals("Fizz", outContent.toString());
    }

    @Test
    void swap() {
        Question4 question4 = new Question4();
        Employee firstEmployee = new Employee(27, "Abraham", 25, 25000.0);
        Employee secondEmployee = new Employee(22, "Elina", 36, 7000.0);
        question4.swap(firstEmployee, secondEmployee);
        assertEquals(7000.0, firstEmployee.getSalary());
        assertEquals(25000.0, secondEmployee.getSalary());
    }

    @Test
    void socialSecurityTax() {
        Question4 question4 = new Question4();
        Employee employee = new Employee(27, "Abraham", 25, 25000.0);
        double socialSecurityTax = question4.socialSecurityTax(employee);
        assertEquals(0.062 * 106800, socialSecurityTax);
    }

    @Test
    void insuranceCoverage() {
        Question4 question4 = new Question4();
        Employee employee = new Employee(27, "Abraham", 25, 25000.0);
        double amountOFDeduction = Question4.insuranceCoverage(employee);
        assertEquals(.03 * 25000.0, amountOFDeduction);
    }

    @Test
    void sortSalary() {
        Question4 question4 = new Question4();
        Employee e1 = new Employee(27, "Abraham", 25, 25000.0);
        Employee e2 = new Employee(22, "Elina", 36, 7000.0);
        Employee e3 = new Employee(17, "David", 47, 4000.0);
        question4.sortSalary(e1, e2, e3);
        assertEquals("David Elina Abraham", outContent.toString());
    }

    @Test
    void createEmployees() {
        Question4 question4 = new Question4();
        String[] employeeStr = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        Employee[] employees = question4.createEmployees(employeeStr);
        Employee employee1 = employees[0];
        Employee employee2 = employees[1];

        Assertions.assertEquals(1,employee1.getId());
        Assertions.assertEquals("John",employee1.getFirstName());
        Assertions.assertEquals(24,employee1.getAge());
        Assertions.assertEquals(7500.0,employee1.getSalary());

        Assertions.assertEquals(2,employee2.getId());
        Assertions.assertEquals("Hail",employee2.getFirstName());
        Assertions.assertEquals(28,employee2.getAge());
        Assertions.assertEquals(7899.90,employee2.getSalary());

    }
}