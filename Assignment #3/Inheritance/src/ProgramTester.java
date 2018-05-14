public class ProgramTester{
    public static void main(String[] args){
        //Container to hold the various objects
        Shape[] s = new Shape[12];
        s[0] = new Rectangle(2,3,0,0);
        s[1] = new Rectangle(4,5,0,0);
        s[2] = new Square(2);
        s[3] = new Square(10);
        s[4] = new RightTriangle(3,4);
        s[5] = new RightTriangle(5,6);
        s[6] = new Circle(5);
        s[7] = new Circle(7);
        s[8] = new Sphere(8);
        s[9] = new Sphere(9);
        s[10] = new Prism(5,6,7);
        s[11] = new Prism(10,11,12);

        for(Shape element: s){
            System.out.println(element.getName());
            System.out.println("The Area is: " + element.area());
            System.out.println("The Perimeter is: " + element.perimeter());
            if(element.volume() == 0)
                System.out.println("Volume is 0 since it is a two dimensional "
                        + "object");
            else
            System.out.println("The Volume is: " + element.volume());
            System.out.println();

        }


    }
}