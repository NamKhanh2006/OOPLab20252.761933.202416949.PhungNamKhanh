package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    private int totalCost;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is now full.");
            }
        } else {
            System.out.println("The cart is already full. Cannot add: " + disc.getTitle());
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }
    
    /*public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }*/
    
    // 2.2. Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); 
        addDigitalVideoDisc(dvd2);
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered == 0) {
    		System.out.println("The cart is empty.");
    		return;
    	}
        int indexToRemove = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle()) && 
            	itemsOrdered[i].getCategory().equals(disc.getCategory()) &&
            	itemsOrdered[i].getDirector().equals(disc.getDirector()) &&
            	itemsOrdered[i].getLength() == disc.getLength() &&
            	itemsOrdered[i].getCost() == disc.getCost() ) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            qtyOrdered--;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    public void print() {
    	totalCost = 0;
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		System.out.println(itemsOrdered[i].toString());
    		totalCost += itemsOrdered[i].getCost();
    	}
    	System.out.println("Total Cost: " + totalCost);
    	System.out.println("***************************************************");
    }
    
    public void searchByID(int targetID) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].getid() == targetID) {
    			System.out.println("DVD Found:");
    			System.out.println(itemsOrdered[i].toString());
    			return;
    		}
    	}
    	System.out.println("No DVD with ID " + targetID + " found!");
    }
    
    public void searchByTitle(String targetTitle) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].isMatch(targetTitle)) {
    			System.out.println("DVD Found:");
    			System.out.println(itemsOrdered[i].toString());
    			return;
    		}
    	}
    	System.out.println("No DVD with title \"" + targetTitle + "\" found!");
    }
    
}