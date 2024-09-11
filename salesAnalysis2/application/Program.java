package application;

import entities.Sale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

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

        Set<String> sellers = new HashSet<>();
        for (Sale sale : sales) {
            sellers.add(sale.getSeller());
        }

        System.out.println("Total sales by seller:");
        for (String seller : sellers) {
            double totalSalesBySeller = sales.stream()
                    .filter(s -> s.getSeller().equals(seller))
                    .mapToDouble(Sale::getTotal)
                    .sum();

            System.out.printf("%s - R$ %.2f%n", seller, totalSalesBySeller);
        }

        sc.close();
    }
}

