package App.Model;

import Logic.AccountManagement;
import Logic.CustomerManagement;
import Logic.ProductManagement;

public class MainModel {
    public static AccountManagement accountManager;
    public static CustomerManagement customerManager;

    public static ProductManagement productManager;



    public static void start(){
        accountManager = new AccountManagement();
        customerManager = new CustomerManagement();
        productManager = new ProductManagement();
    }
}
