public class Rose extends Flower {
    public void getColor() {
        System.out.println("Rose's are red.");
    }
    public String getPrice(){
        return "10 lei";
    }

    @Override
    public void makeBouquet() {
        System.out.println("We're making a red roses bouquet.");
    }
}
