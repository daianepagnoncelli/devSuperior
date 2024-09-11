package application;

import entities.Sale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        System.out.print("Enter the path of the file: ");
        String path = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                Integer month = Integer.parseInt(fields[0]);
                Integer year = Integer.parseInt(fields[1]);
                String seller = fields[2];
                Integer items = Integer.parseInt(fields[3]);
                Double total = Double.parseDouble(fields[4]);

                sales.add(new Sale(month, year, seller, items, total));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // 1
        List<Sale> topSales2016 = sales.stream()
                .filter(s -> s.getYear() == 2016)
                .sorted(Comparator.comparing(Sale::averagePrice).reversed())
                .limit(5)
                .toList();

        System.out.println("Top 5 highest average price sales of 2016:");
        topSales2016.forEach(System.out::println);

        // 2
        double totalLogan = sales.stream()
                .filter(s -> s.getSeller().equals("Logan") && (s.getMonth() == 1 || s.getMonth() == 7))
                .mapToDouble(Sale::getTotal)
                .sum();

        System.out.printf("Total sales by Logan in months 1 and 7 = %.2f%n", totalLogan);

        sc.close();
    }
}
