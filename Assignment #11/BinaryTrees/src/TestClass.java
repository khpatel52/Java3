public class TestClass{
    public static void main(String[] args){
        BinaryTree structure = new BinaryTree();
        DataElement obj1 = new IntElement(4);
        DataElement obj2 = new IntElement(2);
        DataElement obj3 = new IntElement(3);
        DataElement obj4 = new IntElement(7);
        //DataElement obj5 = new IntElement(8);
        //DataElement obj6 = new IntElement(9);
        //DataElement obj7 = new IntElement(15);
        //DataElement obj8 = new IntElement(5);
        structure.insert(obj1);
        structure.insert(obj2);
        structure.insert(obj3);
        structure.insert(obj4);
        structure.printTreeStructure();
    }
}