public class Prism extends Shape{
    public Prism(){
        super();
    }
    public Prism(double l, double b, double h){
        super(l,b,h,0,0);
    }
    public double area(){
        double l = this.getLength();
        double b = this.getBreadth();
        double h = this.getHeight();
        return 2 * ((b*h)+(l*b)+(l*h));
    }
    public double perimeter(){
        double l = this.getLength();
        double b = this.getBreadth();
        double h = this.getHeight();
        return 2 * ((b*h)+(l*b)+(l*h));
    }
    public double volume(){
        return this.getLength() * this.getBreadth() * this.getHeight();
    }
    public String getName(){
        return "Prism";
    }
}