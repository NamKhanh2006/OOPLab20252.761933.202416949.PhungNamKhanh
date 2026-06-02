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
    
    // Thuộc tính chung cho các màn hình nhập liệu
    protected JTextField tfId, tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;
        
        this.setTitle(title);
        this.setSize(450, 500);
        // Thay đổi sang DISPOSE để khi tắt cửa sổ nhập liệu thì không bị tắt toàn app
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setLayout(new BorderLayout());
        
        // Header Banner
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel(title);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.CYAN);
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
        
        // Lưới nhập dữ liệu trung tâm (Dùng GridLayout để các ô thẳng hàng)
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Nạp các trường dữ liệu căn bản chung
        tfId = addFormField("ID Item Product:");
        tfTitle = addFormField("Media Title:");
        tfCategory = addFormField("Category:");
        tfCost = addFormField("Price Cost ($):");
        
        // Gọi hàm móc hook nạp thêm thuộc tính riêng của từng lớp con CD/DVD
        addCustomFields();
        this.add(centerPanel, BorderLayout.CENTER);
        
        // Tạo thanh Menu Options điều hướng giống StoreScreen
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> { 
            new AddBookToStoreScreen(store, cart); 
            this.dispose(); 
        });
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> { 
            new AddCompactDiscToStoreScreen(store, cart); 
            this.dispose(); 
        });
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> { 
            new AddDigitalVideoDiscToStoreScreen(store, cart); 
            this.dispose(); 
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            new StoreScreen(store, cart); 
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
        this.setJMenuBar(menuBar);
        
        // Nút lưu dữ liệu xuống cuối màn hình
        JButton btnAdd = new JButton("Add Item to Store");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btnAdd.addActionListener(e -> {
            try {
                handleSubmit();
                JOptionPane.showMessageDialog(this, "Successfully added to the inventory catalog!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Sau khi thêm thành công, quay về màn hình Store chính để cập nhật hiển thị mẫu
                new StoreScreen(store, cart);
                this.dispose(); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number inputs! Please verify ID, Cost, or Length fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Execution Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(btnAdd, BorderLayout.SOUTH);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true); // <--- Bật hiển thị cửa sổ lên màn hình
    }

    private JTextField addFormField(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField textField = new JTextField();
        centerPanel.add(label);
        centerPanel.add(textField);
        return textField;
    }

    protected abstract void addCustomFields();
    protected abstract void handleSubmit() throws Exception;
}

