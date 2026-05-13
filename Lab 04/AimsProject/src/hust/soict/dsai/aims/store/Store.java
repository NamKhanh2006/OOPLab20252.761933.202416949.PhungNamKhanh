package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Store {
	public static final int MAX_CAPACITY = 1000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media newMedia) {
		if (itemsInStore.size() < MAX_CAPACITY) {
			if (itemsInStore.contains(newMedia)) {
				System.out.println("The media item '" + newMedia.getTitle() + "' was already in the store!");
			}
			else {
				itemsInStore.add(newMedia);
				System.out.println("The media item '" + newMedia.getTitle() + "' has been successfully added to the store!");
				if (itemsInStore.size() == MAX_CAPACITY) {
					System.out.println("The store is now full!");
				}
			}
		}
		else {
			System.out.println("Could not add the media item '" + newMedia.getTitle() + "' to the store because the store was full!");
		}
	}
	
	public void removeMedia(Media targetMedia) {
		if (itemsInStore.size() > 0) {
			if (!itemsInStore.contains(targetMedia)) {
				System.out.println("Could not find the media item '" + targetMedia.getTitle() + "' in the store!");
			}
			else {
				itemsInStore.remove(targetMedia);
				System.out.println("The media item '" + targetMedia.getTitle() + "' has been successfully removed from the store!");
				if (itemsInStore.size() == 0)
					System.out.println("The store is now empty.");
			}
		}
		else {
			System.out.println("The store is empty!");
		}
	}
	
}
