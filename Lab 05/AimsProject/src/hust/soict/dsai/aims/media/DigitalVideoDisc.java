package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	//private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	
	@Override
	public String getDirector() {
		return director;
	}
	
	@Override
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
		//nbDigitalVideoDiscs++;
		//this.setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		//nbDigitalVideoDiscs++;
		//this.setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		//nbDigitalVideoDiscs++;
		//this.setId(nbDigitalVideoDiscs);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		//nbDigitalVideoDiscs++;
		//this.setId(nbDigitalVideoDiscs);
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
	
	@Override
	/*
	public void play() { 
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}*/
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        // Logic phát DVD cũ của bạn (In ra Console hoặc gọi cửa sổ)
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        // Sử dụng System.err.println() theo đúng yêu cầu đề bài
	        System.err.println("ERROR: DVD length is non-positive!");
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}
	
}
