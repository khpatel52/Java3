
public class ServerList{
    protected Server[] sList;//a list of servers in the coffee shop
    private int cnt;//number of servers
    
    public ServerList(){
        sList = new Server[5];//a maximum of 5 servers in the coffee shop
        cnt = 0;
    }
    public ServerList(int servers){
        sList = new Server[servers];
        cnt = servers;
    }
    //opens up the servers to serve customers
    public void openServers(){
            for(int i = 0; i < cnt; i++){
               sList[i] = new Server();                             
            }        
    }
    //server is free if true. False if busy
    public boolean serverStatus(int x){
        String y = sList[x].getStatus();
        if(y.equalsIgnoreCase("free"))
            return true;
        else if(y.equalsIgnoreCase("busy"))
            return false;
        else
            throw new QueueException("Servers must be either free or empty");
    }
    //determines the number of servers who are busy
    public int serversBusy(){
        int x = 0;
        for(int i = 0; i < sList.length; i++){
            if(serverStatus(i) == false) x++;
        }
        return x;
    }
    //checks if a free server is available
    public boolean checkFreeServer(){        
        if(freeServer() > -1) return true;
        else return false;
    }
    //determines and returns the number of the free server
    public int freeServer(){
        int x = -1;
        boolean found = false;//used to exit the loop when server is found
        for(int i = 0; i < sList.length && !found; i++){
            if(serverStatus(i) == true) {
                x = i;
                found = true;
            }
        }
        return x;
    }
    //set server to busy when service begins
    public void setBusy(int x, String stat, Customer element){
        sList[x].updateStatus(element, stat);
    }
    //set server to free when service is completed
    public void setFree(int x, String stat, Customer element){
        sList[x].updateStatus(element, stat);
    }
    //returns number of people who left the servers and shop
    public static int getLeftServers(){
        return Server.getLeftServers();
    }
}