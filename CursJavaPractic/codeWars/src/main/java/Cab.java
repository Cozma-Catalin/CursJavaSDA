import java.lang.ref.Cleaner;

public class Cab implements AutoCloseable{

    public Cab(){}


    @Override
    public void close() throws Exception {
        System.out.println("Obiectul a fost sters");
    }
}
