public class SquareDecorator extends ShapeDecorator {

    public SquareDecorator(Shape shapeToDecorate){
        super(shapeToDecorate);
    }



    @Override
    public void draw() {
        super.draw();
        System.out.println("Am border.");
    }
}
