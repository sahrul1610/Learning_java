package model;

public class Product {
    int productId;
    Supplier supplier;
    String productName;
    String unit;
    double price;

    public Product(int productId, Supplier supplier, String productName, String unit, double price) {
        this.productId = productId;
        this.supplier = supplier;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    
}
