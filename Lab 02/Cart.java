
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is now full.");
            }
        } else {
            System.out.println("The cart is already full. Cannot add: " + disc.getTitle());
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexToRemove = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle()) && 
            	itemsOrdered[i].getCategory().equals(disc.getCategory()) &&
            	itemsOrdered[i].getDirector().equals(disc.getDirector()) &&
            	itemsOrdered[i].getLength() == disc.getLength() &&
            	itemsOrdered[i].getCost() == disc.getCost() ) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            qtyOrdered--;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}