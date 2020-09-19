public class TriangleDecorator extends ShapeDecorator {


    public TriangleDecorator(Shape shapeToDecorate) {
        super(shapeToDecorate);
    }


    @Override
    public void draw() {
        shapeToDecorate.draw();
        System.out.println("Am border.");
    }
}
