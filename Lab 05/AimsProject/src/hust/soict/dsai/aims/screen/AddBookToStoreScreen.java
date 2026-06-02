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
        // Lớp Book không cần thêm thuộc tính đặc thù nào khác ngoài các thuộc tính cơ bản
    }

    @Override
    protected void handleSubmit() throws Exception {
        int id = Integer.parseInt(tfId.getText());
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        
        // Khởi tạo thực thể Book và nạp vào kho lưu trữ
        Book book = new Book(title, category, cost);
        this.store.addMedia(book);
    }
}