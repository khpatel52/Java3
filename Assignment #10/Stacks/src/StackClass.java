public class StackClass{
    private int stackTop;
    private int maxStackSize;
    private DataElement[] list;
    
    //constructor without parameter
    public StackClass(){
        maxStackSize = 100;
        stackTop = 0;
        list = new DataElement[maxStackSize];
    }
    //constructor with parameter
    public StackClass(int stackSize){ 
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
    private void copy(StackClass otherStack){
        list = null;
        maxStackSize = otherStack.maxStackSize;
        stackTop = otherStack.stackTop;
        list = new DataElement[maxStackSize];
        //copy otherStack data into this Stack
        for(int i = 0; i < stackTop; i++)
            this.list[i] = otherStack.list[i].getCopy();        
    }
    //copy constructor
    public StackClass(StackClass otherStack){
        copy(otherStack);        
    }
    //copy data from otherstack to this stack
    public void CopyStack(StackClass otherStack){
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

}
   