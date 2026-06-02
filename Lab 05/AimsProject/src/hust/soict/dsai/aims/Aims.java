/*
package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				 "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				 "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				 "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//print total cost of the items in the cart
		System.out.println("Total Cost Is: ");
		System.out.println(anOrder.totalCost());
		
		// test the removeDigitalVideoDisc(DigitalVideoDisc disc) method
		System.out.println("Would you like to remove a disc?");
		System.out.println("Please type 0 or 1 below (0 - No, 1 - Yes):");
		Scanner reader = new Scanner(System.in);
		int choice = reader.nextInt();
		reader.nextLine();
		
		if (choice == 1) {
			String targetDiscTitle;
			String targetDiscCategory;
			String targetDiscDirector;
			int targetDiscLength;
			float targetDiscCost;
			
			System.out.println("Disc title:");
			targetDiscTitle = reader.nextLine();
			
			System.out.println("Disc Category:");
			targetDiscCategory = reader.nextLine();
			
			System.out.println("Disc Director:");
			targetDiscDirector = reader.nextLine();
			
			System.out.println("Disc Length:");
			targetDiscLength = reader.nextInt();
			reader.nextLine();
			
			System.out.println("Disc cost:");
			targetDiscCost = reader.nextFloat();
			reader.nextLine();
			
			DigitalVideoDisc targetDisc = new DigitalVideoDisc(targetDiscTitle,
					targetDiscCategory,
				    targetDiscDirector,
					targetDiscLength,
					targetDiscCost);
			
			anOrder.removeDigitalVideoDisc(targetDisc);
			
		}
		
		reader.close();
	}

}
*/

/*
package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.*;

public class Aims {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        List<Media> mediae = new ArrayList<Media>();

        // 1. Create a DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        // 2. Create a CD and add some tracks
        CompactDisc cd = new CompactDisc(120, "Various Artists");
        cd.setTitle("Greatest Hits");
        cd.addTrack(new Track("Song A", 3));
        cd.addTrack(new Track("Song B", 4));

        // 3. Create a Book
        Book book = new Book("Java Programming", "Education", 29.99f);
        book.addAuthor("James Gosling");

        // Add them to the list
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Iterate through the list
        for (Media m : mediae) {
            // Polymorphism happens here
            System.out.println(m.toString());
        }
    }
*/  
   
