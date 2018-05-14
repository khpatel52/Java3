public class Bank{
    private Account[] a;
    private int cnt;
    
    public Bank(){
        this(0);
    }
    //constructor creates an array of account objects. Constraint 1.
    public Bank(int n){
        if(n<0) n=10;
        a = new Account[n];
        cnt = 0;
    }
   //opens a new account in the bank ,ie, account object created in bank.
    //Constraint 1
    public boolean openAccount(double amt){
        boolean x = false;
        if(cnt < a.length)
            for(int i = 0; i < a.length && !x; i++)
                if(a[i] == null){
                    a[i] = new Account(amt);
                    cnt++;
                    x = true;
                }
        return x;
    }
    //closes an account by calling the destroy method in account
   public boolean closeAccount(int id){
        boolean x = false;
             for(int i = 0; i < a.length && !x; i++)
                if(a[i] != null)
                    if(a[i].getId() == id){
                        a[i].destroy();
                        cnt--;
                        x = true;
                    }
        return x;
    }
    //returns a reference to a copy of the account object. Constraint 2 which is
   //a reference to copy of account object is returned
    public Account getAccount(int n){
        if(cnt == 0) return null;
        for(int i = 0; i < a.length; i++)
            if(a[i] != null)
                if(a[i].getId() == n)
                    return new Account(a[i]);
        return null;
    }
    //Deposits money into an account by increasing the balance amount
    public void deposit(int n, double amount){
        for(int i = 0; i < a.length; i++){
            if(a[i] != null)
                if(a[i].getId() == n){
                    a[i].deposit(amount);
        }
       }
      }
    //Withdraws money from an account by reducing the balance amount
    public void withdrawal(int n, double amount){
        for(int i = 0; i < a.length; i++){
            if(a[i] !=null)
                if(a[i].getId() == n){
                    a[i].withdrawal(amount);
        }
            }
    }
    //Displays the summary of an account
    public void acctSummary(int n){
        for(int i = 0; i < a.length; i++){
            if(a[i] != null)
                if(a[i].getId() == n){
                    System.out.println(a[i].toString());
            }
        }

    }
    //transfer outside account to the bank. Constraint 3 since parameter is of
    //account type. Copy of x is made in z and z is used as internal reference.
    public void transferForeignAcct(Account x){
        Account z = new Account(x);
        boolean y = false;
        if(x != null){
            for(int i = 0; i < a.length && !y; i++)
                if(a[i] == null){
                    a[i] = new Account(z);
                    y = true;
                }

        }
    }
}