package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}



	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName))
			authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName))
			authors.remove(authorName);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Book(String title, float cost) {
		super(title, cost);
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return getId() + ". Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors.toString();
	}

}
