import java.util.ArrayList;
import java.time.LocalDateTime;

public class deliveries {
    private ArrayList<Order> ordersInProgress;
    private ArrayList<Order> ordersDelivered;

    public Entregas() {
        this.ordersInProgress = new ArrayList<>();
        this.ordersDelivered = new ArrayList<>();
    }

    public void addOrder(Order order) {
        ordersInProgress.add(order);
    }

    public ArrayList<Order> listOrdersInProgress() {
        return ordersInProgress;
    }

    public ArrayList<Order> listOrdersDelivered() {
        return ordersDelivered;
    }

    public void markAsDelivered(Order order) {
        if (ordersInProgress.contains(order)) {
            ordersInProgress.remove(order);
            ordersDelivered.add(order);
            order.setDataEntrega(LocalDateTime.now());
        }
    }

    public boolean checkDelay(Order order) {
        if (order.getDeliveryDate() == null) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime deliveryForecast = order.getDeliveryDate().plusMinutes(order.getEstimatedDeliveryTime());
            return now.isAfter(deliveryForecast);
        }
        return false;
    }

    public ArrayList<Order> listLateOrders() {
        ArrayList<Order> lateOrders = new ArrayList<>();
        for (Order order : ordersInProgress) {
            if (checkDelay(order)) {
                lateOrders.add(order);
            }
        }
        return lateOrders;
    }
}
