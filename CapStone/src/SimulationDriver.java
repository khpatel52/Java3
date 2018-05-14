
import java.util.Scanner;
public class SimulationDriver{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //Creating a waiting queue to accomodate customers
        WaitingQueue queue = new WaitingQueue();
        //Taking input from user
        System.out.println("Please enter the simulation time: ");
        int simTime = in.nextInt();
        System.out.println("Please enter the arrival probability: ");
        double arrivProb = in.nextDouble();
        System.out.println("Please enter the number of servers: ");
        int numOfServers = in.nextInt();
        System.out.println("Please enter the transaction time: ");
        int transactionTime = in.nextInt();
        int happyCustomers = 0;//customers who have/are being served. To be used
                                //in loop
        //creating a list of servers to accomodate servers
        ServerList servers = new ServerList(numOfServers);
        //initialize a given number of servers based on user input
        servers.openServers();

        //Simulation loop where the variables are updated
        for(int i =1; i < simTime+1; i++){            
            //now updating busy servers since they are the ones with the customers
            for(int j = 0; j < numOfServers; j++){
                //if server is busy
                if(servers.serverStatus(j) == false){
                    //updating increments transaction time for server. Clock
                    //time i and trans time passed in to displays detailed
                    //summary result
                    servers.sList[j].update(i,transactionTime);
                }
            }
            //now updating customer wait queue. This methods call other methods
            //which will increment waiting times for customer objects
            queue.update();
            //if customer arrived
            if(Customer.customerArrived(arrivProb) == true){
                Customer newCust = new Customer(i,0,transactionTime);
                //add new customer to the queue of customers
                queue.getsInLine(newCust);
                System.out.println("Customer number " +
                        newCust.getCustomerNumber() + " arrived at time unit "
                        + i);
            }
            if(!queue.isEmptyList()){//to make sure queue has atleast 1 customer
                if(servers.checkFreeServer()){//if free servers available
                    queue.goesToCounter(servers);//removes customer from queue
                                                 //and adds to free server
                    happyCustomers++;//increment no. of customers served
                }
            }
            
        }
        //Displaying summary results
        System.out.println("\nSummary:\n");
        System.out.println("Simulation time ran for " + simTime+ " time units");
        System.out.println("Number of servers " + numOfServers);
        System.out.println("Total number of customers: " + queue.totalCustomers());
        System.out.println("Average transaction time: " + transactionTime);
        System.out.println("Arrival probability for Customer: "
                + arrivProb);
        System.out.println("Total wait time: " + queue.totalWaitTime());
        System.out.println("Number of customers who completed a transaction: "
                + happyCustomers);
        System.out.println("Number of customers left in the servers: " +
                (happyCustomers-servers.getLeftServers()));
        System.out.println("Number of customers left in the queue: " +
                queue.size());
        System.out.println("Average wait time: " +
                Math.round((double)queue.totalWaitTime()/queue.totalCustomers()));
        

        
    }

}