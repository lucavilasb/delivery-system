import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class src {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Restaurants> restaurants = new ArrayList<>();
    private static User userLogged = null;
    private static Restaurants restaurantsLogged = null;
    private static Deliveries systemDeliveries = new Deliveries();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            running = menuPrincipal();
        }
        scanner.close();
        System.out.println("Thank you for your preference, come back soon.");
    }

    private static boolean menuPrincipal() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Customer Login");
        System.out.println("2. Restaurants Login");
        System.out.println("3. Register Customer");
        System.out.println("4. Register Restaurant");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                loginCliente();
                break;
            case 2:
                loginRestaurante();
                break;
            case 3:
                cadastrarCliente();
                break;
            case 4:
                cadastrarRestaurante();
                break;
            case 5:
                return false;
            default:
                System.out.println("Invalid option");
        }
        return true;
    }

    private static void menuCliente() {
        if (userLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Cliente ===");
            
            if (!restaurants.isEmpty()) {
                System.out.println("1. Make Order");
            } else {
                System.out.println("(Service unavailable! We don't have any restaurants listed yet.)");
            }
            
            System.out.println("2. View My Orders");
            System.out.println("3. View Restaurants");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (!restaurants.isEmpty()) {
                        makeOrder();
                    } else {
                        System.out.println("Option currently unavailable.");
                    }
                    break;
                case 2:
                    seeMyOrders();
                    break;
                case 3:
                    seeRestaurants();
                    break;
                case 4:
                    running = false;
                    userLogged = null;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void menuRestaurant() {
        if (restaurantLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Restaurant ===");
            System.out.println("1. Register Dish");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. View Orders in Progress");
            System.out.println("5. View Late Orders");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerPlate();
                    break;
                case 2:
                    seeOrders();
                    break;
                case 3:
                    updateOrderStatus();
                    break;
                case 4:
                    seeOrdersInProgress();
                    break;
                case 5:
                    seeLateOrders();
                    break;
                case 6:
                    running = false;
                    restaurantLogged = null;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void loginClient() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                userLogged = user;
                System.out.println("Login successful!");
                menuClient();
                return;
            }
        }
        System.out.println("Incorrect email or password!");
    }

    private static void loginRestaurant() {
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Restaurants restaurant : restaurants) {
            if (restaurant.getCnpj().equals(cnpj) && restaurant.getPassword().equals(password)) {
                restaurantLogged = restaurant;
                System.out.println("Login successful!");
                menuRestaurant();
                return;
            }
        }
        System.out.println("Incorrect CNPJ or password!");
    }

    private static void registerCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Telephone: ");
        String telephone = scanner.nextLine();

        Usuario newUser = new Usuario(name, email, password, address, telephone);
        users.add(newUser);
        System.out.println("Customer successfully registered!");
    }

    private static void registerRestaurant() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Restaurants rest : restaurants) {
            if (rest.getCnpj().equals(cnpj)) {
                System.out.println("There is already a restaurant registered with this CNPJ!");
                return;
            }
        }

        if (name.isEmpty() || address.isEmpty() || telephone.isEmpty() || cnpj.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        try {
            Restaurants newRestaurant = new Restaurants(name, address, telephone, cnpj, password);
            restaurants.add(newRestaurant);
            System.out.println("Restaurant registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering restaurant: " + e.getMessage());
        }
    }

    private static void registerDish() {
        System.out.print("Dish name: ");
        String name = scanner.nextLine();
        System.out.print("Dish price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Dish description: ");
        String description = scanner.nextLine();
        System.out.print("Estimated delivery time (minutes): ");
        int estimatedDeliveryTime = scanner.nextInt();
        scanner.nextLine();

        Dishes newDish = new Dishes(name, price, description, estimatedDeliveryTime);
        restaurantLogged.registerDish(newDish);
        System.out.println("Dish registered successfully!");
    }

    private static void makeOrder() {
        if (userLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }

        if (restaurants.isEmpty()) {
            System.out.println("There are currently no restaurants registered.");
            return;
        }

        boolean thereAreDishes = false;
        for (Restaurants r : restaurants) {
            if (!r.getDishes().isEmpty()) {
                thereAreDishes = true;
                break;
            }
        }

        if (!thereAreDishes) {
            System.out.println("There are no restaurants with dishes available at the moment.");
            return;
        }

        System.out.println("=== Available Restaurants ===");
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurants restaurant = restaurants.get(i);
            System.out.println((i + 1) + ". " + restaurant.getName());
        }

        System.out.print("Choose a restaurant: ");
        int chooseRestaurant = scanner.nextInt();
        scanner.nextLine();

        if (chooseRestaurant < 1 || chooseRestaurant > restaurants.size()) {
            System.out.println("Invalid restaurant.");
            return;
        }

        Restaurants restaurantChosen = restaurants.get(chooseRestaurant - 1);

        System.out.println("=== Available Dishes ===");
        ArrayList<Dishes> dishes = restaurantChosen.getDishes();
        for (int i = 0; i < dishes.size(); i++) {
            Dishes dish = dishes.get(i);
            System.out.println((i + 1) + ". " + dishe.getName() + " - R$" + dish.getPrice());
        }

        System.out.print("Choose a dish: ");
        int chooseDish = scanner.nextInt();
        scanner.nextLine();

        if (chooseDish < 1 || chooseDish > dishes.size()) {
            System.out.println("Invalid dish.");
            return;
        }

        Dishes dishChosen = dishes.get(chooseDish - 1);
        
        Order newOrder = new Order(dishChosen, userLogged, restaurantChosen);
        userLogged.addOrder(newOrder);
        restaurantChosen.addOrder(newOrder);
        System.out.println("Request placed successfully!");
    }

    private static void seeMyOrders() {
        if (userLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }
        
        List<Order> orders = userLogged.getOrders();
        if (orders.isEmpty()) {
            System.out.println("You have no orders yet!");
            return;
        }
        
        System.out.println("\n=== Your Orders ===");
        double totalGeral = 0;
        for (Order order : orders) {
            System.out.println("\n------------------------");
            System.out.println("Restaurant: " + order.getRestaurant().getName());
            System.out.println("Dish: " + order.getDish().getName());
            System.out.println("Value: R$" + String.format("%.2f", order.getTotal()));
            System.out.println("Status: " + order.getStatus());
            System.out.println("Order Date: " + order.getOrderDate());
            totalGeral += order.getTotal();
        }
        System.out.println("\n------------------------");
        System.out.println("Total of all orders: R$" + String.format("%.2f", totalGeral));
    }

    private static void seeOrders() {
        if (restaurantLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }
        
        List<Order> orders = restaurantLogged.getOrders();
        if (orders.isEmpty()) {
            System.out.println("There are no orders for this restaurant!");
            return;
        }
        
        System.out.println("\n=== Restaurant Orders ===");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    private static void seeRestaurants() {
        System.out.println("\n=== Available Restaurants ===");
        if (restaurants.isEmpty()) {
            System.out.println("There are no registered restaurants.");
            return;
        }
        
        for (Restaurants restaurant : restaurants) {
            System.out.println("\nName: " + restaurant.getName());
            System.out.println("Address: " + restaurant.getAddress());
            System.out.println("Telephone: " + restaurant.getTelephone());
            System.out.println("--- Menu ---");
            ArrayList<Dishes> dishes = restaurant.getDishes();
            if (dishes.isEmpty()) {
                System.out.println("No dishes registered.");
            } else {
                for (Dishes dish : dishes) {
                    System.out.println(dish.getName() + " - R$" + dish.getPrice());
                }
            }
        }
    }

    private static void updateOrderStatus() {
        if (restaurantLogged == null) {
            System.out.println("You need to log in first!");
            return;
        }
        
        List<Order> orders = restaurantLogged.getOrders();
        if (orders.isEmpty()) {
            System.out.println("There are no requests to update!");
            return;
        }
        
        System.out.println("\n=== Update Order Status ===");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println((i + 1) + ". " + order.getOrder().getName() + " - Status: " + order.getStatus());
        }
        
        System.out.print("Choose order number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice < 1 || choice > orders.size()) {
            System.out.println("Invalid request!");
            return;
        }
        
        System.out.println("\nNew status:");
        System.out.println("1. In preparation");
        System.out.println("2. In Delivery");
        System.out.println("3. Delivered");
        System.out.print("Choice: ");
        
        int statusChoose = scanner.nextInt();
        scanner.nextLine();
        
        String newStatus = "Pending";
        switch (statusChoose) {
            case 1: 
                newStatus = "In Preparation"; 
                break;
            case 2: 
                newStatus = "In Delivery"; 
                systemDeliverie.addOrder(orders.get(choice - 1));
                break;
            case 3: 
                newStatus = "Delivered"; 
                systemDeliveries.markAsDelivered(orders.get(choice - 1));
                break;
            default:
                System.out.println("Invalid option!");
                return;
        }
        
        orders.get(choice - 1).setStatus(newStatus);
        System.out.println("Status updated successfully!");
    }

    private static void seeOrdersInProgress() {
        ArrayList<Order> ordersInProgress = systemDeliverie.listOrdersInProgress();
        if (ordersInProgress.isEmpty()) {
            System.out.println("There are no orders in progress!");
            return;
        }
        
        System.out.println("\n=== Orders in Progress ===");
        for (Order order : ordersInProgress) {
            System.out.println(order.toString());
        }
    }

    private static void seeLateOrders() {
        ArrayList<Order> lateOrders = systemDeliverie.listLateOrders();
        if (lateOrders.isEmpty()) {
            System.out.println("No late orders!");
            return;
        }
        
        System.out.println("\n=== Late Orders ===");
        for (Order order : lateOrders) {
            System.out.println(order.toString());
        }
    }
}
