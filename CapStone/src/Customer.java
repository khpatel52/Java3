
public class Customer{    
    private int customerNumber;
    private int arrivalTime;
    private int waitingTime;//in line to be served
    private int transactionTime;//at the counter while being served
    private static int num;//customer number
    private static int totalWaitTime;

    //method that returns a customer number/ticket number
    public static int number(){
        num++;
        return num;
    }
    
    public Customer(){
        customerNumber = number();
        arrivalTime = 0;
        waitingTime = 0;
        transactionTime = 0;        
    }
    public Customer(int aTime, int wTime, int tTime){
        customerNumber = number();
        arrivalTime = aTime;
        waitingTime = wTime;
        transactionTime = tTime;        
    }
    //copy constructor
    public Customer(Customer x){
        customerNumber = x.customerNumber;
        arrivalTime = x.arrivalTime;
        waitingTime = x.waitingTime;
        transactionTime = x.transactionTime;
    }
    public Customer getCopy(){
        Customer element = new Customer(this.arrivalTime,
                this.waitingTime, this.transactionTime);
        element.customerNumber = this.customerNumber;
        num--;//decrement num by 1 since creation of customer copy increments num
        return element;
    }
    //method to update variables
    public void update(int aTime, int wTime, int tTime){
        arrivalTime = aTime;
        waitingTime = wTime;
        transactionTime = tTime; 
    }
    public int getCustomerNumber(){
        return customerNumber;
    }
    public void updateWaitTime(){
        waitingTime++;
        totalWaitTime++;
    }
    public int getWaitingTime(){
        return waitingTime;
    }
    //returns the total wait time of all customers
    public static int getTotalWaitTime(){
        return totalWaitTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getTransactionTime(){
        return transactionTime;
    }
    //returns the total number of customers who entered the shop
    public static int getTotalCustomers(){
        return num;
    }
    public String toString(){
        return "Customer number " + customerNumber + " arrived at time unit " +
                arrivalTime + " waited for " + waitingTime;                
    }
    //the arrival probability model for determining customer arrival
    public static boolean customerArrived(double arrivalProbability){
        return (Math.random() < arrivalProbability);
    }
}