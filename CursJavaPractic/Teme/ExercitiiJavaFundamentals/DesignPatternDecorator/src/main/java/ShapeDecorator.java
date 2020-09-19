public abstract class ShapeDecorator {
    protected Shape shapeToDecorate;


    public ShapeDecorator(Shape shapeToDecorate){
        this.shapeToDecorate = shapeToDecorate;
    }

    public abstract void draw();

}
