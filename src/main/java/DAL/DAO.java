package DAL;

import java.sql.*;

public class DAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement preStmt;
    private final String connectString = "jdbc:postgresql://localhost:5432/postgres?currentSchema=luvashop";
    private final String dbuser = "postgres";
    //private final String dbpass = "postgres";
    /**
     * Password của Hữu Đại
     */
    private final String dbpass = "123456";
    public DAO(){
        try {
            conn = DriverManager.getConnection(connectString,dbuser,dbpass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
