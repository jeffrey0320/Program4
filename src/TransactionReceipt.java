public class TransactionReceipt {
    private TransactionTicket ticket;
    private boolean successIndicatorFlag;
    private String reasonForFailureString;
    private double preTransactionBalance;
    private double postTransactionBalance;
    private String postTransactionMaturityDate;

    public TransactionReceipt(){
        ticket = new TransactionTicket();
        successIndicatorFlag = false;
        reasonForFailureString = "";
        preTransactionBalance = 0.0;
        postTransactionBalance = 0.0;
        postTransactionMaturityDate = "";
    }

    public TransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailureString,
                              double preTransactionBalance, double postTransactionBalance, String postTransactionMaturityDate) {
        this.ticket = ticket;
        this.successIndicatorFlag = successIndicatorFlag;
        this.reasonForFailureString = reasonForFailureString;
        this.preTransactionBalance = preTransactionBalance;
        this.postTransactionBalance = postTransactionBalance;
        this.postTransactionMaturityDate = postTransactionMaturityDate;
    }

    public TransactionTicket getTicket() {
        return ticket;
    }

    public boolean isSuccessIndicatorFlag() {
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

    public String getPostTransactionMaturityDate() {
        return postTransactionMaturityDate;
    }
}
