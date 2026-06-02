package hust.soict.dsai.aims.screen;

import javax.swing.JTextField;
import javax.swing.JLabel;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD Configuration Form");
    }

    @Override
    protected void addCustomFields() {
        centerPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);
        
        centerPanel.add(new JLabel("Length (mins):"));
        tfLength = new JTextField();
        centerPanel.add(tfLength);
    }

    @Override
    protected void handleSubmit() throws Exception {
        int id = Integer.parseInt(tfId.getText());
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        this.store.addMedia(dvd);
    }
}