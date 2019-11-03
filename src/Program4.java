import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) throws FileNotFoundException
    {
        Bank bankObj = new Bank();

        char choice;
        boolean notDone = true;

        Scanner kybd = new Scanner(System.in);

        PrintWriter outputFile = new PrintWriter("myoutput.txt");

        readAccts(bankObj);

        printAccts(bankObj, outputFile);
    }

    public static void readAccts(Bank bankObj) throws FileNotFoundException {

        String line;
        File myFile = new File("myinput.txt");
        Scanner cin = new Scanner(myFile);

        while(cin.hasNext()){
            line = cin.nextLine();
            String[] tokens = line.split(" ");

            Name acctName = new Name(tokens[0],tokens[1]);
            Depositor acctInfo = new Depositor(tokens[2],acctName);
            Account allInfo = new Account(Integer.parseInt(tokens[3]),tokens[4],Double.parseDouble(tokens[5]),acctInfo);
            //bankObj.openNewAccount(allInfo);
        }
    }

    public static void printAccts(Bank bank, PrintWriter output){

    }

    public static void menu(){
        System.out.println();
        System.out.println("Select one of the following transactions:");
        System.out.println("\t****************************");
        System.out.println("\t    List of Choices         ");
        System.out.println("\t****************************");
        System.out.println("\t     W -- Withdrawal");
        System.out.println("\t     D -- Deposit");
        System.out.println("\t     C -- Clear Check");
        System.out.println("\t     N -- New Account");
        System.out.println("\t     B -- Balance Inquiry");
        System.out.println("\t     I -- Account Info");
        System.out.println("\t     X -- Delete Account");
        System.out.println("\t     Q -- Quit");
        System.out.println();
        System.out.print("\tEnter your selection: ");
    }

    public static void balance(){

    }

    public static void deposit(){

    }

    public static void withdrawal(){

    }

    public static void clearCheck(){

    }

    public static void acctInfo(){

    }

    public static void acctInfoHistory(){

    }

    public static void newAccount(){

    }

    public static void closeAccount(){

    }

    public static void reopenAccount(){

    }

    public static void deleteAccount(){

    }
}
