public class TestClass{
    public static void main(String[] args){
        System.out.println("Part 1 - Now creating a linked queue and inserting "
                + "5 elements and printing the queue");
        LinkedUnbndQueue queue = new LinkedUnbndQueue();
        queue.enqueue(new IntElement(2));
        queue.enqueue(new IntElement(4));
        queue.enqueue(new IntElement(6));
        queue.enqueue(new IntElement(8));
        queue.enqueue(new IntElement(10));
        queue.print();
        System.out.println("Now using dequeue method and printing results");
        queue.dequeue();
        queue.print();
        System.out.println("Now using dequeue method again "
                + "and printing results");
        queue.dequeue();
        queue.print();

        System.out.println("Part 2 of the program in which the existing "
                + "linked list class will be used for the enqueue and "
                + "dequeue methods");
        ExistingLinkedQueue obj = new ExistingLinkedQueue();
        System.out.println("Now adding 5 IntElement objects with enqueue");
        obj.enqueue(new IntElement(22));
        obj.enqueue(new IntElement(43));
        obj.enqueue(new IntElement(64));
        obj.enqueue(new IntElement(87));
        obj.enqueue(new IntElement(108));
        obj.print();
        System.out.println("Now deleting 2 IntElement objects with dequeue");
        obj.dequeue();
        obj.dequeue();
        obj.print();

        System.out.println("Part 3 - Encoding and decoding a message");
        Encryption coding = new Encryption();
        System.out.println("The original message is: " + coding.message);
        System.out.println("The encoded message is: " + coding.encoding());
        System.out.println("The decoded message is: " + coding.decoding());




    }
}