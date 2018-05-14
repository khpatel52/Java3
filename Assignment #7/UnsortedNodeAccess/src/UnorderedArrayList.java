public class UnorderedArrayList extends ArrayListClass{
    public UnorderedArrayList(){
        super();
    }
    public UnorderedArrayList(int size){
        super(size);       
        
    }
    public UnorderedArrayList(UnorderedArrayList obj){
        super(obj);
    }
    public int seqSearch(DataElement searchItem){
        int loc;
        for(loc = 0; loc < length; loc++)
            if(list[loc].equals(searchItem))
                return loc;//found at loc
        return -1;//not found        
    }
    public boolean insert(DataElement insertItem){
 
    boolean rc = true;
    int loc;
    if(length == 0)                  //list is empty
       list[length++] = insertItem;  //insert the item and
                                     //increment the length
    else
       if(length == maxSize)  //list full
          rc = false;
       else
       {
          loc = seqSearch(insertItem);
          if(loc == -1)      //the item to be inserted
                             //does not exist in the list
                             //then insert it
             list[length++] = insertItem.getCopy();
          else
             rc = false; //duplicates not allowed
       }
    return rc;       
}//end insert
    public void remove(DataElement removeItem){

    boolean rc = true;
    int loc;
    if(length == 0) //empty list
       rc = false;
    else
    {
       loc = seqSearch(removeItem);
       if(loc != -1)
          removeAt(loc);
       else
          rc = false; //not in the list
    }
}//end remove
    // insert duplicates
public boolean insertDup(DataElement insertItem){

    boolean rc = true;
    int loc;
    if(length == 0)                  //list is empty
       list[length++] = insertItem;  //insert the item and
                                     //increment the length
    else
       if(length == maxSize)  //list full
          rc = false;
       else
          list[length++] = insertItem.getCopy();

    return rc;       
}//end insertDup

//adding methods from question 5
public boolean removeAt(int location)//remove element by swapping with last
{
   boolean rc = true; 
   if(location < 0 || location >= length)     //out of range
      rc = false;
   else
   {
      list[location] = list[length-1];
      list[length-1] = null;
      length--;
    }
    return rc;
}//end removeAt
public int min()//retrieve smallest value in list
{
    IntElement mini = (IntElement)(list[0].getCopy());
    for(int i = 0; i < length; i++){
        if((list[i].compareTo(mini)) == -1)
            mini = (IntElement)(list[i].getCopy());
    }
    return mini.getNum();
}
public int max()//retrieve largest value in the list
{
    IntElement maxm = (IntElement)(list[0].getCopy());
    for(int i = 0; i < length; i++){
        if((list[i].compareTo(maxm)) == 1)
            maxm = (IntElement)(list[i].getCopy());
    }
    return maxm.getNum();
}
public int sum()//retrieve the sum of the list
{
    int sum = 0;
    for(int i = 0; i < length; i++){
        sum = sum + ((IntElement)list[i]).getNum();
    }
    return sum;
}
public double average()//retrieve the average of the list
{
    int sum = 0;
    for(int i = 0; i < length; i++){
        sum = sum + ((IntElement)list[i]).getNum();
    }
    return (double)sum/length;
}
public double getStdDev(){        
        double[] data = new double[length];
        double mean = average();
        double sum = 0;
        double stdDev = 0;
        for(int i = 0; i < length; i++){
            data[i] = ((IntElement)list[i]).getNum() - mean;
            data[i] = Math.pow(data[i],2);
            sum = sum + data[i];
        }
        sum /= (list.length-1);
        stdDev = Math.sqrt(sum);
        double n = 0;
        for(double element: data){
            if(element >= mean - stdDev && element <= mean + stdDev) n++;

    }
        return n;
}
}
