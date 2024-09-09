package application;

import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxpayers = new ArrayList<>();

        System.out.print("How many taxpayers will you enter? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the data for taxpayer #" + i + ":");
            System.out.print("Annual salary income: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Annual services income: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Annual capital income: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Medical expenses: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Educational expenses: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxpayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            taxpayers.add(taxpayer);
        }

        for (int i = 0; i < taxpayers.size(); i++) {
            TaxPayer tp = taxpayers.get(i);
            System.out.println("\nSummary for taxpayer #" + (i + 1) + ":");
            System.out.printf("Total gross tax: %.2f%n", tp.grossTax());
            System.out.printf("Rebate: %.2f%n", tp.taxRebate());
            System.out.printf("Tax due: %.2f%n", tp.netTax());
        }

        sc.close();
    }
}

