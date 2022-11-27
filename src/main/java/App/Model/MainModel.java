package App.Model;

import DAL.MappingDAO;
import Entity.Order;
import Entity.Staff;
import Logic.*;

import java.util.HashMap;

public class MainModel {
    public static AccountManagement accountManager;
    public static CustomerManagement customerManager;

    public static ProductManagement productManager;
    public static OrderManagement orderManager;
    public static StaffManagement staffManager;
    public static BrandManagement brandManager;



    public static void start(){
        accountManager = new AccountManagement();
        staffManager = new StaffManagement();
        customerManager = new CustomerManagement();
        productManager = new ProductManagement();
        orderManager = new OrderManagement();
        brandManager = new BrandManagement();
        mapData();
    }

    private static void mapData(){
        mapStaffAccount();
        mapStaffOrder();
    }

    private static void mapStaffAccount(){
        for (Staff staff : staffManager.getStaffList()){
            staff.setAccount(accountManager.findAccountByStaffId(staff.getStaffId()));
        }
    }

    private static void mapStaffOrder(){
        HashMap<String,String> orderStaff = MappingDAO.mapOrderStaff();
        for(Order o : orderManager.getOrderList()){
            o.setCashier(staffManager.findById(orderStaff.get(o.getOrderId())));
        }
    }

}
