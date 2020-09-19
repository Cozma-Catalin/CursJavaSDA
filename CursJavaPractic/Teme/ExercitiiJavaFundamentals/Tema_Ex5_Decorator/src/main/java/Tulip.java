public class Tulip extends Flower {
    public void getColor() {
        System.out.println("Tulip's are yellow.");
    }

    public String getPrice() {
        return "5 lei";
    }

    @Override
    public void makeBouquet() {
        System.out.println("We're making a yellow tulips bouquet.");
    }
}
