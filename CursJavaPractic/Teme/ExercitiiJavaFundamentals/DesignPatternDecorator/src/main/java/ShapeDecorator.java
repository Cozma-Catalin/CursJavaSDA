public abstract class ShapeDecorator implements Shape{
    protected Shape shapeToDecorate;


    public ShapeDecorator(Shape shapeToDecorate){
        this.shapeToDecorate = shapeToDecorate;
    }

    public void draw(){
        if(shapeToDecorate!=null){
            shapeToDecorate.draw();
        }
    }

}
