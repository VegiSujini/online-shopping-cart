import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCartService {

    private List<Product> cartItems = new CopyOnWriteArrayList<>();  // Using CopyOnWriteArrayList for thread-safe operations
    
    private void addProduct(Product product)
    {
        cartItems.add(product);
    }

    private void removeProduct(Product product){
        cartItems.remove(product);
    }

    private double calculateTotal(){
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }

    private double applyDiscount(double discount){
        return calculateTotal() * (1 - discount);
    }

    private List<Product> getCartItems(){
        return new ArrayList<>(cartItems);
    }
    
}
