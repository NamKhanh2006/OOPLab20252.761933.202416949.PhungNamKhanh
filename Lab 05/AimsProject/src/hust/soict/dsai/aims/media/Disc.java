package hust.soict.dsai.aims.media;

public class Disc extends Media{
	
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}
	
	public Disc(int length) {
		super();
		this.length = length;
	}

	public Disc(String director) {
		super();
		this.director = director;
	}


	public Disc(int length, String director) {
		super();
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}

}
