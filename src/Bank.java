import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> arrayOfAccounts;

    public Bank(){
        arrayOfAccounts = new ArrayList<>();
    }

    public TransactionReceipt openNewAccount(){
        return null;
    }

    public TransactionReceipt deleteAccount(){
        return null;
    }

    public int findAcct(){
        return 0;
    }

    public Account getAccts(int index){
        return arrayOfAccounts.get(index);
    }

    public int getNumAccts(){
        return 0;
    }

}
