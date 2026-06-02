package hust.soict.dsai.aims.screen;

import javax.swing.JTextField;
import javax.swing.JLabel;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist, tfDirector;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD Configuration Form");
    }

    @Override
    protected void addCustomFields() {
        centerPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);

        centerPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);
    }

    @Override
    protected void handleSubmit() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();
        
        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        this.store.addMedia(cd);
    }
}