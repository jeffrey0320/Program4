import java.util.ArrayList;

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
