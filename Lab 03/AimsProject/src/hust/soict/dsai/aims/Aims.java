package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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
