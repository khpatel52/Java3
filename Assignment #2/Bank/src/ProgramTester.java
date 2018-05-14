public class ProgramTester{
    public static void main(String[] args){
        Bank boa = new Bank(10);
        //first account created is account 1
        boa.openAccount(1000);
        //second acount created is account 2
        boa.openAccount(92750);
        //displaying Account Summary
        boa.acctSummary(1);
        boa.acctSummary(2);
        //Making deposits of various amounts into various accounts
        boa.deposit(1, 500);
        boa.deposit(2, 2000);
        System.out.println("Account summaries after deposting money");

        boa.acctSummary(1);
        boa.acctSummary(2);

        boa.withdrawal(1,1500);
        boa.withdrawal(2,94750);
        System.out.println("Account summaries after withdrawing all money");

        boa.acctSummary(1);
        boa.acctSummary(2);
        System.out.println("Opening a new account with 990 balance with open"
                + "Account method");
        boa.openAccount(990);
        boa.acctSummary(3);

        System.out.println("Testing any privacy leaks in getAccount method");
        Account b = boa.getAccount(1);
        b.deposit(1000);
        boa.acctSummary(1);
        System.out.println(b);
        System.out.println("Since balances are different even after depositing "
                + "money in account b, there is no privacy leak. If there was "
                + "the balances would be the same");

        System.out.println("Tranferring existing account from outside the bank");
        Account c = new Account(987);
        boa.transferForeignAcct(c);
        boa.acctSummary(4);

        System.out.println("Closing an existing account");
        boa.closeAccount(4);
        boa.acctSummary(4);
        System.out.println("No output means that account 4 closed successfully");



    }
}