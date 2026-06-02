package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	
	private String title;
	private int length;
	
	
	
	public String getTitle() {
		return title;
	}



	public int getLength() {
		return length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}

	public Track(int length) {
		super();
		this.length = length;
	}



	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	/*
	public void play() {
		System.out.println("Playing Track: " + this.getTitle()); 
		System.out.println("Track length: " + this.getLength());
	}
	*/
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing Track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        System.err.println("ERROR: Track length is non-positive!");
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	    	return true;
	    
	    if (obj == null || !(obj instanceof Track)) {
	        return false;
	    }
	    
	    Track other = (Track) obj;
	    
	    boolean titleMatch = (this.getTitle() != null && this.getTitle().equalsIgnoreCase(other.getTitle()));
	    boolean lengthMatch = (this.getLength() == other.getLength());
	    
	    return titleMatch && lengthMatch;
	}

	public String toString() {
		return title + " - " + length;
	}
	
	public Track() {
		// TODO Auto-generated constructor stub
	}

}
