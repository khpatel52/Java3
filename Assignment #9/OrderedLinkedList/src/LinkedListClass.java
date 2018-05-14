public abstract class LinkedListClass{
    protected class LinkedListNode{
        protected DataElement info;
        protected LinkedListNode link;        
    }
    protected LinkedListNode first;
    protected LinkedListNode last;
    protected LinkedListNode currentPos;// current position for iteration
    protected LinkedListNode location;//node containing element, if found
    protected LinkedListNode previous;//node preceding location
    protected boolean found;
    protected int count;

    public LinkedListClass(){
        first = null;
        last = null;
        count = 0;
    }
    public boolean isEmptyList(){
        return (first == null);//if first is null list is empty
    }
    public void initializeList(){
        first = null;
        last = null;
        count = 0;
    }
    public void print(){
        LinkedListNode p = first;
        int i =0;
        if(p == null) System.out.println("Nothing to print");
        else{
        while(p != null){
            IntElement x = (IntElement)p.info;
            int y = x.num;
            System.out.print(y + "  ");
            p = p.link;
            if(i % 10 == 0 && i != 0) System.out.println();
            ++i;
        }
        
    }
    }

    public int length(){
        LinkedListNode p = first;
        int size = 0;
        while(p != null){
            size++;//since p is already the first node and must be counted
            p = p.link;
        }
        return size;
    }
    public DataElement front(){
        if(!isEmptyList())//if list is not empty
            return first.info;
        else
            return null;
    }
    public DataElement back(){
        if(!isEmptyList())//if list is not empty
            return last.info;
        else
            return null;
    }
    protected void find(DataElement target)
  // Searches list for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets
  // found to false.
  {
    location = first;
    found = false;

    while (location != null)
    {
      if (location.info.equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previous = location;        // move to next node
        location = location.link;
      }
    }
  }
    public void insertFirst(DataElement newItem){
        LinkedListNode n = new LinkedListNode();
        n.info = newItem.getCopy();
        if(!isEmptyList())//if list is not empty
            n.link = first;
        else if(first == null)//if list is empty
            last = n;
        first = n;
        count++;
        
    }
    public void insertLast(DataElement newItem){
        LinkedListNode n = new LinkedListNode();
        n.info = newItem.getCopy();
         if (first == null) {
            first = n;
            last = n;
        }
        else if(!isEmptyList()){
            last.link = n;
            last = n;
        }
        count++;
    }
    public abstract boolean search(DataElement searchItem);

    public abstract void deleteNode(DataElement deleteItem);

    public double mean(){//compute mean of the list
        double sum = 0;
        LinkedListNode p = first;
        while(p != null){
            IntElement x = (IntElement)p.info;
            sum = sum + x.getNum();
            p = p.link;
        }
        return (sum/count);
    }

    public double getStdDev(){//compute standard deviation of the list
        double[] data = new double[count];
        double mean = mean();
        double sum = 0;
        double stdDev = 0;
        int i = 0;
        LinkedListNode p = first;
        while(p != null){
            data[i] = ((IntElement)p.info).getNum() - mean;
            data[i] = Math.pow(data[i],2);
            sum = sum + data[i];
            p = p.link;
            i++;
        }
        sum /= (count-1);
        stdDev = Math.sqrt(sum);
        return stdDev;
}
    
}