import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> arrayOfAccounts;

    public Bank(){
        arrayOfAccounts = new ArrayList<>();
    }

    public void openNewAccount(Account customerInfo){
        arrayOfAccounts.add(customerInfo);
    }

    public TransactionReceipt openNewAccount(TransactionTicket ticket, Bank obj, String[] customerInfo, int acctNum){
        TransactionReceipt openRec = new TransactionReceipt();

        boolean isEmpty = false;
        for(int i=0;i<customerInfo.length-1;i++){
            if(customerInfo[i].isEmpty()) {
                isEmpty = true;
                break;
            }
        }
        if(isEmpty){
            String reason = "Missing information";
            openRec = new TransactionReceipt(ticket,false,reason);
            return openRec;
        }else{
            Account newAcct = new Account(customerInfo[0],customerInfo[1],customerInfo[2],customerInfo[3],acctNum);
            arrayOfAccounts.add(newAcct);
            openRec = new TransactionReceipt(ticket,true,0);
            return openRec;
        }
    }

    public TransactionReceipt deleteAccount(TransactionTicket ticket, Bank bankObj, int index, int delAccount){
        TransactionReceipt delAcct = new TransactionReceipt();
        String reason;

        if(bankObj.getAccts(index).getAccountBalance()<0){
            reason = "Account has a negative balance and cannot be deleted.";
            delAcct = new TransactionReceipt(ticket,false,reason);
            return delAcct;
        }else if(bankObj.getAccts(index).getAccountBalance()>0){
            reason = "Account has a balance, Withdraw your balance and try again.";
            delAcct = new TransactionReceipt(ticket,false,reason);
            return delAcct;
        }else {
            arrayOfAccounts.remove(index);
            delAcct = new TransactionReceipt(ticket,true);
            return delAcct;
        }
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
        return arrayOfAccounts.size();
    }

}
