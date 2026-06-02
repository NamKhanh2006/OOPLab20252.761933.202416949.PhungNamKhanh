package hust.soict.dsai.aims.cart;

import java.util.Collections;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalCost;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); 
    
    // Method to sort by Title then Cost
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title.");
    }

    // Method to sort by Cost then Title
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost.");
    }
    
    public void addMedia(Media newMedia) throws LimitExceededException {
    	if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The cart is full! Cannot add: " + newMedia.getTitle());
        }
    	
    	if (itemsOrdered.contains(newMedia)) {
    		System.out.println("The media item '" + newMedia.getTitle() + "' is already in the cart!");
    	}
    	else {
    		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
    			itemsOrdered.add(newMedia);
    			System.out.println("The media item '" + newMedia.getTitle() + "' has been successfully added to the cart!");
    			if (itemsOrdered.size() == MAX_NUMBERS_ORDERED)
    				System.out.println("The cart is now full.");
    		}
    		else {
    			System.out.println("Could not add the media item '" + newMedia.getTitle() + "' to the cart because the cart was full.");
    		}
    	}
    }
    
    public void removeMedia(Media targetMedia) {
    	if (itemsOrdered.size() > 0) {
    		if (!itemsOrdered.contains(targetMedia)) {
    			System.out.println("The media item '" + targetMedia.getTitle() + "' was not found in the cart!");
    		}
    		else {
    			itemsOrdered.remove(targetMedia);
    			System.out.println("The media item '" + targetMedia.getTitle() + "' has been successfully removed from the cart!");
    			if (itemsOrdered.size() == 0)
    				System.out.println("The cart is now empty.");
    		}
    	}
    	else {
    		System.out.println("The cart is empty!");
    	}
    }
    
    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }
    
    public void print() {
    	totalCost = 0;
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (Media m : itemsOrdered) {
    		System.out.println(m.toString());
    		totalCost += m.getCost();
    	}
    	System.out.println("Total Cost: " + totalCost);
    	System.out.println("***************************************************");
    }
    
    public Media searchByID(int targetID) {
    	for (Media m : itemsOrdered) {
    		if (m.getId() == targetID) {
    			//System.out.println("Media item Found:");
    			//System.out.println(m.toString());
    			return m;
    		}
    	}
    	//System.out.println("No media item with ID " + targetID + " found!");
    	return null;
    }
    
    public Media searchByTitle(String targetTitle) {
    	for (Media m : itemsOrdered) {
    		if (m.isMatch(targetTitle)) {
    			//System.out.println("Media item Found:");
    			//System.out.println(m.toString());
    			return m;
    		}
    	}
    	//System.out.println("No media item with title \"" + targetTitle + "\" found!");
    	return null;
    }
    
    public int count() {
    	return itemsOrdered.size();
    }
    
    public int countDVD() {
    	int result = 0;
    	for (Media m : itemsOrdered) {
    		if (m instanceof DigitalVideoDisc)
    			result++;
    	}
    	return result;
    }
    
    /*
    public Media searchByTitle(String targetTitle) {
    	for (Media m : itemsOrdered) {
    		if (m.getTitle().equalsIgnoreCase(targetTitle))
    			return m;
    	}
    	return null;
    }*/
    
    public void clear() {
    	totalCost = 0.0f;
    	itemsOrdered.clear();
    }
    
    public void filterById(int id) {
        System.out.println("--- Filtering Cart Items by ID: " + id + " ---");
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching items found with ID: " + id);
        }
        System.out.println("----------------------------------------");
    }
    
    public void filterByTitle(String title) {
        System.out.println("--- Filtering Cart Items by Title: \"" + title + "\" ---");
        boolean found = false;
        String searchTitle = title.trim().toLowerCase();
        
        for (Media m : itemsOrdered) {
            // Checks if the item's title contains the search keyword sequence
            if (m.getTitle() != null && m.getTitle().toLowerCase().contains(searchTitle)) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching items found with title keyword: " + title);
        }
        System.out.println("-------------------------------------------");
    }

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	
    
}