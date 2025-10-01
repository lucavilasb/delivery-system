import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class restaurants extends person {
    private String cnpj;
    private ArrayList<Dishes> dishes;
    private List<Order> orders = new ArrayList<>();
    private transient LocalDateTime dateRegistration;
    private transient LocalDateTime dateUpdate;
    private String password;

    public Restaurantes(String name, String address, String telephone, String cnpj, String password) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.cnpj = cnpj;
        this.password = password;
        this.dishes = new ArrayList<>();
        this.dateRegistration = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public void validateData() {
        if (name == null || cnpj == null) {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    public String getType() {
        return "Restaurants";
    }

    public void registerRestaurant(String name, String address, String telephone, String cnpj) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.cnpj = cnpj;
    }

    public void registerDish(Dishes dish) {
        dishes.add(dish);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dishes> dishes) {
        this.dishes = dishes;
    }

    public void receiveOrder(Order order) {
        orders.add(order);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public LocalDateTime getRegistrationData() {
        return registrationData;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
