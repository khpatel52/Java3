public class TestClass{
    public static void main(String[] args){
        //creating an array of 59 intElements
        IntElement[] data = new IntElement[59];
        OrderedLinkedList list1 = new OrderedLinkedList();
        
        //generating random values between 1 and 100 and inserting them into the
        //linked list
        for(int i = 0; i < 59; i++){
            data[i] = new IntElement((int)(Math.random()*101));
            list1.insert(data[i]);
        }
        System.out.println("The size of the list is: " + list1.length());
        System.out.println("Checking if the list is empty");
        System.out.println("The list is empty: " + list1.isEmptyList());
        System.out.println("The sorted list of 59 random numbers is: ");
        list1.print();
        System.out.println("\nNow checking if an IntElement object exists in "
                + "the list");
        DataElement s1 = new IntElement(23);
        DataElement s2 = new IntElement(55);
        DataElement s3 = new IntElement(0);
        System.out.println("Does s1 exist: " + list1.search(s1) + "\nDoes s2 "
                + "exist: " + list1.search(s2) + "\nDoes s3 exist: " +
                list1.search(s3) + "\n");       
        
        //Now creating two individual sorted lists and sorting them
        OrderedLinkedList list2 = new OrderedLinkedList();
        OrderedLinkedList list3 = new OrderedLinkedList();
        OrderedLinkedList list4 = new OrderedLinkedList();
        OrderedLinkedList list5 = new OrderedLinkedList();
        //inserting elements into lists 2 and 3
        list2.insert(new IntElement(21));
        list2.insert(new IntElement(9));
        list2.insert(new IntElement(7));
        list2.insert(new IntElement(55));
        list2.insert(new IntElement(66));
        list3.insert(new IntElement(6));
        list3.insert(new IntElement(99));
        list3.insert(new IntElement(44));
        list3.insert(new IntElement(48));
        list3.insert(new IntElement(67));
        System.out.println("Now printing two newly created lists");
        System.out.print("List 2:   ");
        list2.print();
        System.out.println();
        System.out.print("List 3:   ");
        list3.print();
        System.out.println();
        System.out.println("Now printing the sorted list: ");
        list5 = list4.mergeLists(list2, list3);
        list5.print();

        System.out.println("\nNow adding duplicate with insertUnique method");
        list1.insertUnique(new IntElement(44));
        System.out.println("Now will insert unique value (value above 100) "
                + "and print list");
        list1.insertUnique(new IntElement(120));
        list1.print();
        System.out.println("\nNow deleting an item in the list1");
        list1.deleteNode(new IntElement(120));
        System.out.println("Printing list3 contents to show node is deleted");
        list1.print();

        System.out.println("\nNow clearing list 1 and printing its contents");
        list1.clear();
        list1.print();


    }
}