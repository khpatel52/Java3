public class OrderedLinkedList extends LinkedListClass{    
    public OrderedLinkedList(){
        super();        
    }
    public boolean search(DataElement searchItem){
        LinkedListNode current = first;
        found = false;
        while(current != null && !found){
            IntElement temp = (IntElement)current.info;
            if(temp.compareTo(searchItem) >= 0)
                found = true;
            else             
                current = current.link;//go to the next node            
        }
        if (found){
            IntElement temp = (IntElement)current.info;
           found = temp.equals(searchItem);
        }
        return found; 
    }

    public void insert(DataElement insertItem){
        LinkedListNode current;  //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        LinkedListNode newNode;  //variable to create a node
        boolean  x;
        newNode = new LinkedListNode(); //create the node
        newNode.info = insertItem.getCopy();
        //Case 1; the list is empty
        if (first == null) {
           first = newNode;
           last = newNode;
           count++;
        }
        else {
            trailCurrent = first;
            current = first;
            x = false;
            while (current != null && !x) {//search the list
                IntElement temp = (IntElement) current.info;
                if (temp.compareTo(insertItem) >= 0)
                   x = true;
                else {
                   trailCurrent = current;
                   current = current.link;
                }
            }
            //Case 2 insertItem is smallest item in the list
            if (current == first) {
                newNode.link = first;
                first = newNode;
                count++;
            }
            //Case 3- Inserting at end if largest or in between
            else {
                trailCurrent.link = newNode;
                newNode.link = current;
                if (current == null)
                    last = newNode;
                count++;
            }
        }
    }

    public void deleteNode(DataElement deleteItem){
        LinkedListNode current = null;
        LinkedListNode trailCurrent = null;
        find(deleteItem);
        if (found)//only executes if list is not empty
        {
          if (first == location)     
            first = first.link;    // remove first node
          else{
            previous.link = location.link;  // remove node at location
                if(current == last)// if the last node was the one to be removed
                    last = trailCurrent;
            count--;
            }
        }
        else
            System.out.println("Item to be deleted is not in the list.");
}

    public OrderedLinkedList mergeLists(OrderedLinkedList list1, OrderedLinkedList list2){
        OrderedLinkedList mergedList = new  OrderedLinkedList();

        LinkedListNode list1Current = list1.first;
        LinkedListNode list2Current = list2.first;

        LinkedListNode newNode = new LinkedListNode();

        while(list1Current != null && list2Current != null){
            IntElement temp1 = (IntElement)list1Current.info; // temp var for casted info comparable
            if (temp1.compareTo(list2Current.info) >= 0){

                if (mergedList.first == null)  // if mergedList is empty, start it
                {
                    mergedList.first = new LinkedListNode();
                    mergedList.first.info = list2Current.info;
                    mergedList.first.link = new LinkedListNode();
                    newNode = mergedList.first.link;
                }else{
                    newNode.info = list2Current.info;
                    newNode.link = new LinkedListNode();
                    newNode = newNode.link;
                }
                    list2Current = list2Current.link;
                    count++;
            }else{
                if(mergedList.first == null)//if mergedList is empty, start it
                {
                    mergedList.first = new LinkedListNode();
                    mergedList.first.info = list1Current.info;
                    mergedList.first.link = new LinkedListNode();
                    newNode = mergedList.first.link;
                }else{
                    	newNode.info = list1Current.info;
                        newNode.link = new LinkedListNode();
                        newNode = newNode.link;
                }
                list1Current = list1Current.link;
                count++;
                //list2Current is higher, so insert list1Current
            }//end comparable else
        }//end while
        if(list1Current == null){ // if list1 is done, append list2
            while(list2Current != null){
                newNode.info = list2Current.info;
                if(list2Current.info != list2.last.info){newNode.link = new LinkedListNode();
                newNode = newNode.link;}
                list2Current = list2Current.link;
                count++;
                }
                }

    	if(list2Current == null){ // if list2 is done, append list 1
            while(list1Current != null){
                newNode.info = list1Current.info;
                if(list1Current.info != list1.last.info){newNode.link = new LinkedListNode();
                newNode = newNode.link;}
                list1Current = list1Current.link;
                count++;
            }
            }
            return mergedList;
            } // end mergeLists

public void insertUnique(DataElement insertItem){
        if(search(insertItem) != true) insert(insertItem);
        else
            System.out.println("Cannot insert duplicates");
    }

public void clear()//recovers all memory
  {
     LinkedListNode cur  = first.link;      //point to second node
     LinkedListNode prev = first;           //point to first node

     while( cur != null )
     {
        prev.link = null;
        prev = cur;
        cur = cur.link;
     }
     first = null;
     count = 0;
     currentPos = null;
  }
}

