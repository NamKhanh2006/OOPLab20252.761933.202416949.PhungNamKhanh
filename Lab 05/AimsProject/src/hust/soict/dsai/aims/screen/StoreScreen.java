package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(this.store, this.cart);
			this.dispose();
		});
		
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCompactDiscToStoreScreen(this.store, this.cart);
			this.dispose();
		});
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDigitalVideoDiscToStoreScreen(this.store, this.cart);
			this.dispose();
		});
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(e -> {
			new CartScreen(this.store, this.cart);
			this.dispose();
		});
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(e -> {
			new CartScreen(this.store, this.cart);
			this.dispose();
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension (10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		int limit = Math.min(mediaInStore.size(), 9);
		
		for (int i = 0; i < limit; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), this.cart);
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store, Cart cart) {
		// SỬA LỖI TẠI ĐÂY: Gán trực tiếp giá trị tham chiếu được truyền vào
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}