package DAL;

import Entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {

    public CustomerDAO() {
    }

    public static ArrayList<Customer> retrieve(){
        DAO dao = new DAO();
        ArrayList<Customer> customers = new ArrayList<>();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs != null && rs.next()){
                customers.add(new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
            System.out.println("CustomerDAO");
            System.out.println(e.getMessage());
        }
        return customers;
    }



}
