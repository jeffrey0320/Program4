public class Depositor {
    private Name PersonName;
    private String SSN;

    public Depositor(){
        PersonName = new Name();
        SSN = "";
    }

    public Depositor(String SSN, Name PersonName ){
        this.PersonName = PersonName;
        this.SSN = SSN;
    }

    public Depositor(String s, String f, String l) {
        SSN = s;
        PersonName = new Name(f,l);
    }

    public Name getPersonName() {
        return PersonName;
    }

    public String getSSN() {
        return SSN;
    }
}
