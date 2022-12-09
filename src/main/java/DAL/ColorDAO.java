package DAL;

import Entity.Color;
import Entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ColorDAO {
    public ColorDAO(){

    }
    public static ArrayList<Color> retrieve(){
        DAO dao = new DAO();
        ArrayList<Color> colors = new ArrayList<Color>();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select * from colors");
            while (rs != null && rs.next()){
                colors.add(new Color(
                        rs.getString(1),
                        rs.getString(2)

                ));
            }
        } catch (SQLException e) {
            System.out.println("ColorDAO");
            System.out.println(e.getMessage());
        }
        return colors;
    }
}
