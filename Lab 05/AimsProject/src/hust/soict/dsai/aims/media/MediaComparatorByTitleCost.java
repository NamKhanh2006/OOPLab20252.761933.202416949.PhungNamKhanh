package hust.soict.dsai.aims.media;

import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

// Sort by Title, then Cost (Higher cost first if titles are the same)
public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleDiff != 0) {
            return titleDiff;
        }
        // Higher cost first
        return Float.compare(m2.getCost(), m1.getCost());
    }
}