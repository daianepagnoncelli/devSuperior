import java.util.Locale;
import java.util.Scanner;

public class taxJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Annual salary income: ");
        double annualSalaryIncome = scanner.nextDouble();
        System.out.print("Annual service income: ");
        double annualServiceIncome = scanner.nextDouble();
        System.out.print("Annual capital gains: ");
        double annualCapitalGains = scanner.nextDouble();
        System.out.print("Medical expenses: ");
        double medicalExpenses = scanner.nextDouble();
        System.out.print("Educational expenses: ");
        double educationalExpenses = scanner.nextDouble();

        double monthlySalaryIncome = annualSalaryIncome / 12;
        double salaryTax;
        if (monthlySalaryIncome < 3000) {
            salaryTax = 0.0;
        } else if (monthlySalaryIncome < 5000) {
            salaryTax = annualSalaryIncome * 0.10;
        } else {
            salaryTax = annualSalaryIncome * 0.20;
        }

        double serviceTax = annualServiceIncome * 0.15;

        double capitalGainsTax = annualCapitalGains * 0.20;

        double totalGrossTax = salaryTax + serviceTax + capitalGainsTax;

        double maxDeductible = totalGrossTax * 0.30;
        double deductibleExpenses = medicalExpenses + educationalExpenses;
        double deduction = Math.min(deductibleExpenses, maxDeductible);

        double taxDue = totalGrossTax - deduction;

        System.out.println("\nINCOME TAX REPORT");
        System.out.println("INCOME SUMMARY:");
        System.out.printf("Salary tax: %.2f\n", salaryTax);
        System.out.printf("Service tax: %.2f\n", serviceTax);
        System.out.printf("Capital gains tax: %.2f\n", capitalGainsTax);
        System.out.println("DEDUCTIONS:");
        System.out.printf("Maximum deductible: %.2f\n", maxDeductible);
        System.out.printf("Deductible expenses: %.2f\n", deductibleExpenses);
        System.out.println("SUMMARY:");
        System.out.printf("Total gross tax: %.2f\n", totalGrossTax);
        System.out.printf("Deduction: %.2f\n", deduction);
        System.out.printf("Tax due: %.2f\n", taxDue);

        scanner.close();
    }
}
