public class Rectangle implements FigureGeometry{
    protected float length,width;
    protected int scale;

    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }
    public float perimeter(){
        return 2 * (length + width);
    }
    public float area(){
        return length * width;
    }
    public void setScale(int scale){
        this.scale = scale;
    }
    public float weight(){
        return this.area() * scale;
    }
    public String getName(){
        return "Rectangle";
    }

}