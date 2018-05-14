public class IntElement extends DataElement{
    protected int num;
    public IntElement(){
        num = 0;
    }
    public IntElement(int x){
        num = x;
    }
    public IntElement(IntElement obj){
        num = obj.getNum();
    }
    public void setNum(int x){
        num = x;
    }
    public int getNum(){//check this later%%%%%%%%%%%%%%%%%
        return num;
    }
    public boolean equals(DataElement otherElement){
        if(otherElement == null) return false;
        IntElement element = (IntElement)otherElement;
        return (this.num == element.num);
    }
    public int compareTo(DataElement otherElement){
        IntElement element = (IntElement)otherElement;
        if(this.num < element.num) return -1;
        else if(this.num > element.num) return 1;
        else return 0;
    }
    public void makeCopy(DataElement otherElement){
        IntElement element = (IntElement)otherElement;
        this.num = element.num;

    }
    public DataElement getCopy(){
        DataElement element = new IntElement(this.num);
        return element;
    }
    public String toString(){
        return "The number is " + num;
    }
}
