public abstract class FlowerDecorator {
    protected Flower flowerToDecorate;

    public FlowerDecorator(Flower flowerToDecorate){
        this.flowerToDecorate = flowerToDecorate;
    }

    public abstract void getColor();

    public abstract String getPrice();

}
