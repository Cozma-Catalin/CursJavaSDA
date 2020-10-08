import java.util.Comparator;

public class ShirtComparator implements Comparator<Shirt> {
    @Override
    public int compare(Shirt shirt1, Shirt shirt2) {
        return shirt1.getPrice() - shirt2.getPrice();
    }
}


