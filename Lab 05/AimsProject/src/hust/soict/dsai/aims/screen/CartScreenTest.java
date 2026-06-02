package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;

public class CartScreenTest {
    public static void main(String[] args) {
        // 1. Create a new cart instance
        Cart cart = new Cart();

        // 2. Add some sample media items to populate the table columns
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Action", "Lana Wachowski", 136, 24.95f);
        Book book = new Book("The Three-Body Problem", "Sci-Fi", 15.99f);
        CompactDisc cd = new CompactDisc("Discovery", "Electronic", "Daft Punk", 18.50f);
        
        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        // 3. Initialize and display the Cart UI window
        // This launches the Swing JFrame container which integrates our modern JavaFX fxml panel!
        new CartScreen(cart);
    }
}