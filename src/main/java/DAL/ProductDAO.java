package DAL;

import Entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductDAO {

    public ProductDAO() {
    }

    public static HashMap<String, ArrayList<? extends Product>> retrieve(){
        HashMap<String,ArrayList<? extends Product>> products = new HashMap<>();
        products.put("laptop",new ArrayList<Laptop>());
        products.put("phone",new ArrayList<Phone>());
        products.put("smartwatch",new ArrayList<SmartWatch>());
        products.put("keyboard",new ArrayList<Keyboard>());
        products.put("headphone",new ArrayList<Headphone>());

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs1 = stmt.executeQuery(
                    "select p.productid, p.productname, l.screen, l.connected, " +
                        "l.os, l.material, l.laptopsize, l.weight, l.camera, " +
                        "b.brandid, b.brandname, b.brandcountry " +
                    "from product p join laptopinfo l on p.productid  = l.productid " +
                        "join brand b on p.brandid = b.brandid " +
                    "where deletedate is null ");
            while (rs1 != null && rs1.next()){
                products.put(rs1.getString())
            }
        } catch (SQLException e) {
            System.err.println("ProductDAO err");
            System.err.println(e.getMessage());
        }
    }
}
