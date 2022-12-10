package DAL;

import java.sql.*;

public class DAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement preStmt;
    private final String connectString = "jdbc:postgresql://localhost:5432/postgres?currentSchema=luvashop";
    private final String dbuser = "postgres";

    private final String dbpass = "Huy150902";

    public DAO(){
        try {
            conn = DriverManager.getConnection(connectString,dbuser,dbpass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * get Statement from JDBC for execute query
     * @return
     */
    public Statement getStmt() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println(this.getClass().toString());
            System.err.println(e.getMessage());
        }
        return stmt;
    }

    public PreparedStatement getPreStmt(String qry){
        try {
            preStmt = conn.prepareStatement(qry);
        } catch (SQLException e) {
            System.err.println(this.getClass().toString());
            System.err.println(e.getMessage());
        }
        return preStmt;
    }
}
