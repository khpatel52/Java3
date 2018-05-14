public abstract class ArrayListClass{
 
protected int length; //to store length of the list
protected int maxSize; // to store max size of list
protected DataElement[] list; //array to hold list elements
 
 
public ArrayListClass(){
	length = 0;
	maxSize = 100;
	list = new DataElement[maxSize];
}
 
public ArrayListClass(int size){
 
	 length = 0;
	 maxSize = size;
	 list = new DataElement[maxSize];
         
}
 
public ArrayListClass(ArrayListClass obj){
 
	this.length = obj.length;
	this.maxSize = obj.maxSize;
	this.list = obj.list;
 
}
 
public boolean isEmpty()
{
    return (length == 0);
}
 
public boolean isFull()
{
    return (length == maxSize); 
} 
 
public int listSize()
{
    return length;
}
 
public int maxListSize()
{
    return maxSize;
}
 
 
public void print()
{
    for(int i = 0; i < length; i++)
        System.out.print(list[i] + " ");
    System.out.println();
}
 
public boolean isItemAtEqual(int location, DataElement item)
{
    return (list[location].equals(item));
}
 
 
public boolean insertAt(int location, DataElement insertItem)
{
    boolean rc = true; 
    if(location < 0 || location >= maxSize)    //out of range 
       rc = false;     
    else
       if(length >= maxSize)  //list is full
          rc = false;
       else
       {
          for(int i = length; i > location; i--)
              list[i] = list[i - 1];           //move the elements down
          list[location] = insertItem.getCopy();  //insert the item at
                                               //the specified position
          length++;      //increment the length
       }
    return rc;
 }//end insertAt
 
 
 public boolean insertEnd(DataElement insertItem)
{
    boolean rc = true;
    if(length >= maxSize)  //the list is full
       rc = false;
    else
    {
       list[length] = insertItem.getCopy();   //insert item 
                                              //at end
       length++;       //increment the length
    }
    return rc;
}//end insertEnd
 
 
public boolean removeAt(int location)
{
   boolean rc = true; 
   if(location < 0 || location >= length)     //out of range
      rc = false;
   else
   {
      for(int i = location; i < length - 1; i++)
          list[i] = list[i + 1];
      list[length - 1] = null;
      length--;
    }
    return rc;
}//end removeAt
 
 
public DataElement retrieveAt(int location)
{
    if(location < 0 || location >= length) //out of range
    {
       return null;
    }
    else
       return list[location].getCopy();
}//end retrieveAt
 
public boolean replaceAt(int location, DataElement repItem)
{
    boolean rc = true; 
    if(location < 0 || location >= length)   //out of range
       rc = false;
    else
       list[location].makeCopy(repItem);
    return rc;
}//end replaceAt
 
 
public void clearList()
{
    for(int i = 0; i < length; i++)
        list[i] = null;
    length = 0;
 
}//end clearList
 
 
public abstract int seqSearch(DataElement searchItem);
 
public abstract boolean insert(DataElement insertItem);
 
public abstract void remove(DataElement removeItem);

public abstract boolean insertDup(DataElement insertItem);
 
}
