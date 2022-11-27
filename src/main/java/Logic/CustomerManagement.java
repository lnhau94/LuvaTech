package Logic;

import DAL.CustomerDAO;
import Entity.Customer;

import java.util.ArrayList;

public class CustomerManagement {
    private ArrayList<Customer> customersList;

    public CustomerManagement() {
        init();
    }

    private void init(){
        this.customersList = CustomerDAO.retrieve();
    }

    public Customer findById(String customerId){
        for(Customer c : customersList){
            if(c.getCustomerId().equals(customerId)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(ArrayList<Customer> customersList) {
        this.customersList = customersList;
    }
}
