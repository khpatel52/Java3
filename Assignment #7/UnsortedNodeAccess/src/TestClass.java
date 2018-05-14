public class TestClass{
    public static void main(String[] args){
        ArrayListClass randomList = new UnorderedArrayList(100);
        for(int i = 0; i < 100; i++){
            int x = (int)(Math.random()*101);
            DataElement temp = new IntElement(x);
            randomList.insertDup(temp);            
            //System.out.println(x);
            //Printing number is rows of 10
            if(i != 0 && i%10 == 0)
                System.out.println();
            System.out.print(x + " ");
        }
            
        
        System.out.println("\n\nThe smallest value is: " +
                ((UnorderedArrayList)randomList).min());
        System.out.println("The largest value is: " +
                ((UnorderedArrayList)randomList).max());
        System.out.println("The sum of all values is: " +
                ((UnorderedArrayList)randomList).sum());
        System.out.println("The average value is: " + 
                ((UnorderedArrayList)randomList).average());
        System.out.println("The number of scores within 1 standard deviation"
                + " are: " + ((UnorderedArrayList)randomList).getStdDev());
        System.out.println("This is different from a normal distribution since"
                + " 68% of scores or " +
                (.68*((UnorderedArrayList)randomList).listSize()) +
                " scores are within 1 standard deviation");
        
    }
}

//public boolean insertDup(DataElement insertItem