/*
package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
    	Store store = new Store();
    	Cart cart = new Cart();
    	int choice;
    	Scanner reader = new Scanner(System.in);
    	while (true) {
    		showMenu();
    		choice = reader.nextInt();
    		if (choice == 1) {
    			// View store
    			store.print();
    			storeMenu();
    			int viewStoreChoice;
    			viewStoreChoice = reader.nextInt();
    			while (true) {
    				if (viewStoreChoice == 1) {
    					// View store -> See media details
    					seeMediaDetails(store, cart);
    					break;
    				}
    				else if (viewStoreChoice == 2) {
    					// View store -> Add media to cart
    					addMediaToCart(store, cart);
    				}
    				else if (viewStoreChoice == 3) {
    					// View store -> Play a media
    					playAMedia(store, cart);
    				}
    				else if (viewStoreChoice == 4) {
    					// View store -> View current cart
    					cart.print();
    				}
    				else if (viewStoreChoice == 0)
    					// View store -> Back
    					break;
    			}
    			// Back
    			if (viewStoreChoice == 0)
    				continue;
    		}
    		else if (choice == 2) {
    			// TODO: Update store
    			System.out.println("Options: "); 
    	    	System.out.println("--------------------------------");
    	    	System.out.println("1. Add a media to store");
    	    	System.out.println("2. Remove a media from store");
    	    	System.out.println("0. Back");
    	    	System.out.println("--------------------------------"); 
    	    	System.out.println("Please choose a number: 0-1-2");
    			int updateStoreChoice;
    			while (true) {
    				updateStoreChoice = reader.nextInt();
    				if (updateStoreChoice == 1) {
    					
    				}
    			}
    		}
    		else if (choice == 3) {
    			// TODO: See current cart
    		}
    		else if (choice == 0) {
    			break;
    		}
    		//else
    	}
    	
    	reader.close();
    }
    
    
    public static void showMenu() { 
    	System.out.println("AIMS: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. View store"); 
    	System.out.println("2. Update store"); 
    	System.out.println("3. See current cart"); 
    	System.out.println("0. Exit"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2-3"); 
    }
    
    
    // If the user chooses option "View store"
    public static void storeMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. See a media’s details"); 
    	System.out.println("2. Add a media to cart"); 
    	System.out.println("3. Play a media"); 
    	System.out.println("4. See current cart"); 
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2-3-4"); 
    } 
    
    public static void mediaDetailsMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. Add to cart"); 
    	System.out.println("2. Play"); 
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2"); 
    	}
    
    
    
    public static void seeMediaDetails(Store store, Cart cart) {
    	String targetMediaTitle = new String();
    	System.out.println("Please enter the media title: ");
    	Scanner reader = new Scanner(System.in);
    	Media targetMedia;
    	while (true) {
    		targetMediaTitle = reader.nextLine();
    		targetMedia = store.searchByTitle(targetMediaTitle); 
    		if (targetMedia == null)
    			System.out.println("No results found. Please try again.");
    		else
    			break;
    	}
    	System.out.println(targetMedia.toString());
    	mediaDetailsMenu();
    	int mediaDetailsMenuChoice;
    	mediaDetailsMenuChoice = reader.nextInt();
    	while (true) {
    		if (mediaDetailsMenuChoice == 1) {
    			cart.addMedia(targetMedia);
    			break;
    		}
    		else if (mediaDetailsMenuChoice == 2) {
    			playMedia(targetMedia);
    			break;
    		}
    		else if (mediaDetailsMenuChoice == 0) {
    			reader.close();
    			return;
    		}
    		else {
    			System.out.println("Invalid option. Please choose again.");
    		}
    	}
    	reader.close();
    }
    
    public static void playMedia(Media m) {
    	if (m instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) m;
			cd.play();
		}
		else if (m instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) m;
			dvd.play();
		}
		else {
			System.out.println("The media'" + m.getTitle() + "'cannot be played.");
		}
    }
    
    public static void addMediaToCart(Store store, Cart cart) {
    	String targetMediaTitle = new String();
    	System.out.println("Please enter the media title: ");
    	Scanner reader = new Scanner(System.in);
    	Media targetMedia;
    	while (true) {
    		targetMediaTitle = reader.nextLine();
    		targetMedia = store.searchByTitle(targetMediaTitle); 
    		if (targetMedia == null)
    			System.out.println("No results found. Please try again.");
    		else
    			break;
    	}
    	cart.addMedia(targetMedia);
    	System.out.println("The cart now has " + cart.count() + "media items.");
    	reader.close();
    }
    
    public static void playAMedia(Store store, Cart cart) {
    	String targetMediaTitle = new String();
    	System.out.println("Please enter the media title: ");
    	Scanner reader = new Scanner(System.in);
    	Media targetMedia;
    	while (true) {
    		targetMediaTitle = reader.nextLine();
    		targetMedia = store.searchByTitle(targetMediaTitle); 
    		if (targetMedia == null)
    			System.out.println("No results found. Please try again.");
    		else
    			break;
    	}
    	playMedia(targetMedia);
    	reader.close();
    }
    
}
*/

