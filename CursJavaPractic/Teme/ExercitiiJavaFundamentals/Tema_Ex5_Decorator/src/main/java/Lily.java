public class Lily extends Flower {
    public void getColor() {
        System.out.println("Lily's are white.");
    }

    public String getPrice() {
        return " 12 lei";
    }

    @Override
    public void makeBouquet() {
        System.out.println("We're making a white lilys bouquet.");
    }
}
