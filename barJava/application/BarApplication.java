package application;

import entities.Bill;
import java.util.Scanner;

public class BarApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().toUpperCase().charAt(0);

        System.out.print("Enter quantity of beers: ");
        int beer = scanner.nextInt();

        System.out.print("Enter quantity of soft drinks: ");
        int softDrink = scanner.nextInt();

        System.out.print("Enter quantity of barbecues: ");
        int barbecue = scanner.nextInt();

        Bill customer = new Bill(gender, beer, barbecue, softDrink);

        customer.displayReport();

        scanner.close();
    }
}

