import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;


public class ArrayOps1D{
    static int intArray[];
    static int array2[];
    
    public static void computation(){
        File name = new File("Scores.txt");
        BufferedReader fin;
        String line;
        
        try{
        fin = new BufferedReader(new FileReader(name));
        line = fin.readLine();
        String[] cols = line.split(" ");
        fin.close();
        int aSize = cols.length;
        intArray = new int[aSize];
        
        for(int i = 0; i < aSize; i++){
            intArray[i] = Integer.parseInt(cols[i]);
            }
        for(int i = 0; i < aSize; i++){
            if(i != 0 && i%4 == 0)
                System.out.println();
            System.out.print(intArray[i] + " ");
        }
        //another array created for the purpose of sorting
        array2 = new int[intArray.length];
        for(int i = 0; i < intArray.length; i++)
            array2[i] = intArray[i];

         // A for loop that sorts the array
        for(int i = 0; i < array2.length-1; i++){
            for(int j = i+1; j < array2.length; j++){
                if(array2[j] < array2[i]){
                    int min = array2[j];
                    array2[j] = array2[i];
                    array2[i] = min;
        }
            }
            }
       
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening the file");
            System.exit(0);
        }
        catch(IOException e){
            System.out.println("Error reading from Scores.txt.");
            System.exit(0);
        }
    }
    
    public static double getTotal(int array[]){
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }        
        return sum;
    }

    public static double getAverage(int array[]){
        double average = getTotal(array)/array.length;
        return average;
    }

    public static double getHighest(int array[]){
        return array2[array2.length-1];
    }

    public static double getLowest(int array[]){
        return array2[0];
    }

    public static double getMedian(int array[]){
        
        int middle = array2.length/2;
        return ((array2[middle] + array2[middle+1])/2);
    }

    public static int getPosition(int array[], int value){
        int position = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == value)
                position = i;
        }
        return position;
    }
    //returns an array of the deviations
    public static double[] getDeviations(int array[]){
        double[] dArray = new double[array.length];
        double mean = getAverage(array);
        for(int i = 0; i < array.length; i++){
            dArray[i] = array[i] - mean;
        }
        return dArray;
    }
    //returns the value of the standard deviation
    public static double getStdDev(int array[]){
        double[] dArray = getDeviations(array);
        for(int i = 0; i < array.length; i++){
            dArray[i] = Math.pow(dArray[i],2);
        }
        double sum = 0;
        for(double element:dArray){
            sum += element;
        }
        sum /= (array.length-1);
        return Math.sqrt(sum);
    }
    //challenge question 5
    public static double withinDeviation(int array[]){
        double n = 0;
        for(int element: array){
            if(element>=(getAverage(array))-getStdDev(array)
                    && element<=(getAverage(array))+getStdDev(array)){
                n++;
            }
        }
        return n;

    }
}
