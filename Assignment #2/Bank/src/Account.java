public class Account{
    private double balance;
    private int id;
    private static int nextID = 0;

    private static int getNextID()
    {
        return ++nextID;
    }
        
    public Account(double n){
        id = getNextID();
        if(n>=0)balance = n;
        else balance = 0;
    }
    //copy constructor
    public Account(Account a){
        this.id = a.id;
        this.balance = a.balance;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int n){
        id = 0;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double n){
        balance = n;
    }

    public void deposit(double n){
        balance += n;
    }

    public void withdrawal(double n){
        balance -= n;
    }

    public void destroy(){
        id = 0;
        balance = 0;
    }

    public String toString(){
        return "Account Summary is: ID: " + id + " Balance: $" +
                balance;
    }
}