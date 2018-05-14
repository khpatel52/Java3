import java.util.Random;
public class TestLuck {
    
    public static void main(String[] args){
        boolean x = false;
        int counter = 0;
        String y;
        double average = 0;
        int[] randoms = new int[100];
        double sum = 0;
        int min = 0;
        int max = 10000;

        ArrayIntLog test = new ArrayIntLog("Testing", 10000);
                
        while(counter < 100){
        for(int i = 0; i < 10000 && x != true; i++){
            int num = min + (int)(Math.random() * ((max - min) + 1));
            if(test.contains(num) == true){
                y = "It took " + (i+1) + " times for duplicate";
                test.clear();//so that next iteration of while loop can take place
                System.out.println(y);
                x = true;
                randoms[counter] = i+1;//stores result of duplicate times
            }
            else test.insert(num);//only inserts if there are no duplicates

        }
        x = false;
        counter++;
}
        for(int element: randoms){
            sum = sum + element;
            average = sum/100;            
        }
        System.out.println("\nThe average value is: " + average);
    }
}
