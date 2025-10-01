import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class user extends person {
    private String email;
    private String password;
    private transient LocalDateTime dateRegistration;
    private transient LocalDateTime dateUpdate;
    private List<Order> orders = new ArrayList<>();

    public user(String name, String email, String password, String address, String telephone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.telephone = telephone;
        this.dateRegistration = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public void validateData() {
        if (name == null || email == null || password == null) {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    public String getType() {
        return "Costumer";
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
