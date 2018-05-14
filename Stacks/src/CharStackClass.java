
public class CharStackClass{
    private int stackTop;
    private int maxStackSize;
    private DataElement[] list;
    
    //constructor without parameter
    public CharStackClass(){
        maxStackSize = 100;
        stackTop = 0;
        list = new DataElement[maxStackSize];
    }
    //constructor with parameter
    public CharStackClass(int stackSize){ 
     if(stackSize <= 0)
     {
        System.out.println("The size of the array to implement the stack must"
                + " be positive");                         
        System.out.println("Creating an array of size 100.");
        maxStackSize = 100;
     }
     else
        maxStackSize = stackSize;  //set the stack size to 
                                   //the value specified by 
                                   //the parameter stackSize
     stackTop = 0;                 //set stackTop to 0
     list = new DataElement[maxStackSize]; //create the array
    }//end constructor
    //helper copy method
    private void copy(CharStackClass otherStack){
        list = null;
        maxStackSize = otherStack.maxStackSize;
        stackTop = otherStack.stackTop;
        list = new DataElement[maxStackSize];
        //copy otherStack data into this Stack
        for(int i = 0; i < stackTop; i++)
            this.list[i] = otherStack.list[i].getCopy();        
    }
    //copy constructor
    public CharStackClass(CharStackClass otherStack){
        copy(otherStack);        
    }
    //copy data from otherstack to this stack
    public void CopyStack(CharStackClass otherStack){
        if(this != otherStack)
            copy(otherStack);//avoid self-copy            
    }
    
    public void initializeStack(){
        for(int i = 0; i < stackTop; i++)
            list[i] = null;
        stackTop = 0;
    }//end initializeStack
    
    public boolean isEmptyStack(){
        return(stackTop == 0);
    }//end isEmptyStack
    
    public boolean isFullStack(){        
        return(stackTop == maxStackSize);
    }//end isFullStack
    
    public void push(DataElement newItem){
    if(isFullStack())
       throw new StackOverflowException();
    list[stackTop] = newItem.getCopy(); //add newItem at the
                                        //top of the stack
    stackTop++;                         //increment stackTop
    }//end push
    
    public DataElement top(){ 
     if(isEmptyStack())
        return null; 
     return list[stackTop - 1].getCopy();         
    }//end top
    
    public DataElement pop(){
    if(isEmptyStack())
       return null; 
    
     DataElement temp = list[stackTop - 1].getCopy();
 
     stackTop--;       //decrement stackTop
     list[stackTop] = null;
     
     return temp;
    }//end pop
    
    public void print(){
        String s = "";
        if(isEmptyStack()) 
            s = "Nothing to print";
        else{
        IntElement x;
        for(int i = 0 ; i < stackTop; i++){
            x = (IntElement)list[i];
            s = s + x.getNum() + "\n";
        }
        }
        System.out.println(s);
    
    }
    //Program 10 part 2
    public void expressionAnalyzer(String x){        
        //creating an array of chars of the original string
        CharStackClass delim = new CharStackClass();
        char[] cArray = x.toCharArray();
        for(int i = 0; i < cArray.length; i++){              
            if(cArray[i] == '{' || cArray[i] == '(' || cArray[i] == '[')
                delim.push(new CharElement(cArray[i]));                          
        }
        if(delim.stackTop == 0){
            System.out.println("Error! No Opening brackets!!");
            return;
        }
        else{
            for(int i = 0; i < cArray.length; i++){
                if(cArray[i] == '}' || cArray[i] == ')' || cArray[i] == ']'){
                    CharElement ch = (CharElement)delim.top();                
                    if(ch.getChar() == '{' && cArray[i] == '}')
                        delim.pop();
                    else if(ch.getChar() == '[' && cArray[i] == ']')
                        delim.pop();
                    else if(ch.getChar() == '(' && cArray[i] == ')')
                        delim.pop();
                    else{
                        System.out.println("Error! Wrong Closing brackets!!");
                        return;
                        }
                    }
            }
            if(delim.stackTop == 0)
            System.out.println("Operation successful! Matching delimeter sets "
                    + "available in correct positions");
            else
                System.out.println("Error! Wrong number of closing brackets and"
                        + " hence mismatching delimeters");
        }     
                
        }
    }


   