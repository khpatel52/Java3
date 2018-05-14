public class Circle implements FigureGeometry{
    protected float radius;
    protected int scale;

    public Circle(float radius){
        this.radius = radius;
    }
    public float perimeter(){
        return 2 * PI * radius;
    }
    public float area(){
        return PI * radius * radius;
    }
    public void setScale(int scale){
        this.scale = scale;
    }
    public float weight(){
        return this.area() * scale;
    }
    public String getName(){
        return "Circle";
    }

}