import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OnlineShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            shoppingCartService.addProduct(new Product("Laptop", 50000));
            shoppingCartService.addProduct(new Product("SmartPhone", 25000));
            shoppingCartService.addProduct(new Product("Camera", 250000));
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                shoppingCartService.removeProduct(new Product("Laptop", 50000));
                System.out.println("PRoducts after removing one Product : ");
                shoppingCartService.getCartItems().forEach(cartItems -> System.out.println(cartItems.getName()));
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        });

        executorService.submit(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Total price : $ " + shoppingCartService.calculateTotal());
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Total Price after 10% discount : $" + shoppingCartService.applyDiscount(0.10));
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            } catch (InsufficientFundsException insufficientFundsException) {
                System.out.println(insufficientFundsException.getMessage());
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                shoppingCartService.getCartItems().forEach(cartItems -> System.out.println(cartItems.getName()));
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        });

        executorService.shutdown();

    }
}
