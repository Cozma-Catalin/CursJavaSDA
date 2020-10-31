public class CircleDecorator extends ShapeDecorator {

   public CircleDecorator(Shape shapeToDecorate){
       super(shapeToDecorate);
   }



    @Override
    public void draw() {
        super.draw();
        System.out.println("Am border.");
    }
}
