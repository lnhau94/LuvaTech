package Logic;

import App.Model.cartPage;
import DAL.DAO;
import DAL.OrderDAO;
import Entity.Customer;
import Entity.Order;
import Entity.OrderDetails;

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

    public void insertOrder(ArrayList<cartPage> cartPages, Customer customer){
          Order order = new Order();
          for (cartPage cartitem : cartPages){
              order.getDetails().add(new OrderDetails(cartitem.getProductSKU(),cartitem.getQuantity()));
          }
          int sum=0;
          for (int i = 0; i < cartPages.size(); i++){
              sum+=cartPages.get(i).getTotal();
          }
          order.setCustomer(customer);
          order.setTotalPrice(sum);
        OrderDAO orderDAO = new OrderDAO();
        order.setOrderId(orderDAO.insertOrder(order));
        for (OrderDetails orderDetails : order.getDetails()){
            if(orderDAO.insertOrderDetails(orderDetails,order)){
                System.out.println("them chi tiet don hang thanh cong");
            }else{
                System.out.println("them chi tiet don hang that bai");
            }
        }
        orderList.add(order);
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
