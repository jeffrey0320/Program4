import java.util.Calendar;

public class TransactionTicket {
    private Calendar dateOfTransaction;
    private String typeOfTransaction;
    private double amountOfTransaction;
    private int termOfCD;

    public TransactionTicket(){
        dateOfTransaction = Calendar.getInstance();
        typeOfTransaction = "";
        amountOfTransaction = 0.0;
        termOfCD = 0;
    }

    public TransactionTicket(Calendar dateOfTransaction, String typeOfTransaction, double amountOfTransaction, int termOfCD) {
        this.dateOfTransaction = dateOfTransaction;
        this.typeOfTransaction = typeOfTransaction;
        this.amountOfTransaction = amountOfTransaction;
        this.termOfCD = termOfCD;
    }

    public TransactionTicket(Calendar currentDate, String type) {
        dateOfTransaction = currentDate;
        typeOfTransaction = type;
    }

    public Calendar getDateOfTransaction() {
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
