public class WaitingQueue{
    protected class LLNode{
        protected Customer info;
        protected LLNode link;
    }
    protected LLNode front;
    protected LLNode rear;    

    public WaitingQueue(){
        front = null;
        rear = null;        
    }
    //Determines if the queue is empty
    public boolean isEmptyList(){
        return (front == null);
    }    
    private void enqueue(Customer element){
        LLNode newNode = new LLNode();
        newNode.info = element.getCopy();
        if(rear == null)
            front = newNode;
        else
            rear.link = newNode;
        rear = newNode;
    }
    //Adds customer to the waiting queue
    public void getsInLine(Customer element){
        enqueue(element);
    }
    //Dequeue method removes element from first, and from custom approach
    //Customer dequed is returned
    //Customer dequed from the queue is sent to a server which is free
    private Customer dequeue(){
        if(isEmptyList())
            throw new QueueUnderflowException("Dequeue attempted on empty "
                    + "queue.");
        else{
            Customer element;
            element = front.info.getCopy();
            front = front.link;
            if(front == null)//if list becomes empty after dequeue
                rear = null;
            return element;                      
        }
    }
    public void goesToCounter(ServerList list){
        if(list.checkFreeServer() == true){
            int x = list.freeServer();//x is the server that is free
            Customer element;
            element = dequeue();//dequeued customer is sent to server
            list.sList[x].updateStatus(element, "busy"); //server is now busy        
        }
        else
            System.out.println("No free servers available at the moment");
    }
    public void print(){
        LLNode p = front;
        while(p != null){
            System.out.println(p.info + "\n");
            p = p.link;
        }
        System.out.println();
    }
    //updates the wait time for the customers
    public void update(){        
        LLNode p;
        p = front;        
        while(p != null){
            p.info.updateWaitTime();
            p = p.link;
        }
    }
    //returns total wait time of all customers in the queue
    public int totalWaitTime(){
        return Customer.getTotalWaitTime();
    }
    //returns the total number of customer who come to the store
    public int totalCustomers(){
        return Customer.getTotalCustomers();
    }
    //returns the size of the queue at any moment
    public int size(){
        LLNode p = front;
        int size = 0;
        while(p != null){
            p = p.link;
            size++;
        }
        return size;
    }
    
}