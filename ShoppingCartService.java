import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCartService {

    private List<Product> cartItems = new CopyOnWriteArrayList<>(); // Using CopyOnWriteArrayList for thread-safe
                                                                    // operations

    void addProduct(Product product) {
        cartItems.add(product);
    }

    void removeProduct(Product product) {
        cartItems.remove(product);
    }

    double calculateTotal() {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }

    double applyDiscount(double discount) throws InsufficientFundsException {
        return calculateTotal() * (1 - discount);
    }

    List<Product> getCartItems() {
        return new ArrayList<>(cartItems);
    }

}
