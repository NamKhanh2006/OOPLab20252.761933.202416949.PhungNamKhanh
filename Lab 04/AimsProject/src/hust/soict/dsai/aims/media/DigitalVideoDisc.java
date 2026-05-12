package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.director = director;
		this.length = length;
	}

	@Override
	public String toString() {
		return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return getTitle() != null && getTitle().equalsIgnoreCase(title);
	}
	
}
