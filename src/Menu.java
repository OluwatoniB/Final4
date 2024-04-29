import java.util.Scanner;
public class Menu {
 private Scanner scanner = new Scanner(System.in);
 private Teller bank = new Teller();

 public void displayMenu() {
  while (true) {
   String selection;
   System.out.printf("\n%s MENU %s\n", "*".repeat(9),
           "*".repeat(9));
   System.out.print("\nPlease make a selection:\n" +
           "1) Access Account\n" +
           "2) Open a New Account\n" +
           "3) Close All Accounts\n" +
           "4) Exit\n" +
           ">> ");
   selection = scanner.nextLine();
   if (selection.equals("1")) {
    accessAccount();
   } else if (selection.equals("2")) {
    createNewAccount();
   } else if (selection.equals("3")) {
    closeAllAccounts();
   } else if (selection.equals("4")) {
    System.out.println("Thank you for using BSU Banking App");
    System.out.println("Goodbye. Exiting....");
    break;
   }
   else {
    System.out.println("Invalid entry");
   }
  }
 }

 private void accessAccount() {
  Account account;
  System.out.println("Please enter your PIN:");
  String pin = scanner.nextLine();
  Customer customer = bank.getCustomer(pin);
  if (customer == null) {
   System.out.println("PIN is invalid");
   return;
  }
  System.out.println("**Active Accounts**");
  System.out.println(customer.getAllAccounts());
  System.out.print("\nPlease Enter the account number\n" +
          "of the account you would like to access: ");
  int accountNo = Integer.parseInt(scanner.nextLine());
  account = customer.getAccount(accountNo);
  if (account == null) {
   System.out.println("Account number is invalid.");
   return;
  }
  while (true) {
   System.out.print("\nPlease make a selection:\n" +
           "1) Make a deposit\n" +
           "2) Make a withdrawal\n" +
           "3) See account balance\n" +
           "4) Close account\n" +
           "5) Exit\n" +
           ">> ");
   String selection = scanner.nextLine();
   if (selection.equals("1")) {
    System.out.println("Enter the amount of deposit:");
    double amount = Double.parseDouble(scanner.nextLine());
    account.deposit(amount);
   } else if (selection.equals("2")) {
    System.out.println("Enter the amount of withdrawal:");
    double amount = Double.parseDouble(scanner.nextLine());
    account.withdraw(amount);
   }  else if (selection.equals("3")) {
    System.out.printf("Account %s balance: $%.2f.\n",
            account.getAccountNumber(),
            account.getBalance());
   } else if (selection.equals("4")) {
    customer.closeAccount(account);
    System.out.printf("\nAccount number %s closed.\n",
            account.getAccountNumber());
   } else if (selection.equals("5")) {
    break;
   } else {
    System.out.println("Invalid entry.");
   }
  }
 }

 private Customer createNewCustomer() {
  String firstName;
  String lastName;
  String pin;
  System.out.println("Please enter your first name: ");
  firstName = scanner.nextLine();
  System.out.println("Please enter your last name: ");
  lastName = scanner.nextLine();
  System.out.println("Please enter a 4 digit PIN: ");
  pin = scanner.nextLine();
  Customer customer = new Customer(firstName, lastName, pin);
  bank.addCustomer(customer);
  return customer;
 }

 private void createNewAccount() {
  String newCustomer;
  Customer customer;
  Account account;
  System.out.println("Are you a new customer?\n" +
          "1) Yes\n" +
          "2) No");
  newCustomer = scanner.nextLine();
  if (newCustomer.equals("1")) {
   customer = createNewCustomer();
  } else {
   System.out.println("Please enter PIN:");
   customer = bank.getCustomer(scanner.nextLine());
   if (customer == null) {
    System.out.println("PIN is invalid.");
    return;
   }
  }
  System.out.println("Please enter deposit amount:");
  double deposit = Double.parseDouble(scanner.nextLine());
  account = new Account(deposit);
  customer.addAccount(account);
  System.out.printf("\nNew Account Opened: %s\n",
          account.getAccountNumber());
 }
 private void closeAllAccounts() {
  Customer customer;
  Account account;
  System.out.println("Please enter your PIN:");
  String pin = scanner.nextLine();
  customer = bank.getCustomer(pin);
  if (customer == null) {
   System.out.println("PIN is invalid");
   return;
  }
  bank.removeCustomer(customer);
  System.out.println("You have been removed from the bank registry.");
 }
}