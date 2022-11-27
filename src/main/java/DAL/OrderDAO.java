package DAL;

import Entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {
    public OrderDAO() {
    }

    public static ArrayList<Order> retrieve(){
        ArrayList<Order> orders = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select * from orders");
            while(rs != null && rs.next()){
                orders.add(new Order());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }
}
