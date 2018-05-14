public class UseFigs{
    public static void main(String[] args){
        //Instantiate circle class and invoke methods from interface
        Circle myCircle = new Circle(5);
        System.out.println(myCircle.perimeter());
        System.out.println(myCircle.area());
        //Instantiate a rectangle class and invoke methods
        Rectangle myRectangle = new Rectangle(7,8);
        System.out.println(myRectangle.perimeter());
        System.out.println(myRectangle.area());
        System.out.println();

        //Container to hold the objects
        FigureGeometry[] fg = new FigureGeometry[4];
        fg[0]= new Circle(10);
        fg[1]= new Circle(20);
        fg[2]= new Rectangle(6,7);
        fg[3]= new Rectangle(13,15);

        double areaSum = 0;
        double weightSum = 0;
        for(FigureGeometry element: fg){
            element.setScale(10);
            System.out.println("Name: " + element.getName());
            System.out.println("Area: " + element.area());
            System.out.println("Perimeter: " + element.perimeter());
            System.out.println("Weight: " + element.weight());
            System.out.println();
            areaSum += element.area();
            weightSum += element.weight();
        }
        System.out.println("The total area of all objects in the container is: "
                + areaSum);
        System.out.println("The total weight of all objects in the container "
                + "is: " + weightSum);

    }
}