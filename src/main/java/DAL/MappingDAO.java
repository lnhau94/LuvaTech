package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
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
}
