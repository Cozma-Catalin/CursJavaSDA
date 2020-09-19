public class TulipDecorator extends FlowerDecorator {

    public TulipDecorator(Flower flowerToDecorate) {
        super(flowerToDecorate);
    }

    public void getColor() {
        flowerToDecorate.getColor();
        System.out.println("This tulip is white and it's parfumed.");
    }

    public String getPrice() {
        return "8 lei";
    }

}
