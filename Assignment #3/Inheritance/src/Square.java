public class Square extends Rectangle{
    public Square(){
        super();
    }

    public Square(double l){
        super(l,0,0,0);
    }
    public double area(){
        return this.getLength() * this.getLength();
    }
    public double perimeter(){
        return 4 * this.getLength();
    }
    //returning 0 for volume since a square is 2 dimensional and has no volume
    public double volume(){
        return 0;
    }
    public String getName(){
        return "Square";
    }
}