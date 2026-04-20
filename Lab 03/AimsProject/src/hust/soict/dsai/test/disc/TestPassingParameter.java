package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		// Code to test the id attribute
		System.out.println("jungle dvd id: " + jungleDVD.getid());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		// Code to test the id attribute
		System.out.println("cinderella dvd id: " + cinderellaDVD.getid());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	/*public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String title1 = dvd1.getTitle();
		String category1 = dvd1.getCategory();
		String director1 = dvd1.getDirector();
		int length1 = dvd1.getLength();
		float cost1 = dvd1.getCost();
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setCost(dvd2.getCost());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setTitle(dvd2.getTitle());
		
		dvd2.setCategory(category1);
		dvd2.setCost(cost1);
		dvd2.setDirector(director1);
		dvd2.setLength(length1);
		dvd2.setTitle(title1);
	}*/
}
