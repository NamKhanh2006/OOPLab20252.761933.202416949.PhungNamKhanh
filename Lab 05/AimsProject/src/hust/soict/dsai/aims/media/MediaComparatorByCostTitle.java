package hust.soict.dsai.aims.media;

import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

//Sort by Cost, then Title (Alphabetical if costs are the same)
public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media m1, Media m2) {
		// Decreasing cost
		int costDiff = Float.compare(m2.getCost(), m1.getCost());
		if (costDiff != 0) {
			return costDiff;
		}
		return m1.getTitle().compareToIgnoreCase(m2.getTitle());
	}
}