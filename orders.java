import java.time.LocalDateTime;

public class orders {
    private Pratos dish;
    private Usuario customer;
    private Restaurantes restaurant;
    private LocalDateTime dateOrder;
    private LocalDateTime dateDelivery;
    private String status;
    private int estimatedDeliveryTime;
    private double total;

    public Pedido(Pratos dish, Usuario customer, Restaurantes restaurant) {
        this.dish = dish;
        this.costumer = costumer;
        this.restaurant = restaurant;
        this.dateOrder = LocalDateTime.now();
        this.status = "Pending";
        this.estimatedDeliveryTime = dish.getEstimatedDeliveryTime();
        this.total = dish.getPrice();
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public User getCostumer() {
        return costumer;
    }

    public void setCostumer(User costumer) {
        this.costumer = costumer;
    }

    public Restauranst getRestaurant() {
        return restaurant;
    }

    public void setRestaurante(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getDateOrder() {
        return dataOrder;
    }

    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDateTime dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido: " + dish.getName() +
               "\nRestaurant: " + restaurant.getName() +
               "\nStatus: " + status +
               "\nTotal Value: R$" + String.format("%.2f", total) +
               "\nOrder Date: " + dateOrder +
               (dateDelivery != null ? "\nDate Delivery: " + dateDelivery : "") +
               "\nEstimated Time: " + estimatedDeliveryTime + " minutes";
    }
}
