import java.util.ArrayList;

public class Bank  {
    ArrayList<Customer> customersArraylist = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customersArraylist.add(customer);

    }

    public void removeCustomer(Customer customer) {
        customersArraylist.remove(customer);
    }



    public Customer getCustomer(String Pin) {
        Customer foundcustomer = null;
        for (Customer customer : customersArraylist) {
            if (customer.getPin().equals((Pin))) {
                foundcustomer = customer;
                break;
            }

        }
        return foundcustomer;
    }

    public StringBuilder getallaccount() {
        StringBuilder sb = new StringBuilder();
        for(Customer Customer: customersArraylist){
            sb.append(Customer.toString());
        }
        return sb;
    }


}



