
public class Server{
    private Customer currentCustomer;//customer that is currently served
    private String status;//free or busy serving the customer
    private int transactionTime;//remaining to complete the service
    //private int currentTime;//current moment of time    
    private int serverNumber;//server id
    private static int num;//server number
    private static int leftServers;//people who left the server and the shop

    public static int number(){
        num++;
        return num;
    }
    
    public Server(){
        currentCustomer = null;
        status = "free";
        transactionTime = 0;
        serverNumber = number();
    }
    public Server(Customer cCustomer, String stat){
        currentCustomer = cCustomer.getCopy();
        status = stat;
        transactionTime = 0;
        serverNumber = number();
    }
    public int getTime(){
        return transactionTime;
    }
    public String getStatus(){
        return status;        
    }
    //total numbers of customers who were served by the servers
    public static int getLeftServers(){
        return leftServers;
    }
    //update transaction time for servers and update if customer is served or not
    public void update(int clock, int trans){        
        transactionTime++;
        if(transactionTime == trans){
            System.out.println("Server No: " + serverNumber + " Customer"
                    + " number " + currentCustomer + " departed at clock"
                    + " unit " + clock);
            currentCustomer = null;//customer is served after 4 minutes
            status = "free";
            transactionTime = 0;//resets time since customer is served
            leftServers++;
        }
    }
    //update certains aspects of servers
    public void updateStatus(Customer cCustomer, String stat){
        Customer x = cCustomer.getCopy();
        currentCustomer = x;//serving this customer
        status = stat;
    }
    
}