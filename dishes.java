public class dishes {
    private String name;
    private double price;
    private String description;
    private int estimatedDeliveryTime;

    public Pratos(String name, double price, String description, int estimatedDeliveryTime) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(int estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
