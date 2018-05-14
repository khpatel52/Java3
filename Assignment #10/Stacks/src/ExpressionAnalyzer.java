import java.util.Scanner;
public class ExpressionAnalyzer {
    Scanner in = new Scanner(System.in);
    String expression;
    String[] x;
    String[] y;
    StackClass obj1;
    boolean found;
    
    public boolean test(String a, String b){
        if(a.equals("(") && b.equals(")"))
            return true;
        if(a.equals("[") && b.equals("]"))
            return true;
        if(a.equals("{") && b.equals("}"))
            return true;
        else
            return false;
    }
        
    public ExpressionAnalyzer(String exp){
        found = false;        
        obj1 = new StackClass();
        expression = exp;
        x = new String[10];
        y = new String[10];
        int m = -1;
        int n = -1;
        String[] cols = expression.split(" ");
        for(int i = 0; i < cols.length; i++){
            if(cols[i].equals("(") || cols[i].equals("[") || cols[i].equals("{")){
                m++;
                x[m] = cols[i];
            }
            else if(cols[i].equals(")") || cols[i].equals("]") || cols[i].equals("}")){
                n++;
                y[n] = cols[i];
            }                        
            }
        if(m == n){
            int w = n;//w represents last paren of opening delimeters
            // i in the loop represents the first paren of closing delimeters
            for(int i = 0; i < m+1 && !found; i++){
            if(test(x[w],y[i])){//test returns true
                w--;                
            }
            else
                found = true;                
                }
        }
        else{
            System.out.println("Mismatching delimeter sets! Not all opening "
                    + "parenthesis are closed by closing parenthesis");
            return;
        }
        
        if(!found){//parenthesis are in the right order
            System.out.println("Parenthesis are closed in the right order and "
                    + "push and pop methods will be executed");
            for(int i = 0; i < m+1; i++){
            obj1.push(new IntElement(99));            
            }
            obj1.print();
            for(int i = 0; i < n+1; i++){
            obj1.pop();            
            }
            obj1.print();            
        }
        else
            System.out.println("Mismatching delimeter sets! Every opening"
                    + "parenthesis is closed but not in the right order");
    }
    
}
