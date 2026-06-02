package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				 "Animation", "Roger Allers", 87, 19.95f);
		try{
			cart.addMedia(dvd1);
		}
		catch (LimitExceededException e) {
			System.err.println("[Cart Error] " + e.getMessage());
			// Hiển thị dialog cảnh báo trực quan cho người dùng console luôn
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Cart Limit Exceeded", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				 "Science Fiction", "George Lucas", 87, 24.95f);
		try{
			cart.addMedia(dvd2);
		}
		catch (LimitExceededException e) {
			System.err.println("[Cart Error] " + e.getMessage());
        	// Hiển thị dialog cảnh báo trực quan cho người dùng console luôn
        	javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Cart Limit Exceeded", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				 "Animation", 18.99f);
		try{
			cart.addMedia(dvd3);
		}
		catch (LimitExceededException e) {
			System.err.println("[Cart Error] " + e.getMessage());
			// Hiển thị dialog cảnh báo trực quan cho người dùng console luôn
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Cart Limit Exceeded", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		// Test the print method
		cart.print();
		
		// Test the search methods
		cart.searchByID(1);
		cart.searchByID(10);
		cart.searchByTitle("Star Wars");
		cart.searchByTitle("Titanic");
		

	}

}
