public class TriangleDecorator extends ShapeDecorator {


    public TriangleDecorator(Shape shapeToDecorate) {
        super(shapeToDecorate);
    }


    @Override
    public void draw() {
        super.draw();
        System.out.println("Am border.");
    }
}
