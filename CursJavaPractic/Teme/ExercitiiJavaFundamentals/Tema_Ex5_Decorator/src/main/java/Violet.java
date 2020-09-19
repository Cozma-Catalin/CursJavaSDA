public class Violet extends Flower {
    public void getColor() {
        System.out.println("Violet's are blue.");
    }

    public String getPrice() {
        return "9 lei";
    }

    @Override
    public void makeBouquet() {
        System.out.println("We're making a blue violets bouquet.");
    }
}
