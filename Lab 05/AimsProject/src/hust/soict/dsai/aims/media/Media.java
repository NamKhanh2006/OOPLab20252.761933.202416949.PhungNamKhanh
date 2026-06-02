package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	private static int nbMediaItems = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
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
	
	@Override
	public boolean equals(Object obj) {
	    // 1. Kiểm tra nếu so sánh chính nó với chính nó (Cùng ô nhớ) -> Bằng nhau luôn
	    if (this == obj) {
	        return true;
	    }

	    // 2. Kiểm tra phòng thủ tránh lỗi NullPointerException và ClassCastException
	    // Nếu đối tượng truyền vào bị rỗng hoặc KHÔNG PHẢI là một thực thể thuộc kiểu Media
	    if (obj == null || !(obj instanceof Media)) {
	        return false; // Trả về false luôn chứ không ép kiểu bừa bãi gây sập app
	    }

	    // 3. Ép kiểu an toàn (Safe Casting) vì ta đã chắc chắn nó là Media nhờ bước trên
	    Media other = (Media) obj;

	    // 4. Kiểm tra thuộc tính Title để quyết định tính bằng nhau theo yêu cầu đề bài
	    if (this.title == null) {
	        return other.title == null; 
	    }
	    
	    // So sánh không phân biệt chữ hoa chữ thường bằng equalsIgnoreCase (hoặc .equals() tùy bạn)
	    return this.title.equalsIgnoreCase(other.title);
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
		nbMediaItems++;
		this.setId(nbMediaItems);
	}

}
