public class Account {
    private double balance;
    private int accountnumber;
     private static int numberofaccounts = 1000;
public Account(){

}
     public Account(double intialDeposit){
         this.balance = intialDeposit;
         this.accountnumber = Account.numberofaccounts++;
        // numberofaccounts++; // increment
        }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountnumber;
    }

    public void deposit(double intialDeposit){
        System.out.println("Amount Added"+ intialDeposit);
        this.balance = balance + intialDeposit;
         System.out.println("Updated Balance"+ balance);
        }

    public void withdraw(double intialDeposit){
         if (intialDeposit > balance) {
             System.out.println("Insufficient fund");
         }else {
             intialDeposit =intialDeposit - balance;
             System.out.println("\nwithdrawn amount" + intialDeposit + "\nUpdated balance" + balance);

         }

    }
    @Override

    public String toString(){
         return String.format("\nAccount Number: %d\nbalance: %.2f", accountnumber, balance);

    }






}
