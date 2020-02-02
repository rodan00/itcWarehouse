package Product;

import java.time.LocalDate;

public class Product {


        private String name;
        private Double price;
        private String productId;
        private LocalDate date;
        private String category;


    public Product(String name, Double price,
                   String productId, String category) {
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.date = LocalDate.now();
        this.category=category;
    }

    public Product(String name, Double price,
                   String productId,LocalDate date, String category) {
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.date = date;
        this.category=category;
    }

    public String getName() {return name;}
    public Double getPrice() {return price;}
    public String getProductId() {return productId;}
    public LocalDate getDate() {return date;}
    public String getCategory() {return category;}

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", $=" + price +
                ", Id='" + productId + '\'' +
                ", date=" + date +'\''+
                ", cat="+category+
                '}';
    }
}



