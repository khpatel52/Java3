public abstract class Shape{
    private double length;
    private double breadth;
    private double height;
    private double base;
    private double radius;

    public Shape(){
        length = 0;
        breadth = 0;
        height = 0;
        base = 0;
        radius = 0;
    }
    
    public Shape(double l, double b, double h, double b1, double r){
        length = l;
        breadth = b;
        height = h;        
        base = b1;
        radius = r;
    }

    public void setLength(double l){
        length = l;
    }
    public void setBreadth(double b){
        breadth = b;
    }
    public void setHeight(double h){
        height = h;
    }
    public void setBase(double b1){
        base = b1;
    }
    public void setRadius(double r){
        radius = r;
    }

    public double getLength(){
        return length;
    }
    public double getBreadth(){
        return breadth;
    }
    public double getHeight(){
        return height;
    }
    public double getBase(){
        return base;
    }
    public double getRadius(){
        return radius;
    }
    public abstract String getName();
    
    public abstract double area();
    public abstract double perimeter();
    public abstract double volume();

}