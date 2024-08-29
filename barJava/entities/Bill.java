package entities;

public class Bill {
    private final char gender;
    private final int beer;
    private final int barbecue;
    private final int softDrink;

    public Bill(char gender, int beer, int barbecue, int softDrink) {
        this.gender = gender;
        this.beer = beer;
        this.barbecue = barbecue;
        this.softDrink = softDrink;
    }

    public double cover() {
        double consumption = feeding();
        if (consumption > 30.0) {
            return 0.0;
        } else {
            return 4.0;
        }
    }

    public double feeding() {
        return beer * 5.0 + softDrink * 3.0 + barbecue * 7.0;
    }

    public double ticket() {
        if (gender == 'M') {
            return 10.0;
        } else {
            return 8.0;
        }
    }

    public double total() {
        return feeding() + cover() + ticket();
    }

    public void displayReport() {
        System.out.println("REPORT:");
        System.out.printf("Consumption = R$ %.2f%n", feeding());
        if (cover() == 0.0) {
            System.out.println("Exempt from Cover Charge");
        } else {
            System.out.printf("Cover Charge = R$ %.2f%n", cover());
        }
        System.out.printf("Ticket = R$ %.2f%n", ticket());
        System.out.printf("Total Amount to Pay = R$ %.2f%n", total());
    }
}


