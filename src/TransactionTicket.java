public class TransactionTicket {
    private String dateOfTransaction;
    private String typeOfTransaction;
    private double amountOfTransaction;
    private int termOfCD;

    public TransactionTicket(){
        dateOfTransaction = "";
        typeOfTransaction = "";
        amountOfTransaction = 0.0;
        termOfCD = 0;
    }

    public TransactionTicket(String dateOfTransaction, String typeOfTransaction, double amountOfTransaction, int termOfCD) {
        this.dateOfTransaction = dateOfTransaction;
        this.typeOfTransaction = typeOfTransaction;
        this.amountOfTransaction = amountOfTransaction;
        this.termOfCD = termOfCD;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public double getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public int getTermOfCD() {
        return termOfCD;
    }
}
