import java.util.Scanner;

public class AthletesJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many athletes? ");
        int n = scanner.nextInt();

        String tallestAthleteName = "";
        double tallestHeight = 0;
        double totalWeight = 0;
        int maleCount = 0;
        int femaleCount = 0;
        double totalFemaleHeight = 0;

        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter the data for athlete number %d:%n", i);

            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            String gender;
            do {
                System.out.print("Gender (F/M): ");
                gender = scanner.next();
                if (!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M")) {
                    System.out.println("Invalid input! Please enter F or M.");
                }
            } while (!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M"));

            double height = -1;
            while (height <= 0) {
                System.out.print("Height: ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    if (height < 0) {
                        System.out.println("Invalid input! Height cannot be negative.");
                    } else {
                        System.out.println("Invalid input! Height must be a positive value.");
                    }
                }
            }

            double weight = -1;
            while (weight <= 0) {
                System.out.print("Weight: ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    if (weight < 0) {
                        System.out.println("Invalid input! Weight cannot be negative.");
                    } else {
                        System.out.println("Invalid input! Weight must be a positive value.");
                    }
                }
            }

            totalWeight += weight;

            if (height > tallestHeight) {
                tallestHeight = height;
                tallestAthleteName = name;
            }

            if (gender.equalsIgnoreCase("M")) {
                maleCount++;
            } else {
                femaleCount++;
                totalFemaleHeight += height;
            }
        }

        System.out.println("\nREPORT:");
        System.out.printf("Average weight of athletes: %.2f%n", totalWeight / n);
        System.out.println("Tallest athlete: " + tallestAthleteName);
        System.out.printf("Percentage of men: %.1f %%%n", (double) maleCount / n * 100);

        if (femaleCount > 0) {
            System.out.printf("Average height of women: %.2f%n", totalFemaleHeight / femaleCount);
        } else {
            System.out.println("No women registered.");
        }

        scanner.close();
    }
}

