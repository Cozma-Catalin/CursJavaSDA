import java.util.Comparator;

public class TVComparator implements Comparator<TV> {
    public int compare(TV tv1, TV tv2) {
        return tv1.getDiag()-tv2.getDiag();
    }
}
