package DAL;

import Entity.Staff;

import java.sql.*;
import java.util.ArrayList;

public class StaffDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement preStmt;
    private final String connectString = "jdbc:postgresql://localhost:5432/postgres?currentSchema=luvashop";
    private final String dbuser = "postgres";

    private final String dbpass = "Huy150902";
    public StaffDAO() {
    }

    public static ArrayList<Staff> retrieve(){
        ArrayList<Staff> staffs = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select staffid, staffname, staffbirthday, staffaddress, " +
                    " staffposition from staff");
            while (rs != null && rs.next()){
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
                System.out.print(rs.getString(3));
                System.out.print(rs.getString(4));
                System.out.print(rs.getString(5));
                staffs.add(new Staff(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(3),
                        null

                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return staffs;
    }

}
