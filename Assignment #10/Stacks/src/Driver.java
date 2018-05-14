public class Driver{
    public static void main(String[] args){
        StackClass obj = new StackClass(10);
        System.out.println("Now will add 4 numbers to the stack obj");
        obj.push(new IntElement(11));
        obj.push(new IntElement(33));
        obj.push(new IntElement(22));
        obj.push(new IntElement(88));
        System.out.println("Now printing the contents of the stack");
        obj.print();
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
        ExpressionAnalyzer s = new ExpressionAnalyzer("{ 2 + [ a - ( b * f ) ] + e } ");


    }
}