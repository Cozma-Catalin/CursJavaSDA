import java.util.Comparator;

public class TshirtComparator implements Comparator<Tshirt> {
    @Override
    public int compare(Tshirt tshirt1, Tshirt tshirt2) {
        return tshirt1.getPrice() - tshirt2.getPrice();
    }
}


