package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book Configuration Form");
    }

    @Override
    protected void addCustomFields() {
        // No extra custom properties required outside base variables
    }

    @Override
    protected void handleSubmit() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        
        Book book = new Book(title, category, cost);
        this.store.addMedia(book);
    }
}