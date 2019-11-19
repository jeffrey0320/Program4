import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public Account(int parseInt, String token, double parseDouble, Depositor acctInfo, boolean accountStatus) {
        this.accountNumber = parseInt;
        this.accountType = token;
        this.accountBalance = parseDouble;
        this.PersonInfo = acctInfo;
        this.accountStatus = accountStatus;
    }

    public Account(String f, String l, String s, String t, int acctNum) {
        accountType = t;
        PersonInfo = new Depositor(s,f,l);
        accountNumber = acctNum;
    }

    public TransactionReceipt getBalance(TransactionTicket ticketInfo, Bank obj, int index){
        TransactionReceipt newRec;
        Account accInfo = obj.getAccts(index);

        if(index == -1) {
            String reason = "Account not found. ";
            newRec = new TransactionReceipt(ticketInfo,false,reason);
            return newRec;
        }else{
           if(accInfo.getAccountStatus()){
               double balance = accInfo.getAccountBalance();
               newRec = new TransactionReceipt(ticketInfo, true, balance);
               return  newRec;
           }else{
               String reason = "Account is closed.";
               newRec = new TransactionReceipt(ticketInfo,false,reason);
               return newRec;
           }
        }
    }

    public TransactionReceipt makeDeposit(TransactionTicket ticketInfo, Bank obj, int index){
        TransactionReceipt newRec = new TransactionReceipt();
        Account accInfo = new Account();
        accInfo = obj.getAccts(index);

       if(accInfo.getAccountStatus()){
           if(ticketInfo.getAmountOfTransaction() <= 0.00){
               String reason = "Invalid amount.";
               newRec = new TransactionReceipt(ticketInfo,false,reason);
               accInfo.arrayOfReceipts.add(newRec);
               return  newRec;
           }else{
               double balance = accInfo.getAccountBalance();
               double newBalance = balance + ticketInfo.getAmountOfTransaction();
               newRec = new TransactionReceipt(ticketInfo,true,balance,newBalance);
               accInfo.setAccountBalance(newBalance);
               arrayOfReceipts.add(newRec);
               return newRec;
           }
       }else{
           String reason = "Account is closed.";
           newRec = new TransactionReceipt(ticketInfo,false,reason);
           return newRec;
       }
    }

    public TransactionReceipt makeDepositCD(TransactionTicket ticket,Bank ob,int inde,String matDate) throws ParseException {
        TransactionReceipt cdRec = new TransactionReceipt();
        Calendar timeNow = Calendar.getInstance();
        Calendar newDate = Calendar.getInstance();
        Account accInfo = new Account();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date oDate = sdf.parse(matDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(oDate);

       if(accInfo.getAccountStatus()){
           if(cal.before(timeNow) || cal.equals(timeNow)){
               if(ticket.getAmountOfTransaction() <= 0.00){
                   String reason = "Invalid amount.";
                   cdRec = new TransactionReceipt(ticket,false,reason);
                   return  cdRec;
               }else{
                   accInfo = ob.getAccts(inde);
                   accountBalance = accInfo.getAccountBalance();
                   double newBalance = accountBalance + ticket.getAmountOfTransaction();
                   newDate.add(Calendar.MONTH,ticket.getTermOfCD());
                   cdRec = new TransactionReceipt(ticket,true,accountBalance,newBalance,newDate);
                   accInfo.setAccountBalance(newBalance);
                   return cdRec;
               }
           }else{
               String reason = "Term has not ended.";
               cdRec = new TransactionReceipt(ticket,false,reason);
               return cdRec;
           }
       }else{
           String reason = "Account is closed.";
           cdRec = new TransactionReceipt(ticket,false,reason);
           return cdRec;
       }
    }

    public TransactionReceipt makeWithdrawal(TransactionTicket ticketInfo, Bank obj, int index){
        TransactionReceipt newRec;
        Account bal = obj.getAccts(index);
        double balance = bal.getAccountBalance();

        if(bal.getAccountStatus()){
            if(ticketInfo.getAmountOfTransaction() <= 0.0) {
                String reason = "Trying to withdraw invalid amount.";
                newRec = new TransactionReceipt(ticketInfo,false,reason,balance);
                return newRec;

            }
            else if(ticketInfo.getAmountOfTransaction() > balance) {
                String reason = "Balance has insufficient funds.";
                newRec = new TransactionReceipt(ticketInfo,false,reason,balance);
                return newRec;
            }
            else {
                double newBal = balance - ticketInfo.getAmountOfTransaction();
                newRec = new TransactionReceipt(ticketInfo,true,balance,newBal);
                bal.setAccountBalance(newBal);
                return newRec;
            }
        }else{
            String reason = "Account is closed.";
            newRec = new TransactionReceipt(ticketInfo,false,reason);
            return newRec;
        }
    }

    public TransactionReceipt makeWithdrawalCD(TransactionTicket ticket, Bank obj, int index, String openDate) throws ParseException {
        TransactionReceipt cdRec;
        Calendar timeNow = Calendar.getInstance();
        Calendar newDate = Calendar.getInstance();
        Account accInfo;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date oDate = sdf.parse(openDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(oDate);

        accInfo = obj.getAccts(index);
        double balance = accInfo.getAccountBalance();

       if(accInfo.getAccountStatus()){
           if(cal.before(timeNow) || cal.equals(timeNow)){
               if(ticket.getAmountOfTransaction() <= 0.00){
                   String reason = "Invalid amount.";
                   cdRec = new TransactionReceipt(ticket,false,reason);
                   return  cdRec;
               }else if(ticket.getAmountOfTransaction() > balance)
               {
                   String reason = "Balance has insufficient funds.";
                   cdRec = new TransactionReceipt(ticket,false,reason,balance);
                   return cdRec;
               }else{
                   double newBalance = accountBalance - ticket.getAmountOfTransaction();
                   newDate.add(Calendar.MONTH,ticket.getTermOfCD());
                   cdRec = new TransactionReceipt(ticket,true,accountBalance,newBalance,newDate);
                   accInfo.setAccountBalance(newBalance);
                   return cdRec;
               }
           }else{
               String reason = "Term has not ended.";
               cdRec = new TransactionReceipt(ticket,false,reason);
               return cdRec;
           }
       }else{
           String reason = "Account is closed.";
           cdRec = new TransactionReceipt(ticket,false,reason);
           return cdRec;
       }
    }

    public TransactionReceipt clearCheck(Check checkInfo, TransactionTicket info, Bank acc, int index){
        TransactionReceipt clearedCheck = new TransactionReceipt();
        Account bal = new Account();

        Calendar timeNow = Calendar.getInstance();
        Calendar beforeSixMonths = Calendar.getInstance();
        beforeSixMonths.add(Calendar.MONTH, -6);
        Calendar check = checkInfo.getDateOfCheck();
        check.add(Calendar.MONTH,6);

        if(bal.getAccountStatus()){
            if(timeNow.before(check)) {

                double drawAmount = checkInfo.getCheckAmount();
                bal = acc.getAccts(index);
                double balance =  bal.getAccountBalance();

                if(drawAmount <= 0.0)
                {
                    String reason = "Trying to withdraw invalid amount.";
                    clearedCheck = new TransactionReceipt(info,false,reason,balance);
                    return clearedCheck;

                }
                else if(drawAmount > balance)
                {
                    String reason = "Balance has insufficient funds. You have been charged a $2.50 service fee. ";
                    final double fee = 2.50;
                    double newBal = balance - fee;
                    clearedCheck = new TransactionReceipt(info,false,reason,balance,newBal);
                    bal.setAccountBalance(newBal);
                    return clearedCheck;
                }
                else
                {
                    double newBal = balance - drawAmount;
                    clearedCheck = new TransactionReceipt(info,true,balance,newBal);
                    bal.setAccountBalance(newBal);
                    return clearedCheck;
                }
            }
            else
            {
                String reason = "The date on the check is more than 6 months ago.";
                clearedCheck = new TransactionReceipt(info,false,reason);
                return clearedCheck;
            }
        }else{
            String reason = "Account is closed.";
            clearedCheck = new TransactionReceipt(info,false,reason);
            return clearedCheck;
        }
    }

    public TransactionReceipt closeAccount(TransactionTicket ticketInfo, Bank obj, int index){
        TransactionReceipt close;
        Account accInfo = obj.getAccts(index);

        if(accInfo.getAccountBalance()>0){
            String reason = "Account cant be close, Withdraw first.";
            close = new TransactionReceipt(ticketInfo,false,reason);
            return close;
        }else{
            if(obj.getAccts(index).accountStatus){
                accInfo = obj.getAccts(index);
                accInfo.setAccountStatus(false);
                close = new TransactionReceipt(ticketInfo,true);
                return close;
            }else{
                String reason = "Account is closed already.";
                close = new TransactionReceipt(ticketInfo,false,reason);
                return close;
            }
        }
    }

    public TransactionReceipt reopenAccount(TransactionTicket ticketInfo, Bank obj, int index){
        TransactionReceipt close;
        Account accInfo;

        if(obj.getAccts(index).accountStatus){
            String reason = "Account is active.";
            close = new TransactionReceipt(ticketInfo,false,reason);
            return close;
        }else{
            accInfo = obj.getAccts(index);
            accInfo.setAccountStatus(true);
            close = new TransactionReceipt(ticketInfo,true);
            return close;
        }
    }

    public ArrayList<TransactionReceipt> getTransactionHistory(TransactionTicket ticket, Bank obj, int index){
        TransactionReceipt transaction;
        return null;
    }
    // Accessors and mutators
    public Depositor getPersonInfo() {
        return PersonInfo;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    private void setAccountBalance(double amount){
        accountBalance = amount;
    }

    private void setAccountStatus(boolean status){
        accountStatus = status;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public TransactionReceipt getArrayOfReceipts(int count) {
        return arrayOfReceipts.get(count);
    }
}
