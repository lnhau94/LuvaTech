package Logic;

import DAL.OrderDAO;
import Entity.Order;

import java.util.ArrayList;

public class OrderManagement {
    private ArrayList<Order> orderList;

    public OrderManagement() {
        init();
    }

    private void init(){
        orderList = OrderDAO.retrieve();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
