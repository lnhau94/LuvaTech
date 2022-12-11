package DAL;

import Entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountDAO {

    public AccountDAO() {
    }
    public static HashMap<String,Account> retrieve(){
        HashMap<String,Account> accounts = new HashMap<>();
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select * from account");
            while(rs != null && rs.next()){
                accounts.put(String.valueOf(rs.getString(1)),
                        new Account(rs.getString(2),
                                rs.getString(3)));
            }
        } catch (SQLException e) {
            System.err.println("AccountDAO err retrieve");
            System.err.println(e.getMessage());
        }

        return accounts;
    }

    public static void addAccount(String staffId, Account acc) {
        DAO dao = new DAO();
        PreparedStatement pst = dao.getPreStmt(
                "insert into account (staffid,accountuser,accountpass) values(?,?,?)"
        );
        try {
            pst.setInt(1,Integer.parseInt(staffId));
            pst.setString(2, acc.getUsername());
            pst.setString(3, acc.getPassword());
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
