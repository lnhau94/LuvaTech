package DAL;

import Entity.Account;
import Entity.Customer;

import java.sql.PreparedStatement;
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

    public String insertCustomer(Customer customer) {
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement= dao.getPreStmt("insert into customer (customername,customerbirthday,customeraddress,customerphone) " +
                "values(?,?,?,?) returning customerid");
        try {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getPhone());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs != null && rs.next()){
                return rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("CustomerDAO");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
