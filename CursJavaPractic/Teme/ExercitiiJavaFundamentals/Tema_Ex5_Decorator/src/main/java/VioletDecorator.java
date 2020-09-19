public class VioletDecorator extends FlowerDecorator {
    public VioletDecorator(Flower flowerToDecorate) {
        super(flowerToDecorate);
    }

    public void getColor() {
        flowerToDecorate.getColor();
        System.out.println("This violet is purple and it's parfumed.");
    }

    public String getPrice() {
        return "12 lei";
    }

}
