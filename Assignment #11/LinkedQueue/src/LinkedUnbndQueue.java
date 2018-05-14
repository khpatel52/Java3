public class LinkedUnbndQueue{
    protected class LLNode{
        protected DataElement info;
        protected LLNode link;
    }
    protected LLNode front;
    protected LLNode rear;    

    public LinkedUnbndQueue(){
        front = null;
        rear = null;        
    }
    public boolean isEmptyList(){
        return (front == null);
    }
    //Enqueue method adds element to the rear of the list
    public void enqueue(DataElement element){
        LLNode newNode = new LLNode();
        newNode.info = element.getCopy();
        if(rear == null)
            front = newNode;
        else
            rear.link = newNode;
        rear = newNode;
    }
    //Dequeue method removes element from first, and from custom approach
    //nothing is returned
    public DataElement dequeue(){
        if(isEmptyList())
            throw new QueueUnderflowException("Dequeue attempted on empty "
                    + "queue.");
        else{
            DataElement element;
            element = front.info.getCopy();
            front = front.link;
            if(front == null)//if list becomes empty after dequeue
                rear = null;
            return element;
        }
    }
    public void print(){
        LLNode p = front;
        while(p != null){
            System.out.println(p.info + "");
            p = p.link;
        }
        System.out.println();
    }
    
}