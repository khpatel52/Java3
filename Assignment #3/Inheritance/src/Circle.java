
public class Circle extends Shape{
    public Circle(){
        super();
    }
    public Circle(double r){
        super(0,0,0,0,r);
    }
    public double area(){
        return Math.PI * this.getRadius() * this.getRadius();
    }
    public double perimeter(){
        return 2 * Math.PI * this.getRadius();
    }
    //returning 0 for volume since a circle is 2 dimensional and has no volume
    public double volume(){
        return 0;
    }
    public String getName(){
        return "Circle";
    }
}