public class Name {
    private String First;
    private String Last;

    public Name(){
        First = "";
        Last = "";
    }

    public Name(String First, String Last){
        this.First = First;
        this.Last = Last;
    }

    public String getFirst() {
        return First;
    }

    public String getLast() {
        return Last;
    }
}
