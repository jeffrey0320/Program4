public class Depositor {
    private Name PersonName;
    private String SSN;

    public Depositor(){
        PersonName = new Name();
        SSN = "";
    }

    public Depositor(Name PersonName, String SSN){
        this.PersonName = PersonName;
        this.SSN = SSN;
    }

    public Name getPersonName() {
        return PersonName;
    }

    public String getSSN() {
        return SSN;
    }
}