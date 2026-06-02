/*
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable; // Ensure this import matches your project structure!
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    
    private Cart cart;
    
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    // 1. Declare button references from FXML
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnRemove;
    
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
    
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        // Hide control buttons initially until an item is selected
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        // 2. Add ChangeListener to look out for selections inside the TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
    }
    
    // 3. Helper method to adjust visibility rules dynamically
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false); // Hide "Play" if it's a Book
        }
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }
}
*/

package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList; // Required for wrapping the list
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    
	private Store store;
    private Cart cart;
    
    // Create a FilteredList wrapper that sits on top of our original cart items
    private FilteredList<Media> filteredList;
    
    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    
    // Filter Fields
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Label lblTotalCost; // Binds to fx:id="lblTotalCost"
    
    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }
    
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        // 1. Wrap the master items list in our FilteredList wrapper
        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true); // "p -> true" means show everything initially
        
        // 2. CRUCIAL HINT CHANGE: Pass the filtered list to the TableView instead of the raw cart list!
        tblMedia.setItems(filteredList);
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        // Track selection changes
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
        
        // 3. ChangeListener: Track every single keystroke in the search bar
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        
     // Recalculate cost automatically whenever the list changes (add/remove)
        this.cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> c) {
                updateTotalCost();
            }
        });

        // Run it once on startup to calculate the initial total
        updateTotalCost();
    }
    
    // 4. Extra Credit Filtering Engine
    private void showFilteredMedia(String keyword) {
        // If search box is empty, reset the filter to show all items
        if (keyword == null || keyword.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }
        
        String lowerCaseFilter = keyword.toLowerCase().trim();
        
        // Apply the evaluation logic rule
        filteredList.setPredicate(media -> {
            if (radioBtnFilterTitle.isSelected()) {
                // Return true if the title contains our typed string
                return media.getTitle() != null && media.getTitle().toLowerCase().contains(lowerCaseFilter);
            } else if (radioBtnFilterId.isSelected()) {
                // Return true if the media ID matches what we typed
                String idString = String.valueOf(media.getId());
                return idString.contains(lowerCaseFilter);
            }
            return true;
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            this.cart.removeMedia(media);
            tblMedia.getSelectionModel().clearSelection();
        }
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // 1. Double check that the cart isn't already empty
        if (this.cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty! Add some media items before placing an order.");
            alert.showAndWait();
            return;
        }

        // 2. Display the order success popup notification
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("An order has been successfully created! Thank you for your purchase.");
        alert.showAndWait();
        
        // 3. Clear the observable list inside your cart data layer
        this.cart.getItemsOrdered().clear();
        
        // 4. Clear any active row selection so the control buttons hide themselves cleanly
        tblMedia.getSelectionModel().clearSelection();
    }
    
 
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
    	if (selectedMedia != null && selectedMedia instanceof Playable) {
    		try {
            // Ép kiểu sang Playable và thực thi phát media
            ((Playable) selectedMedia).play();
            
            // Nếu không dính ngoại lệ, hiển thị thông báo phát nhạc thành công bình thường
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("AIMS Media Player");
            alert.setHeaderText("Media Streaming Started");
            alert.setContentText("Now playing: " + selectedMedia.getTitle());
            alert.showAndWait();
            
        } catch (PlayerException e) {
            // BẮT TRỌN LỖI PLAYEREXCEPTION VÀ HIỂN THỊ HỘP THOẠI ĐỎ CẢNH BÁO
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Playback System Error");
            alert.setHeaderText("PlayerException Caught at Runtime!");
            alert.setContentText(e.getMessage()); // Sẽ hiển thị chuỗi thông báo lỗi cụ thể
            alert.showAndWait();
        }
    }
}
    
    private void updateTotalCost() {
        float total = 0;
        for (Media media : this.cart.getItemsOrdered()) {
            total += media.getCost();
        }
        lblTotalCost.setText(String.format("%.2f $", total));
    }
    
    @FXML
    void menuAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuViewStorePressed(ActionEvent event) {
        new StoreScreen(this.store, this.cart);
    }

    @FXML
    void menuViewCartPressed(ActionEvent event) {
        // Already viewing the cart
    }
}