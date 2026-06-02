package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(int length, String artist) {
		super(length);
		this.artist = artist;
	}

	public CompactDisc(int length, ArrayList<Track> tracks) {
		super(length);
		this.tracks = tracks;
	}

	public CompactDisc(int length, String artist, ArrayList<Track> tracks) {
		super(length);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("The track '" + newTrack.getTitle() + "'is already in the list of tracks!");
		}
		else {
			tracks.add(newTrack);
			System.out.println("The track " + newTrack.getTitle() + "has been successfully added to the list of tracks.");
		}
	}
	
	public void removeTrack(Track targetTrack) {
		if (!tracks.contains(targetTrack)) {
			System.out.println("The track '" + targetTrack.getTitle() + "' was not found.");
		}
		else {
			tracks.remove(targetTrack);
			System.out.println("The track '" + targetTrack.getTitle() + "' has been successfully removed!");
		}
	}
	
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track t : tracks)
			totalLength += t.getLength();
		return totalLength;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(getId()).append(". CD - ")
	      .append(getTitle()).append(" - ")
	      .append(getCategory()).append(" - ")
	      .append(getArtist()).append(" - ")
	      .append(getDirector()).append(" - ")
	      .append(getLength()).append(" mins: ")
	      .append(getCost()).append(" $\n");
	    
	    sb.append("   Tracks:\n");
	    for (Track t : tracks) {
	        sb.append("   - ").append(t.toString()).append("\n");
	    }
	    
	    return sb.toString();
	}
	
	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.getArtist());
		for (Track t : tracks)
			t.play();
	}
	
}
