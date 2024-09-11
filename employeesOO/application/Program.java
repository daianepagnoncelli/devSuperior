package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Department name: ");
        String departmentName = sc.nextLine();
        System.out.print("Payment day: ");
        int payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();

        Department dept = new Department(departmentName, payDay, email, phone);

        System.out.print("How many employees are in the department? ");
        int numberOfEmployees = sc.nextInt();

        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("Enter data for employee " + i + ":");
            sc.nextLine();
            System.out.print("Name: ");
            String employeeName = sc.nextLine();
            System.out.print("Salary: ");
            double employeeSalary = sc.nextDouble();

            Employee emp = new Employee(employeeName, employeeSalary);
            dept.addEmployee(emp);
        }

        showReport(dept);

        sc.close();
    }

    private static void showReport(Department dept) {
        System.out.println();
        System.out.println("PAYROLL REPORT:");
        System.out.printf("Department %s = $ %.2f\n", dept.getName(), dept.payroll());
        System.out.printf("Payment made on day %d\n", dept.getPayDay());
        System.out.println("Employees:");
        for (Employee emp : dept.getEmployees()) {
            System.out.println(emp.getName());
        }
        System.out.printf("For inquiries, please contact: %s\n", dept.getEmail());
    }
}
