import java.util.Calendar;

public class TransactionReceipt {
    private TransactionTicket ticket;
    private boolean successIndicatorFlag;
    private String reasonForFailureString;
    private double preTransactionBalance;
    private double postTransactionBalance;
    private Calendar postTransactionMaturityDate;

    public TransactionReceipt(){
        ticket = new TransactionTicket();
        successIndicatorFlag = false;
        reasonForFailureString = "";
        preTransactionBalance = 0.0;
        postTransactionBalance = 0.0;
        postTransactionMaturityDate = Calendar.getInstance();
    }

    public TransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailureString,
                              double preTransactionBalance, double postTransactionBalance, Calendar postTransactionMaturityDate) {
        this.ticket = ticket;
        this.successIndicatorFlag = successIndicatorFlag;
        this.reasonForFailureString = reasonForFailureString;
        this.preTransactionBalance = preTransactionBalance;
        this.postTransactionBalance = postTransactionBalance;
        this.postTransactionMaturityDate = postTransactionMaturityDate;
    }

    public TransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailureString) {
        this.ticket = ticket;
        this.successIndicatorFlag = successIndicatorFlag;
        this.reasonForFailureString = reasonForFailureString;
    }

    public TransactionReceipt(TransactionTicket info,boolean flag,double balance) {
        ticket = info;
        successIndicatorFlag = flag;
        preTransactionBalance = balance;
        postTransactionBalance = balance;
    }

    public TransactionReceipt(TransactionTicket info,boolean flag,String reason, double balance) {
        ticket = info;
        successIndicatorFlag = flag;
        reasonForFailureString = reason;
        preTransactionBalance = balance;
        postTransactionBalance = balance;
    }

    public TransactionReceipt(TransactionTicket ticketInfo, boolean b, double accountBalance, double newBalance, Calendar newMatDate) {
        ticket = ticketInfo;
        successIndicatorFlag = b;
        preTransactionBalance = accountBalance;
        postTransactionBalance = newBalance;
        postTransactionMaturityDate = newMatDate;
    }

    public TransactionReceipt(TransactionTicket ticketInfo, boolean b, double accountBalance, double newBalance) {
        ticket = ticketInfo;
        successIndicatorFlag = b;
        preTransactionBalance = accountBalance;
        postTransactionBalance = newBalance;
    }

    public TransactionReceipt(TransactionTicket info, boolean b, String reason, double balance, double newBal) {
        ticket = info;
        successIndicatorFlag = b;
        reasonForFailureString = reason;
        preTransactionBalance = balance;
        postTransactionBalance = newBal;
    }

    public TransactionReceipt(TransactionTicket ticket, boolean b) {
        this.ticket = ticket;
        successIndicatorFlag = b;
    }

    public TransactionTicket getTicket() {
        return ticket;
    }

    public boolean getSuccessIndicatorFlag() {
        return successIndicatorFlag;
    }

    public String getReasonForFailureString() {
        return reasonForFailureString;
    }

    public double getPreTransactionBalance() {
        return preTransactionBalance;
    }

    public double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public Calendar getPostTransactionMaturityDate() {
        return postTransactionMaturityDate;
    }
}
