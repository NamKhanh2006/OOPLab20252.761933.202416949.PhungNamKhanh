package hust.soict.dsai.aims.media;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	private static int nbMediaItems = 0;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media(String title) {
		super();
		this.title = title;
		nbMediaItems++;
		this.setId(nbMediaItems);
	}
	
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		nbMediaItems++;
		this.setId(nbMediaItems);
	}
	
	public Media(String title, float cost) {
		super();
		this.title = title;
		this.cost = cost;
		nbMediaItems++;
		this.setId(nbMediaItems);
	}


	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMediaItems++;
		this.setId(nbMediaItems);
	}

	/*
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMediaItems++;
		this.setId(nbMediaItems);
	}
	*/
	
	public boolean isMatch(String targetTitle) {
		return this.getTitle().equalsIgnoreCase(targetTitle);
	}

	public Media() {
		// TODO Auto-generated constructor stub
		nbMediaItems++;
		this.setId(nbMediaItems);
	}

}
