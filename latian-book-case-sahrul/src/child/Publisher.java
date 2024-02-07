package child;

public class Publisher {
    private String publisherName;
    private String country;
    private double productionCost;

    // Default Constructor
    public Publisher() {
        this.publisherName = "";
        this.country = "";
        this.productionCost = 0.0;
    }

    

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }



    // Constructor dengan Parameter
    public Publisher(String publisherName, String country, double productionCost) {
        this.publisherName = publisherName;
        this.country = country;
        this.productionCost = productionCost;
    }

    public String toString() {
        return "Publisher Name: " + publisherName + "\n" +
                "Country: " + country + "\n" +
                "Production Cost: " + productionCost;
    }


    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }
}
