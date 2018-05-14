
public class ArrayIntLog implements IntLogInterface{
    protected String name;
    protected int[] log;
    protected int lastIndex = -1;

    public ArrayIntLog(String name, int maxSize){
        if(maxSize > 0){
            log = new int[maxSize];
            this.name = name;
        }
        else
            log = new int[100];
            this.name = name;
    }
    public ArrayIntLog(String name){
            log = new int[100];
            this.name = name;
    }
    public void insert(int element){
        lastIndex++;
        log[lastIndex] = element;
    }
    public boolean isFull(){
        if(lastIndex == (log.length)-1) return true;
        else return false;
    }
    public int size(){
        return lastIndex+1;
    }
    public boolean contains(int element){
        for(int i = 0; i <= lastIndex; i++ ){
            if(element == log[i]) return true;
        }
        return false;
    }
    public void clear(){
        for(int i = 0; i <= lastIndex; i++) log[i] = 0;
        lastIndex = -1;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        String logString = "Log: " + name + "\n\n";
        for(int i = 0; i <= lastIndex; i++)
            logString = logString + (i+1) + ". " + log[i] + "\n";
        return logString;
    }
    public static int RandomGen(){
        return (int)Math.round(Math.random() * 1000 + 1);
    }


}
