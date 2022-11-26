package DAL;

import Entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductDAO {

    private static ArrayList<Brand> brands;
    private static final String laptopQuery = "select p.productid, p.productname, l.screen, l.connected, " +
            "l.os, l.material, l.laptopsize, l.weight, l.camera, " +
            "b.brandid, b.brandname, b.brandcountry " +
            "from product p join laptopinfo l on p.productid  = l.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null " ;

    private static final String phoneQuery = "select p.productid, p.productname, p2.chip , " +
            "p2.screen , p2.connected , p2.os , p2.material , p2.battery , p2.sim , p2.camera, " +
            "b.brandid, b.brandname, b.brandcountry " +
            "from product p join phoneinfo p2 on p.productid = p2.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null";
    private static final String smartwatchQuery = "select p.productid , p.productname , " +
            "s.screen , s.frontglass , s.os , s.battery , " +
            "b.brandid, b.brandname , b.brandcountry " +
            "from product p join smartwatchinfo s on s.productid = p.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null";

    public ProductDAO() {
    }

    /**
     * Get all product data without variantion
     * @return a map with key is category and value is list of item for that categeory
     */
    public static HashMap<String, ArrayList<? extends Product>> retrieve(){
        brands = new ArrayList<>();

        HashMap<String,ArrayList<? extends Product>> products = new HashMap<>();
        products.put("laptop",laptopRetrieve());
        products.put("phone",phoneRetrieve());
        products.put("smartwatch",smartWatchRetrieve());
        products.put("keyboard",new ArrayList<Keyboard>());
        products.put("headphone",new ArrayList<Headphone>());
        return products;
    }

    /**
     * get all laptop data
     * @return list of laptops
     */
    private static ArrayList<Laptop> laptopRetrieve(){
        ArrayList<Laptop> laptops = new ArrayList<>();
        boolean flag = false;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery(laptopQuery);

            while (rs != null && rs.next()){
                Brand tmp = null;
                for(Brand brd : brands){
                    if(brd.getBrandId().equals(rs.getString(1))){
                        flag = true;
                        tmp = brd;
                    }
                }

                if(!flag){
                    tmp = new Brand(rs.getString(10),
                            rs.getString(11),
                            rs.getString(12));
                }
                laptops.add(new Laptop(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }
        return laptops;
    }

    /**
     * get all phone data
     * @return list of phones
     */
    private static ArrayList<Phone> phoneRetrieve(){
        ArrayList<Phone> phones = new ArrayList<>();
        boolean flag = false;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery(phoneQuery);

            while (rs != null && rs.next()){
                Brand tmp = null;
                for(Brand brd : brands){
                    if(brd.getBrandId().equals(rs.getString(1))){
                        flag = true;
                        tmp = brd;
                    }
                }

                if(!flag){
                    tmp = new Brand(rs.getString(11),
                            rs.getString(12),
                            rs.getString(13));
                }
                phones.add(new Phone(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }
        return phones;
    }

    /**
     * get all smartwatches data
     * @return list of smartwatches
     */
    private static ArrayList<SmartWatch> smartWatchRetrieve(){
        ArrayList<SmartWatch> smartWatches = new ArrayList<>();
        boolean flag = false;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery(smartwatchQuery);

            while (rs != null && rs.next()){
                Brand tmp = null;
                for(Brand brd : brands){
                    if(brd.getBrandId().equals(rs.getString(1))){
                        flag = true;
                        tmp = brd;
                    }
                }

                if(!flag){
                    tmp = new Brand(rs.getString(7),
                            rs.getString(8),
                            rs.getString(9));
                }
                smartWatches.add(new SmartWatch(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));

                System.out.println(tmp.getBrandId());
                System.out.println(tmp.getBrandName());
                System.out.println(tmp.getBrandCountry());

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }
        System.out.println(smartWatches.size());
        return smartWatches;
    }




}
