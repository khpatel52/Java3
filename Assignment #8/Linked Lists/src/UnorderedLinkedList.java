public class UnorderedLinkedList extends LinkedListClass{
     public UnorderedLinkedList() {
        super();
    }
     
    public boolean search(DataElement searchItem){
        LinkedListNode p = first;//p is an iterator for Traversal
        while(p != null){
            if(p.info.equals(searchItem)) return true;
            p = p.link;
        }
        return false;
    }
    public void deleteNode(DataElement deleteItem){
        LinkedListNode current;
        LinkedListNode trailCurrent;
        boolean found;
        if(first == null)
            System.out.println("Cannot delete from an empty list");
        else{
            //the node to be deleted is first
            if(first.info.equals(deleteItem)){
                first = first.link;
                if(isEmptyList())
                    last = null;
                count--;
            }
            else{ //search the list for the given info
                found = false;
                trailCurrent = first;
                current = first.link;
                while(current != null && !found){
                    if(current.info.equals(deleteItem))
                        found = true;
                    else{
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //if found, delete the node
                if(found){
                    count--;
                    trailCurrent.link = current.link;
                    if(last == current)//node to be deleted was the last node
                        last = trailCurrent;
                }
                else
                    System.out.println("Item to be deleted is not in the list.");


            }
        }
    }
    
}
