public class Check {
    private int accountNumber;
    private double checkAmount;
    private String dateOfCheck;

    public Check(){
        accountNumber = 0;
        checkAmount = 0.0;
        dateOfCheck = "";
    }

    public Check(int accountNumber, double checkAmount, String dateOfCheck) {
        this.accountNumber = accountNumber;
        this.checkAmount = checkAmount;
        this.dateOfCheck = dateOfCheck;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getCheckAmount() {
        return checkAmount;
    }

    public String getDateOfCheck() {
        return dateOfCheck;
    }
}
