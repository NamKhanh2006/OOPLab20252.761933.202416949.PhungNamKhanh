package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JPanel centerPanel;
    
    // Shared text fields across all media types
    protected JTextField tfId, tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;
        
        this.setTitle(title);
        this.setSize(450, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes just this popup, not the whole app
        this.setLayout(new BorderLayout());
        
        // Header Banner
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel(title);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.CYAN);
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
        
        // Dynamic Form Layout Grid
        centerPanel = new JPanel(new GridLayout(0, 2, 10, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Add Base Common Fields
        tfId = addFormField("ID:");
        tfTitle = addFormField("Title:");
        tfCategory = addFormField("Category:");
        tfCost = addFormField("Cost ($):");
        
        // Let subclasses append their custom fields
        addCustomFields();
        
        this.add(centerPanel, BorderLayout.CENTER);
        
        // Bottom Action Button
        JButton btnAdd = new JButton("Add Item to Store");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btnAdd.addActionListener(e -> {
            try {
                handleSubmit();
                JOptionPane.showMessageDialog(this, "Successfully added to the inventory catalog!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Close window on success
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number inputs! Please verify ID, Cost, or Length fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Execution Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(btnAdd, BorderLayout.SOUTH);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
     // Tạo MenuBar giống hệt StoreScreen cho màn hình Add Item
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> { new AddBookToStoreScreen(store, cart); this.dispose(); });
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> { new AddCompactDiscToStoreScreen(store, cart); this.dispose(); });
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store, cart); this.dispose(); });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            new StoreScreen(store, cart); // Quay lại màn hình Store chính
            this.dispose();
        });
        menu.add(viewStoreItem);

        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            new CartScreen(store, cart);
            this.dispose();
        });
        menu.add(viewCartItem);

        menuBar.add(menu);
        this.setJMenuBar(menuBar); // Gắn menu vào JFrame hiện tại
    }

    private JTextField addFormField(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField textField = new JTextField();
        centerPanel.add(label);
        centerPanel.add(textField);
        return textField;
    }

    // Hook for unique subclass properties
    protected abstract void addCustomFields();

    // Verification extraction execution block
    protected abstract void handleSubmit() throws Exception;
}