public class CircleDecorator extends ShapeDecorator {

   public CircleDecorator(Shape shapeToDecorate){
       super(shapeToDecorate);
   }



    @Override
    public void draw() {
        shapeToDecorate.draw();
        System.out.println("Am border.");
    }
}
