package DAL;

import Entity.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDAO {

    public StaffDAO() {
    }

    public static ArrayList<Staff> retrieve(){
        ArrayList<Staff> staffs = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select staffid, staffname, staffaddress, " +
                    "staffbirthday, staffposition from staff");
            while (rs != null && rs.next()){
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
                System.out.print(rs.getString(3));
                System.out.print(rs.getString(4));
                System.out.print(rs.getString(5));
                staffs.add(new Staff(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        null

                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return staffs;
    }
}
