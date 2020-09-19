public class Main {
    public static void main(String[] args) {
        PcFileReader pcFileReader = new PcFileReader();
        pcFileReader.readFile();

        Store store = Store.getInstance();
        System.out.println(store.getPc());
    }
}
