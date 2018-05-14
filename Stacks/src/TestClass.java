public class TestClass{
    public static void main(String[] args){
        try{
        StackClass obj = new StackClass(5);
        System.out.println("Now will add 4 numbers to the stack obj");
        obj.push(new IntElement(11));
        obj.push(new IntElement(33));
        obj.push(new IntElement(22));
        obj.push(new IntElement(88));
        System.out.println("Now printing the contents of the stack");
        obj.print();

        System.out.println("Now copying obj into dupObj and printing it");
        StackClass dupObj = new StackClass(obj);
        dupObj.print();
        
        System.out.println("Now testing the inspector class and passing in"
                + " location of 3 in the method");
        IntElement el = (IntElement)obj.inspector(3);
        System.out.println("" + el.getNum() + "\nWhich is 3rd location from "
                + "top");
        
        System.out.println("Now removing last item using pop "
                + "and printing contents");
        obj.pop();
        obj.print();
        System.out.println("Now returning and printing content of last using "
                + "top and print methods");        
        System.out.println((IntElement)obj.top());
        System.out.println("Now clearing the list and print the stack");
        obj.initializeStack();
        obj.print();        
        CharStackClass obj1 = new CharStackClass();
        System.out.println("Now testing if an expression has matching delimeter"
                + " sets\nThe expression is:{ 2 + [ a - ( b * f ) ] + e }");
        obj1.expressionAnalyzer("{ 2 + [ a - ( b * f ) ] + e }");
        System.out.println("Now testing if an expression has matching delimeter"
                + " sets\nThe expression is:{ 2 + [ a - ( b * f )  + e ");
        obj1.expressionAnalyzer("{ 2 + [ a - ( b * f )  + e  ");

        System.out.println("Now testing part 5 of program 10 which is the "
                + "push operation for even and odd stacks");
        //randomly generate number between 1 and a 1000 200 times and push to
        //object of Double Stack
        DoubleStack dStack = new DoubleStack();
        for(int i = 0; i < 200; i++){
            int num = (int)(Math.random() * 1001);
            dStack.push(new IntElement(num));
        }
        dStack.print();
        System.out.println("Now pushing more elements than the size of the"
                + " list which will result in a stackoverflow exception");
        obj.push(new IntElement(11));
        obj.push(new IntElement(11));
        obj.push(new IntElement(11));
        obj.push(new IntElement(11));
        obj.push(new IntElement(11));
        obj.push(new IntElement(11));        
        
        }
        catch(StackOverflowException e){
            System.out.println(e.getMessage());
        }
        catch(StackException e){
            System.out.println(e.getMessage());
        }
        
    }
}