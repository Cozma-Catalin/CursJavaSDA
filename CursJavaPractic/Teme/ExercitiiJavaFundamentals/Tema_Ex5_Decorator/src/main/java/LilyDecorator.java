public class LilyDecorator extends FlowerDecorator {
    public LilyDecorator(Flower flowerToDecorate) {
        super(flowerToDecorate);
    }

    public void getColor() {
        flowerToDecorate.getColor();
        System.out.println("This lily is purple and it's parfumed.");
    }

    public String getPrice() {
        return "20 lei";
    }

}
