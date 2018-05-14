
public class CharElement extends DataElement{
    protected char letter;
    public CharElement(){
        letter = '\u0000';
    }
    public CharElement(char x){
        letter = x;
    }
    public CharElement(CharElement obj){
        letter = obj.getChar();
    }
    public void setLetter(char x){
        letter = x;
    }
    public char getChar(){
        return letter;
    }
    public boolean equals(DataElement otherElement){
        if(otherElement == null) return false;
        CharElement element = (CharElement)otherElement;
        return (this.letter == element.letter);
    }
    public int compareTo(DataElement otherElement){
        CharElement element = (CharElement)otherElement;
        if(this.letter < element.letter) return -1;
        else if(this.letter == element.letter) return 0;
        else return 1;
    }
    public void makeCopy(DataElement otherElement){
        CharElement element = (CharElement)otherElement;
        this.letter = element.letter;
    }
    public DataElement getCopy(){
        DataElement element = new CharElement(this.letter);        
        return element;
    }
    public String toString(){
        return "" + letter;
    }
}