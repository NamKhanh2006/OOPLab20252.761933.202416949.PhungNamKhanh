package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalCost;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
    
    public void addMedia(Media newMedia) {
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
    
    public void searchByID(int targetID) {
    	for (Media m : itemsOrdered) {
    		if (m.getId() == targetID) {
    			System.out.println("Media item Found:");
    			System.out.println(m.toString());
    			return;
    		}
    	}
    	System.out.println("No media item with ID " + targetID + " found!");
    }
    
    public void searchByTitle(String targetTitle) {
    	for (Media m : itemsOrdered) {
    		if (m.isMatch(targetTitle)) {
    			System.out.println("Media item Found:");
    			System.out.println(m.toString());
    			return;
    		}
    	}
    	System.out.println("No media item with title \"" + targetTitle + "\" found!");
    }
    
}