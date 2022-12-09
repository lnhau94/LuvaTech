package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class MappingDAO {
    public MappingDAO() {
    }
    public static HashMap<String,String> mapOrderStaff(){
        HashMap<String,String> orderStaff = new HashMap<>();

        DAO dao = new DAO();
        try {
            ResultSet rs = dao.getStmt().executeQuery("select orderid, staffsale from orders");
            while (rs != null && rs.next()){
                orderStaff.put(rs.getString(1), rs.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderStaff;
    }

    public static HashMap<String, String> mapOrderStaffTakeBack() {
        HashMap<String, String> orderStaffTakeBack = new HashMap<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select orderid, staffback from orders");
            while(rs != null && rs.next()) {
                orderStaffTakeBack.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderStaffTakeBack;
    }

    public static HashMap<String, String[]> mapPOStaff() {
        HashMap<String, String[]> POStaff = new HashMap<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select purchaseorderid, employeeidcreate, " +
                    "employeeidconfirm from purchaseorder");
            while(rs != null && rs.next()) {
                POStaff.put(rs.getString(1), new String[] {
                        rs.getString(2), rs.getString(3)});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return POStaff;
    }
}
