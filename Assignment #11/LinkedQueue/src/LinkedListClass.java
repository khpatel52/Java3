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

    public boolean deleteFront(){
        if(isEmptyList())
            return false;
        else{
            first = first.link;
            if(isEmptyList())
                last = null;
            count--;
            return true;
        }
    }
    
}