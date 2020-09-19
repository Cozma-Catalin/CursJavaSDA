public class RoseDecorator extends FlowerDecorator {
    public RoseDecorator(Flower flowerToDecorate) {
        super(flowerToDecorate);
    }

    public void getColor() {
        flowerToDecorate.getColor();
        System.out.println("This rose is white and it's parfumed.");
    }

    public String getPrice() {
        return "10 lei";
    }

}
