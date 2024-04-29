public class Teller extends Bank {
    private String TellerName;
    private String TellerId;

    public Teller(){
    }

    public String getTellerName() {
        return TellerName;
    }

    public void setTellerName(String tellerName) {
        TellerName = tellerName;
    }

    public String getTellerId() {
        return TellerId;
    }

    public void setTellerId(String tellerId) {
        TellerId = tellerId;
    }
    @Override
    public String toString(){
        return String.format("\nTeller Name: %s\nID: %s", TellerName, TellerId);

    }
}
