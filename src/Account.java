import java.util.ArrayList;
import java.util.Calendar;

public class Account {
    private Depositor PersonInfo;
    private int accountNumber;
    private String accountType;
    private boolean accountStatus;
    private double accountBalance;
    private ArrayList<TransactionReceipt> arrayOfReceipts;

    public Account() {
        PersonInfo = new Depositor();
        this.accountNumber = 0;
        this.accountType = "";
        this.accountStatus = false;
        this.accountBalance = 0;
        arrayOfReceipts = new ArrayList<>();
    }

    public Account(Depositor personInfo, int accountNumber, String accountType, boolean accountStatus, double accountBalance, ArrayList<TransactionReceipt> arrayOfReceipts) {
        PersonInfo = personInfo;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.arrayOfReceipts = arrayOfReceipts;
    }

    public Account(int parseInt, String token, double parseDouble, Depositor acctInfo) {
        this.accountNumber = parseInt;
        this.accountType = token;
        this.accountBalance = parseDouble;
        this.PersonInfo = acctInfo;
    }

    public TransactionReceipt getBalance(TransactionTicket ticketInfo, Bank obj, Account accInfo, int index){
        TransactionReceipt newRec = new TransactionReceipt();

        if(index == -1) {
            String reason = "Account not found. ";
            newRec = new TransactionReceipt(ticketInfo,false,reason);
            return newRec;
        }else{
            accInfo = obj.getAccts(index);
            double balance = accInfo.getAccountBalance();
            newRec = new TransactionReceipt(ticketInfo, true, balance);
            return  newRec;
        }
    }

    public TransactionReceipt makeDeposit(TransactionTicket ticketInfo, Bank obj, Account accInfo, int index){
        TransactionReceipt newRec = new TransactionReceipt();

        if(index == -1) {
            String reason = "Account not found. ";
            newRec = new TransactionReceipt(ticketInfo,false,reason);
            return newRec;
        }else{
            accInfo = obj.getAccts(index);
            double balance = accInfo.getAccountBalance();
            newRec = new TransactionReceipt(ticketInfo, true, balance);
            return  newRec;
        }
    }

    public TransactionReceipt makeWithdrawl(TransactionTicket ticketInfo, Bank obj, Account accInfo, int index){
        TransactionReceipt newRec = new TransactionReceipt();

        if(index == -1) {
            String reason = "Account not found. ";
            newRec = new TransactionReceipt(ticketInfo,false,reason);
            return newRec;
        }else{
            accInfo = obj.getAccts(index);
            double balance = accInfo.getAccountBalance();
            newRec = new TransactionReceipt(ticketInfo, true, balance);
            return  newRec;
        }
    }


    public Depositor getPersonInfo() {
        return PersonInfo;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
