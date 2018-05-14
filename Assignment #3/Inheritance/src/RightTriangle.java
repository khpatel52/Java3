public class RightTriangle extends Rectangle{
    public RightTriangle(){
        super();
    }

    public RightTriangle(double h, double b1){
        super(0,0,h,b1);
    }
    public double area(){
        return .5 * this.getBase() * this.getHeight();
    }
    public double perimeter(){
        double hypotenuse = Math.sqrt((Math.pow(this.getBase(),2)+Math.pow(this.getHeight(), 2)));
        return this.getBase() + this.getHeight() + hypotenuse;
    }
    //returning 0 for volume since a triangle is 2 dimensional and has no
    //volume
    public double volume(){
        return 0;
    }
    public String getName(){
        return "Right Triangle";
    }
}