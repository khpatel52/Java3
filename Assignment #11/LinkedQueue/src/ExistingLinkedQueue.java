
 public class ExistingLinkedQueue extends LinkedListClass{
    public ExistingLinkedQueue() {
        super();
    }
    //Creating enqueue using linkedlistclass methods
    public void enqueue(DataElement element){
        insertLast(element);
    }
    //Creating dequeue using linkedlistclass methods
    public void dequeue(){
        deleteFront();
    }


}