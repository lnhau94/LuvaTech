package App.Model;

import DAL.DAO;
import Entity.Customer;
import Entity.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class CustomerModel {
    public void addCustomer(String name, String birthday, String address, String phone) throws SQLException {
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("INSERT INTO customer(CustomerName,CustomerBirthday,CustomerAddress,CustomerPhone) " +
                "            VALUES('"+name+"','"+birthday+"','"+address+"','"+phone+"')");
        preparedStatement.execute();
    }
    public void editCustomer(String id,String name, String birthday, String address, String phone) throws SQLException {
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("UPDATE customer SET CustomerName='"+name+"', CustomerBirthday='"+birthday+"',CustomerAddress='"+address+"',CustomerPhone='"+phone+"'\n" +
                " WHERE CustomerID = '"+id+"'");
        preparedStatement.execute();
    }
    public void deleteCustomer(String ID) throws SQLException{
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("DELETE FROM customer WHERE CustomerID='"+ID+"'");
        preparedStatement.execute();
    }
    public static ArrayList<Customer> retrieve(){
        ArrayList<Customer> customer  = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs != null && rs.next()){
                customer.add(new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }


}
