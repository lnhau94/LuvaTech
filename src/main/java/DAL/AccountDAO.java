package DAL;

import Entity.Account;

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

}
