public class Rectangle extends Shape{
    public Rectangle(){
        super();
    }
    public Rectangle(double l, double b, double h, double b1){
        super(l,b,h,b1,0);
    }
    public double area(){
        return this.getLength() * this.getBreadth();
    }
    public double perimeter(){
        double p = (this.getLength() + this.getBreadth()) * 2;
        return p;
    }
    //returning 0 for volume since a rectangle is 2 dimensional and has no
    //volume
    public double volume(){
        return 0;
    }
    public String getName(){
        return "Rectangle";
    }
}