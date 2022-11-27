package App.Model;

import App.Logic.AccountManagement;
import App.Logic.CustomerManagement;
import App.Logic.ProductManagement;
import DAL.AccountDAO;
import DAL.CustomerDAO;

import java.util.ArrayList;

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
