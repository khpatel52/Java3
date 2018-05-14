public interface IntLogInterface{

    void insert(int element);
    //Inserts an int into the array

    boolean isFull();
    //Returns true if the IntLog is full

    int size();

    boolean contains(int element);

    void clear();

    String getName();
    //Returns the name of the Integer log
    
    String toString();

}