package DAL;

import Entity.Order;
import Entity.OrderDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {
    public OrderDAO() {
    }

    /**
     * get all order data
     * @return list of order
     */
    public static ArrayList<Order> retrieve(){
        ArrayList<Order> orders = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select orderid, totalprice, orderdate from orders");
            while(rs != null && rs.next()){
                orders.add(new Order(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDate(3)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Order o : orders){
            o.setDetails(orderDetailRetrieve(o));
        }

        return orders;
    }

    /**
     * get all detail for order
     * @param o order need to get details
     * @return list of order details
     */
    public static ArrayList<OrderDetails> orderDetailRetrieve(Order o){
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt("select sku, quantity " +
                "from orders o join orderdetails od on o.orderid = od.orderid " +
                "where o.orderid = ? ");
        try {
            preStmt.setString(1,o.getOrderId());
            ResultSet rs = preStmt.executeQuery();
            while (rs != null && rs.next()){
                orderDetails.add(new OrderDetails(rs.getString(1),rs.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderDetails;
    }
}
