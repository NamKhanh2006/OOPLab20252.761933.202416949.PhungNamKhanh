package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_CAPACITY = 1000;
	private int qtyInStore = 0;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_CAPACITY];
	
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < MAX_CAPACITY) {
			itemsInStore[qtyInStore] = dvd;
			qtyInStore++;
			System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the store.");
			if (qtyInStore == MAX_CAPACITY)
				System.out.println("The store is now full.");
		}
		else {
			System.out.println("The store is already full. Cannot add \"" + dvd.getTitle() + "\".");
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		if (qtyInStore == 0) {
			System.out.println("The store is empty.");
			return;
		}
		int indexToRemove = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getid() == dvd.getid()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            qtyInStore--;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The disc \"" + dvd.getTitle() + "\" was not found in the store.");
        }
	}
	
}
