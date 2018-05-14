
public class DoubleStack{
    private int evenStackTop;
    private int oddStackTop;
    private int maxStackSize;
    private DataElement[] list;

    //constructor without parameter
    public DoubleStack(){
        maxStackSize = 400;
        evenStackTop = 0;
        oddStackTop = 200;
        list = new DataElement[maxStackSize];
    }
    //copy constructor
    public DoubleStack(DoubleStack otherStack){
        copy(otherStack);
    }

    public boolean isEmptyStack(){
    return(evenStackTop == 0 && (oddStackTop-200) == 0);
    }//end isEmptyStack

    public boolean isFullStack(){//cannot have more than 200 elements any time
    return((evenStackTop + (oddStackTop-200)) > 200);
    }//end isFullStack

    public void push(DataElement newItem){
    if(isFullStack())
       throw new StackException("Cannot have more than 200 elements");
    IntElement element = (IntElement)newItem;
    if(element.getNum() % 2 == 0){
        list[evenStackTop] = newItem.getCopy(); //add newItem at the
                                            //top of the even stack
        evenStackTop++;                        //increment evenStackTop
        }
    else{
        list[oddStackTop] = newItem.getCopy(); //add newItem at the
                                            //top of the odd stack
        oddStackTop++;                        //increment oddStackTop
        }

    }//end push

    public void print(){
        String s = "";
        if(isEmptyStack())
            s = "Nothing to print";
        else{
            IntElement x;
            for(int i = 0 ; i < evenStackTop; i++){
                x = (IntElement)list[i];
                if(i % 10 == 0 && i != 0)
                    s = s + x.getNum() + "\n";
                else
                    s = s + x.getNum() + "   ";
            }
            s += "\n\n";
            for(int i = 200 ; i < oddStackTop; i++){
                x = (IntElement)list[i];
                if(i % 10 == 0 && i != 200)
                    s = s + x.getNum() + "\n";
                else
                    s = s + x.getNum() + "   ";
            }
        }
        System.out.println(s);

    }

    private void copy(DoubleStack otherStack){
        maxStackSize = otherStack.maxStackSize;
        evenStackTop = otherStack.evenStackTop;
        oddStackTop = otherStack.oddStackTop;
        list = new DataElement[maxStackSize];
        //copy otherStack data into this Stack
        for(int i = 0; i < evenStackTop; i++)
            this.list[i] = otherStack.list[i].getCopy();
        for(int i = 200; i < oddStackTop; i++)
            this.list[i] = otherStack.list[i].getCopy();
    }

    //copy data from otherstack to this stack
    public void CopyStack(DoubleStack otherStack){
        if(this != otherStack)
            copy(otherStack);//avoid self-copy
    }

    public void initializeStack(){
    for(int i = 0; i < evenStackTop; i++)
        list[i] = null;
    for(int i = 200; i < oddStackTop; i++)
        list[i] = null;
    evenStackTop = 0;
    oddStackTop = 0;
    }//end initializeStack

}
   