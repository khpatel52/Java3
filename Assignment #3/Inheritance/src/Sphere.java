public class Sphere extends Shape{
    public Sphere(){
        super();
    }

    public Sphere(double r){
        super(0,0,0,0,r);
    }
    public double area(){
        return 4 * Math.PI * this.getRadius() * this.getRadius();
    }
    public double perimeter(){
        return 4 * Math.PI * this.getRadius() * this.getRadius();
    }
    
    public double volume(){
        return (4/3.0) * Math.PI * Math.pow(this.getRadius(),3);
    }
    public String getName(){
        return "Sphere";
    }
}