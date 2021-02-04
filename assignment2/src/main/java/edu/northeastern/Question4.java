package edu.northeastern;

public class Question4 {
    /*
	     Write a method to calculate an employee's contribution for insurance coverage and print it.
	     Amount of deduction is computed as follows:
	     If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
	     If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
	*/
    public static double insuranceCoverage(Employee employee) {
        double amountOFDeduction = 0.0;
        if (employee.getAge() < 35)
            amountOFDeduction = .03 * employee.getSalary();
        else if (employee.getAge() >= 35 && employee.getAge() <= 50)
            amountOFDeduction = .04 * employee.getSalary();
        else if (employee.getAge() > 50 && employee.getAge() < 60)
            amountOFDeduction = .05 * employee.getSalary();
        else if (employee.getAge() > 60)
            amountOFDeduction = .06 * employee.getSalary();
        return amountOFDeduction;
    }

    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
    */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sumOfSalaries = 0.0;
        for (Employee employee : employees) {
            if (employee.getSalary() > 5000.0) {
                sumOfSalaries += employee.getSalary();
            }
        }
        return sumOfSalaries;
    }

    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
    */
    public void fizzBuzz(Employee employee) {
        boolean fizz = false;
        boolean buzz = false;
        if ((employee.getId() % 3) == 0)
            fizz = true;
        if ((employee.getId() % 5) == 0)
            buzz = true;
        if (fizz && buzz)
            System.out.print("FizzBuzz");
        else if (fizz)
            System.out.print("Fizz");
        else if (buzz)
            System.out.print("Buzz");
    }

    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        Double tempSalary = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tempSalary);
    }

    /*
	     Write a method to calculate the Social Security Tax of an employee and print it.
	     If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
	     If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
	*/
    public double socialSecurityTax(Employee employee) {
        double socialSecurityTax = 0.0;
        if (employee.getSalary() <= 8900)
            socialSecurityTax = 0.062 * employee.getSalary();
        else if (employee.getSalary() > 8900)
            socialSecurityTax = 0.062 * 106800;
        return socialSecurityTax;
    }

    /*
	     Write a method to sort three employees' salary from low to high, and then print their name in order.
	     For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
	     John Alice Jenny
	*/

    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        String outString = "";
        if (e1.getSalary() < e2.getSalary() && e1.getSalary() < e3.getSalary()) {
            if (e2.getSalary() < e3.getSalary()) {
                //e1<e2<e3
                outString = e1.getFirstName() + " "+ e2.getFirstName() + " "+ e3.getFirstName();
            } else {
                //e1<e3<e2
                outString = e1.getFirstName() + " " + e3.getFirstName() + " " + e2.getFirstName();
            }
        } else if (e2.getSalary() < e1.getSalary() && e2.getSalary() < e3.getSalary()) {
            if (e1.getSalary() < e3.getSalary()) {
                //e2<e1<e3
                outString = e2.getFirstName() + " " + e1.getFirstName() + " " + e3.getFirstName();
            } else {
                //e2<e3<e1
                outString = e2.getFirstName() + " " + e3.getFirstName() + " "+ e1.getFirstName();
            }
        } else if (e3.getSalary() < e1.getSalary() && e3.getSalary() < e2.getSalary()) {
            if (e1.getSalary() < e2.getSalary()) {
                //e3<e1<e2
                outString = e3.getFirstName() + " "+ e1.getFirstName() + " " + e2.getFirstName();
            } else {
                //e3<e2<e1
                outString = e3.getFirstName() + " "+ e2.getFirstName()+ " "+ e1.getFirstName();
            }
        }
        System.out.print(outString);
    }

    /***************** Additional question for Extra Credit *****************/
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
    */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        String[] employeeSplit;
        int i=0;
        for (String employeeStr:employeesStr
             ) {
            employeeSplit = employeeStr.split(",");
            employees[i] = new Employee(Integer.parseInt(employeeSplit[0]), employeeSplit[1],Integer.parseInt(employeeSplit[2]),Double.parseDouble(employeeSplit[3]));
            i++;
        }
        return employees;
    }

}
