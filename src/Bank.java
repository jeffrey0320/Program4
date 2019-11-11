import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> arrayOfAccounts;

    public Bank(){
        arrayOfAccounts = new ArrayList<>();
    }

    public TransactionReceipt openNewAccount(TransactionTicket newTicket, Account customerInfo){
        TransactionReceipt receiptObj = new TransactionReceipt();
        arrayOfAccounts.add(customerInfo);
        return receiptObj;
    }

    public TransactionReceipt deleteAccount(){
        return null;
    }

    public int findAcct(int reqAccount){
        for (int index = 0; index < arrayOfAccounts.size(); index++)
            if (arrayOfAccounts.get(index).getAccountNumber() == reqAccount)
                return index;
        return -1;
    }

    public Account getAccts(int index){
        return arrayOfAccounts.get(index);
    }

    public int getNumAccts(){
        return 0;
    }

}
