package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;

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
	
	/*
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.getArtist());
		for (Track t : tracks)
			t.play();
	}
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing CD: " + this.getTitle());
	        // Lặp qua từng track để chạy
	        for (Track track : tracks) {
	            track.play();
	        }
	    } else {
	        System.err.println("ERROR: CD length is non-positive!");
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}*/
	    @Override
	    public void play() throws PlayerException {
	        // 1. Kiểm tra thời lượng tổng của đĩa CD
	        if (this.getLength() > 0) {
	            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
	            System.out.println("Total Tracks: " + tracks.size() + " | Total length: " + this.getLength() + " mins.");
	            
	            // 2. Dùng Iterator để duyệt qua từng Track nhạc bên trong CD theo đúng mẫu đề bài
	            Iterator<Track> iter = tracks.iterator();
	            while (iter.hasNext()) {
	                Track nextTrack = iter.next();
	                try {
	                    // Gọi hàm play() của Track (hàm này có thể ném ra PlayerException)
	                    nextTrack.play();
	                } catch (PlayerException e) {
	                    // Nếu phát hiện Track lỗi, in ra log hệ thống và ném tiếp (bắn ngoại lệ lên tầng UI)
	                    System.err.println("Playback failed for track '" + nextTrack.getTitle() + "' inside CD.");
	                    throw e; 
	                }
	            }
	        } else {
	            // Trường hợp tổng thời lượng CD <= 0
	            System.err.println("ERROR: CD length is non-positive!");
	            throw new PlayerException("ERROR: CD length is non-positive!");
	        }
	    }
	
}