package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
    	Store store = new Store();
    	Cart cart = new Cart();
    	int choice;
    	Scanner reader = new Scanner(System.in);
    	
    	// Seed some mock data into the store for testing purposes
    	DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    	Book book = new Book("Java Programming", "Education", 29.99f);
    	book.addAuthor("James Gosling");
    	CompactDisc cd = new CompactDisc(120, "Various Artists");
    	cd.setTitle("Greatest Hits");
    	cd.addTrack(new Track("Song A", 3));
    	store.addMedia(dvd);
    	store.addMedia(book);
    	store.addMedia(cd);

    	while (true) {
    		showMenu();
    		choice = reader.nextInt();
    		reader.nextLine(); // Clear newline buffer
    		
    		if (choice == 1) {
    			// View store
    			while (true) {
        			store.print();
        			storeMenu();
        			int viewStoreChoice = reader.nextInt();
        			reader.nextLine(); // Clear buffer
        			
    				if (viewStoreChoice == 1) {
    					// View store -> See media details
    					seeMediaDetails(store, cart, reader);
    				}
    				else if (viewStoreChoice == 2) {
    					// View store -> Add media to cart
    					addMediaToCart(store, cart, reader);
    				}
    				else if (viewStoreChoice == 3) {
    					// View store -> Play a media
    					playAMedia(store, reader);
    				}
    				else if (viewStoreChoice == 4) {
    					// View store -> View current cart
    					cart.print();
    				}
    				else if (viewStoreChoice == 0) {
    					// View store -> Back
    					break;
    				}
    			}
    		}
    		else if (choice == 2) {
    			// TODO: Update store
    			while (true) {
        			System.out.println("Options: "); 
        	    	System.out.println("--------------------------------");
        	    	System.out.println("1. Add a media to store");
        	    	System.out.println("2. Remove a media from store");
        	    	System.out.println("0. Back");
        	    	System.out.println("--------------------------------"); 
        	    	System.out.println("Please choose a number: 0-1-2");
        	    	
        			int updateStoreChoice = reader.nextInt();
        			reader.nextLine(); // Clear buffer
        			
        			if (updateStoreChoice == 1) {
        				System.out.println("Enter 1 for DVD, 2 for CD, 3 for Book: ");
        				int type = reader.nextInt();
        				reader.nextLine();
        				if (type < 1 || type > 3) {
        					System.out.println("Invalid type choice.");
        					break;
        				}
        				
        				System.out.println("Enter title: ");
        				String title = reader.nextLine();
        				System.out.println("Enter category: ");
        				String cat = reader.nextLine();
        				System.out.println("Enter cost: ");
        				float cost = reader.nextFloat();
        				reader.nextLine();
        				
        				if (type == 1) {
        					store.addMedia(new DigitalVideoDisc(title, cat, cost));
        				} else if (type == 2) {
        					CompactDisc newCd = new CompactDisc();
        					newCd.setTitle(title);
        					newCd.setCategory(cat);
        					newCd.setCost(cost);
        					store.addMedia(newCd);
        				} else {
        					store.addMedia(new Book(title, cat, cost));
        				}
        			}
        			else if (updateStoreChoice == 2) {
        				System.out.println("Enter the title of the media to remove from store: ");
        				String title = reader.nextLine();
        				Media m = store.searchByTitle(title);
        				if (m != null) {
        					store.removeMedia(m);
        				} else {
        					System.out.println("Media not found!");
        				}
        			}
        			else if (updateStoreChoice == 0) {
        				break;
        			}
    			}
    		}
    		else if (choice == 3) {
    			// TODO: See current cart
    			while (true) {
    				cart.print();
    				cartMenu();
    				int cartChoice = reader.nextInt();
    				reader.nextLine(); // Clear buffer
    				
    				if (cartChoice == 1) {
    					System.out.println("Filter options: 1. By ID, 2. By Title (Other values) Back");
    					int filterType = reader.nextInt();
    					reader.nextLine();
    					if (filterType < 0 || filterType > 2) {
    						break;
    					}
    					if (filterType == 1) {
    						System.out.println("Enter ID: ");
    						int id = reader.nextInt(); reader.nextLine();
    						cart.filterById(id);
    					} else {
    						System.out.println("Enter Title: ");
    						String title = reader.nextLine();
    						cart.filterByTitle(title);
    					}
    				}
    				else if (cartChoice == 2) {
    					System.out.println("Sort options: 1. By Title, 2. By Cost");
    					int sortType = reader.nextInt(); reader.nextLine();
    					if (sortType == 1) cart.sortByTitle();
    					else cart.sortByCost();
    				}
    				else if (cartChoice == 3) {
    					System.out.println("Enter title to remove from cart: ");
    					String title = reader.nextLine();
    					Media m = cart.searchByTitle(title);
    					if (m != null) cart.removeMedia(m);
    					else System.out.println("Not found in cart!");
    				}
    				else if (cartChoice == 4) {
    					System.out.println("Enter title to play: ");
    					String title = reader.nextLine();
    					Media m = cart.searchByTitle(title);
    					if (m != null) playMedia(m);
    					else System.out.println("Not found in cart!");
    				}
    				else if (cartChoice == 5) {
    					System.out.println("An order has been successfully created!");
    					cart.clear(); // Empty the current cart
    				}
    				else if (cartChoice == 0) {
    					break;
    				}
    			}
    		}
    		else if (choice == 0) {
    			break;
    		}
    	}
    	
    	reader.close();
    }
    
    
    public static void showMenu() { 
    	System.out.println("AIMS: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. View store"); 
    	System.out.println("2. Update store"); 
    	System.out.println("3. See current cart"); 
    	System.out.println("0. Exit"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2-3"); 
    }
    
    
    // If the user chooses option "View store"
    public static void storeMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. See a media’s details"); 
    	System.out.println("2. Add a media to cart"); 
    	System.out.println("3. Play a media"); 
    	System.out.println("4. See current cart"); 
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2-3-4"); 
    } 
    
    public static void mediaDetailsMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. Add to cart"); 
    	System.out.println("2. Play"); 
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2"); 
    }
    
    public static void cartMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. Filter medias in cart"); 
    	System.out.println("2. Sort medias in cart"); 
    	System.out.println("3. Remove media from cart"); 
    	System.out.println("4. Play a media"); 
    	System.out.println("5. Place order"); 
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2-3-4-5"); 
    } 
    
    public static void seeMediaDetails(Store store, Cart cart, Scanner reader) {
    	String targetMediaTitle;
    	System.out.println("Please enter the media title: ");
    	Media targetMedia;
    	while (true) {
    		targetMediaTitle = reader.nextLine();
    		targetMedia = store.searchByTitle(targetMediaTitle); 
    		if (targetMedia == null)
    			System.out.println("No results found. Please try again.");
    		else
    			break;
    	}
    	System.out.println(targetMedia.toString());
    	
    	while (true) {
        	mediaDetailsMenu();
        	int mediaDetailsMenuChoice = reader.nextInt();
        	reader.nextLine(); // Clear buffer
        	
    		if (mediaDetailsMenuChoice == 1) {
    			try {
    				cart.addMedia(targetMedia);
    			} catch (hust.soict.dsai.aims.exception.LimitExceededException e) {
    				System.err.println("[Cart Error] " + e.getMessage());
    	            // Hiển thị dialog cảnh báo trực quan cho người dùng console luôn
    	            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Cart Limit Exceeded", javax.swing.JOptionPane.ERROR_MESSAGE);
    			}
    			if (targetMedia instanceof DigitalVideoDisc) {
    				System.out.println("Number of DVDs in cart: " + cart.countDVD());
    			}
    			break;
    		}
    		else if (mediaDetailsMenuChoice == 2) {
    			playMedia(targetMedia);
    			break;
    		}
    		else if (mediaDetailsMenuChoice == 0) {
    			return;
    		}
    		else {
    			System.out.println("Invalid option. Please choose again.");
    		}
    	}
    }
    
    public static void playMedia(Media m) {
        // Bọc toàn bộ logic kiểm tra và phát Media vào khối try-catch để bắt PlayerException
        try {
            if (m instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) m;
                cd.play();
            }
            else if (m instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) m;
                dvd.play();
            }
            else {
                System.out.println("The media '" + m.getTitle() + "' cannot be played.");
            }
        } catch (hust.soict.dsai.aims.exception.PlayerException e) {
            // 1. In toàn bộ 3 thông tin ngoại lệ ra Console theo đúng yêu cầu mục 14
            System.err.println("\n[Console] Exception Message: " + e.getMessage());
            System.err.println("[Console] Exception toString(): " + e.toString());
            System.err.println("[Console] Print Stack Trace:");
            e.printStackTrace(); // In vết lỗi stack trace hệ thống
            
            // 2. Hiển thị hộp thoại Swing Dialog Pop-up giống hệt mẫu Hình 49 của thầy cô
            javax.swing.JOptionPane.showMessageDialog(
                null, 
                e.getMessage(),               // Nội dung thông báo (Ví dụ: ERROR: DVD length is non-positive!)
                "Illegal Property Value",     // Tiêu đề của hộp thoại (Khớp với hình mẫu)
                javax.swing.JOptionPane.ERROR_MESSAGE // Icon dấu X đỏ cảnh báo nguy hiểm
            );
        }
    }
    
    public static void addMediaToCart(Store store, Cart cart, Scanner reader) {
        String targetMediaTitle;
        System.out.println("Please enter the media title: ");
        Media targetMedia;
        while (true) {
            targetMediaTitle = reader.nextLine();
            targetMedia = store.searchByTitle(targetMediaTitle); 
            if (targetMedia == null)
                System.out.println("No results found. Please try again.");
            else
                break;
        }
        // SỬA TẠI ĐÂY: Bọc try-catch khi addMedia vào giỏ hàng
        try {
            cart.addMedia(targetMedia);
            if (targetMedia instanceof DigitalVideoDisc) {
                System.out.println("Number of DVDs in current cart: " + cart.countDVD());
            }
        } catch (hust.soict.dsai.aims.exception.LimitExceededException e) {
            System.err.println("[Cart Error] " + e.getMessage());
            // Hiển thị dialog cảnh báo trực quan cho người dùng console luôn
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Cart Limit Exceeded", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void playAMedia(Store store, Scanner reader) {
    	String targetMediaTitle;
    	System.out.println("Please enter the media title: ");
    	Media targetMedia;
    	while (true) {
    		targetMediaTitle = reader.nextLine();
    		targetMedia = store.searchByTitle(targetMediaTitle); 
    		if (targetMedia == null)
    			System.out.println("No results found. Please try again.");
    		else
    			break;
    	}
    	playMedia(targetMedia);
    }
    
    
}