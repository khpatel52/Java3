public class ProgramTester{
    public static void main(String[] args){
        //Create an array of type Data of size 10
        UnsortArray b = new UnsortArray(10);
        //Create 10 student objects
        b.insert(73,0,0);
        b.insert(54,0,0);
        b.insert(98,0,0);
        b.insert(43,0,0);
        b.insert(68,0,0);
        b.insert(91,0,0);
        b.insert(87,0,0);
        b.insert(75,0,0);
        b.insert(84,0,0);
        b.insert(69,0,0);
        //list the scores of the students
        for(int i = 1; i <= 10; i++) b.details(i);
        System.out.println();
        //Update the scores of test 2
        b.update(1, new Data(73,84,0));
        b.update(2, new Data(54,77,0));
        b.update(3, new Data(98,83,0));
        b.update(4, new Data(43,52,0));
        b.update(5, new Data(68,74,0));
        b.update(6, new Data(91,96,0));
        b.update(7, new Data(87,84,0));
        b.update(8, new Data(75,61,0));
        b.update(9, new Data(84,76,0));
        b.update(10, new Data(69,57,0));
        //list the student scores
        for(int i = 1; i <= 10; i++) b.details(i);
        System.out.println();
        //update the scores of test 3
        b.update(1, new Data(73,84,77));
        b.update(2, new Data(54,77,66));
        b.update(3, new Data(98,83,55));
        b.update(4, new Data(43,52,72));
        b.update(5, new Data(68,74,81));
        b.update(6, new Data(91,96,96));
        b.update(7, new Data(87,84,81));
        b.update(8, new Data(75,61,65));
        b.update(9, new Data(84,76,79));
        b.update(10, new Data(69,57,60));
        //list the student scores
        for(int i = 1; i <= 10; i++) b.details(i);
        System.out.println();
        //list the scores with averages and grades
        for(int i = 1; i <= 10; i++){
            b.details(i,0);
        }
        System.out.println("\nTesting the fetch method for first 3 students");
        System.out.println(b.fetch(1));
        System.out.println(b.fetch(2));
        System.out.println(b.fetch(3));
        System.out.println("\nTesting the delete method for first 3 students");
        System.out.println(b.delete(1));
        System.out.println(b.delete(2));
        System.out.println(b.delete(3));
        System.out.println("\nList of students after deleting first 3");
        b.arrayDetails();
    }
}