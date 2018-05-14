import java.text.DecimalFormat;
public class TestClass{
    public static void main(String[] args){
        //creating an array of 59 intElements
        IntElement[] data = new IntElement[59];
        LinkedListClass list1 = new UnorderedLinkedList();
        DecimalFormat pattern = new DecimalFormat("00.00");
        //generating random values between 1 and 100 and inserting them into the
        //linked list        
        for(int i = 0; i < 59; i++){
            data[i] = new IntElement((int)(Math.random()*101));
            list1.insertFirst(data[i]);            
        }
        
        System.out.println("The size of the list is: " + list1.length());
        System.out.println("Checking if the list is empty");
        System.out.println("The list is empty: " + list1.isEmptyList());
        
        System.out.println("Printing the information in the nodes of the list");
        list1.print();//prints the entire linked list
        //Now computing the mean and standard deviation for the integers
        System.out.println("The mean is: " + pattern.format(list1.mean()));
        System.out.println("The standard deviation is: " +
                pattern.format(list1.getStdDev()));

        System.out.println("Now inserting a number in the end and beginning of "
                + "the list");
        list1.insertLast(new IntElement(23));
        list1.insertFirst(new IntElement(55));
        list1.print();
        System.out.println("Now returning reference of object that contains"
                + "info of the first node and printing that value");
        System.out.println(list1.front());
        System.out.println("Now returning reference of object that contains"
                + "info of the last node and printing that value");
        System.out.println(list1.back());
        System.out.println("Now checking if an IntElement object exists in "
                + "the list");
        DataElement s1 = new IntElement(23);
        DataElement s2 = new IntElement(55);
        DataElement s3 = new IntElement(0);
        System.out.println("Does s1 exist: " + list1.search(s1) + "\nDoes s2 "
                + "exist: " + list1.search(s2) + "\nDoes s3 exist: " +
                list1.search(s3));

        System.out.println("Now will create two sublists from original list");
        LinkedListClass sublist1 = new UnorderedLinkedList();
        LinkedListClass sublist2 = new UnorderedLinkedList();
        list1.splitMid(sublist1, sublist2);
        System.out.println("Sublist1:");
        sublist1.print();        
        System.out.println("Sublist1 size: " + sublist1.length());
        System.out.println("Sublist2:");
        sublist2.print();
        System.out.println("Sublist2 size: " + sublist2.length());

        System.out.println("Now testing the deleteNode method");
        System.out.println("Now will delete s1 from the sublist2");
        sublist2.deleteNode(s1);
        sublist2.print();
        System.out.println("s1 deleted successfully");
        DataElement s4 = new IntElement(100);
        System.out.println("Now will delete random element s4 from the "
                + "sublist2");
        if(sublist2.search(s4) == true){
        sublist2.deleteNode(s4);
        System.out.println("Delete successful.");
        sublist2.print();
        }
        else System.out.println("s4 not in list");        

    }
}