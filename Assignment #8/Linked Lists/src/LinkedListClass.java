public abstract class LinkedListClass{
    protected class LinkedListNode{
        protected DataElement info;
        protected LinkedListNode link;
    }
    protected LinkedListNode first;
    protected LinkedListNode last;
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
        while(p != null){
            System.out.println(p.info + "");
            p = p.link;
        }
        System.out.println();
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
    public void insertFirst(DataElement newItem){
        LinkedListNode n = new LinkedListNode();
        n.info = newItem.getCopy();
        if(!isEmptyList())//if list is not empty
            n.link = first;
        else if(first == null)//if list is empty
            last = n;
        first = n;
        count++;
        /*LinkedListNode p = first;
        while(p != null){
            p = p.link;
        }
        last = p;*/ //this loop iterated through the list and sets last to final node
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
    public void splitMid(LinkedListClass a, LinkedListClass b){        
        int num = count;
        LinkedListNode p = first;
        LinkedListNode split1Last;//last node of the first list in the split
        LinkedListNode split2First;//first node of the second list in the split
        LinkedListNode current;

        if(first == null)//if list is empty
            System.out.println("Cannot split empty list");
        else{//if list is not empty
            if(num % 2 == 0){//if even number of nodes
                for(int i = 1; i < num/2;i++){
                    p = p.link;
                }
                a.first = first;
                a.last = p;
                current = p.link;
                a.last.link = null;
                b.first = current;
                b.last = last;
              
            }
            else{//if odd number of nodes
                 for(int i = 1; i < (count/2)+1; i++){
                     p = p.link;
                 }
                a.first = first;
                a.last = p;
                current = p.link;
                a.last.link = null;
                b.first = current;
                b.last = last;
             }
        }        
    }
}