package entities;

public class Sale {
    private final Integer month;
    private final Integer year;
    private final String seller;
    private final Integer items;
    private final Double total;

    public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
        this.month = month;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return month + "/" + year + ", " + seller + ", " + items + ", " + String.format("%.2f", total);
    }
}
