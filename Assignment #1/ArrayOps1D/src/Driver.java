import java.io.*;
public class Driver {
    public static void main(String[] args){
        
        ArrayOps1D.computation();
        System.out.println();
        System.out.println("The average score is: "
                + ArrayOps1D.getAverage(ArrayOps1D.intArray));
        System.out.println("The highest score is: "
                + ArrayOps1D.getHighest(ArrayOps1D.intArray));
        System.out.println("The lowest score is: "
                + ArrayOps1D.getLowest(ArrayOps1D.intArray));
        System.out.println("The median score is: "
                + ArrayOps1D.getMedian(ArrayOps1D.intArray));
        System.out.println("The position of the score 68 is: "
                + ArrayOps1D.getPosition(ArrayOps1D.intArray,68));
        System.out.println("The position of the score 77 is: "
                + ArrayOps1D.getPosition(ArrayOps1D.intArray,77));
        System.out.println("The position of the score 99 is: "
                + ArrayOps1D.getPosition(ArrayOps1D.intArray,99));
        double[] devArray = ArrayOps1D.getDeviations(ArrayOps1D.intArray);
        System.out.println("The number of score within 1 standard deviation"
                + " are: " + ArrayOps1D.withinDeviation(ArrayOps1D.intArray));
        System.out.println("This is different from a normal distribution since"
                + " 68% of scores or " + (.68*ArrayOps1D.intArray.length) +
                " scores in normal distribution are within 1 standard deviation");

        try{
        PrintWriter output = new PrintWriter(new FileOutputStream("deviations.txt"));
        for(double element:devArray)
            output.println(element);
        output.close();

        }
        catch(FileNotFoundException e){
                System.out.println("Could not find file!");
        }

        System.out.println("The standard deviation is: "
                + ArrayOps1D.getStdDev(ArrayOps1D.intArray)); 
        
      


    }
}
