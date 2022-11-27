package DAL;

import Entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductDAO {

    private static ArrayList<Brand> brands;
    private static final String laptopQuery = "select p.productid, p.productname, l.screen, l.connected, " +
            "l.os, l.material, l.laptopsize, l.weight, l.camera, l.cpu, p.pathimage, " +
            "b.brandid, b.brandname, b.brandcountry " +
            "from product p join laptopinfo l on p.productid  = l.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null " ;

    private static final String phoneQuery = "select p.productid, p.productname, p2.chip , " +
            "p2.screen , p2.connected , p2.os , p2.material , p2.battery , p2.sim , p2.camera, p.pathimage, " +
            "b.brandid, b.brandname, b.brandcountry " +
            "from product p join phoneinfo p2 on p.productid = p2.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null";
    private static final String smartwatchQuery = "select p.productid , p.productname , " +
            "s.screen , s.frontglass , s.os , s.battery , p.pathimage,  " +
            "b.brandid, b.brandname , b.brandcountry " +
            "from product p join smartwatchinfo s on s.productid = p.productid " +
            "join brand b on p.brandid = b.brandid " +
            "where deletedate is null";

    private static final String headphoneQuery = "select p.productid , p.productname , " +
            "h.usetime , h.boxtime , h.os , h.charger , h.connected , h.headphonecontrol, p.pathimage, " +
            "b.brandid , b.brandname , b.brandcountry " +
            "from product p join headphoneinfo h on p.productid = h.productid " +
            "join brand b on p.brandid  = b.brandid " +
            "where deletedate is null";

    private static final String keyboardQuery = "select p.productid , p .productname , " +
            "k.led , k.keycap , k.os , k.battery , p.pathimage, " +
            "b.brandid , b.brandname , b.brandcountry " +
            "from product p join keyboardinfo k on p.productid = k.productid " +
            "join brand b on p.brandid  = b.brandid " +
            "where deletedate is null";

    private static final String laptopVariantQuery = "select p.productid , " +
            "s.sku , s.price , s.instock , " +
            "l.variantid , l.laptopram , l.laptopcolor , l.laptopcpu , l.pathimage," +
            "from specification s join laptopvariation l on s.sku = l.sku " +
            "join product p on p.productid = s.productid " +
            "where p.productid = ? ";

    private static final String phoneVariantQuery = "select s.sku , s.productid , s.price , s.instock , " +
            "p2.variantid , p2.phoneram , p2.phonecolor , p2.phonestorage, p2.pathimage " +
            "from specification s join phonevariation p2  on s.sku = p2.sku " +
            "where s.productid = ? ";
    private static final String smartWatchVariantQuery = "select s.sku , s.productid , s.price , s.instock , " +
            "s2.variantid , s2.smartwatchedition , s2.smartwatchcolor, s2.pathimage " +
            "from specification s join smartwatchvariation s2  on s2.sku = s.sku " +
            "where s.productid = ? ";
    private static final String headphoneVariantQuery = "select s.sku , s.productid , s.price , s.instock , " +
            "h.variantid , h.headphonecolor, h.pathimage " +
            "from specification s join headphonevariation h on s.sku = h.sku " +
            "where s.productid = ? ";
    private static final String keyboardVariantQuery = "select s.sku , s.productid , s.price , s.instock , " +
            "k.variantid , k.keyboardswitch , k.keyboardcolor, k.pathimage " +
            "from specification s join keyboardvariation k  on s.sku = k.sku " +
            "where s.productid = ? ";

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
        products.put("keyboard",headphoneRetrieve());
        products.put("headphone",keyboardRetrieve());

        for(Laptop lap : (ArrayList<Laptop>)products.get("laptop")){
            lap.setVariants(laptopVariantRetrieve(lap));
        }

        for (Phone p : (ArrayList<Phone>)products.get("phone")){
            p.setVariants(phoneVariantRetrieve(p));
        }

        for (SmartWatch sm : (ArrayList<SmartWatch>)products.get("smartwatch")){
            sm.setVariants(smartWatchVariantRetrieve(sm));
        }

        for (Headphone hp : (ArrayList<Headphone>)products.get("headphone")){
            hp.setVariants(headphoneVariantRetrieve(hp));
        }

        for (Keyboard kb : (ArrayList<Keyboard>)products.get("keyboard")){
            kb.setVariants(keyboardVariantRetrieve(kb));
        }

        return products;
    }

    /**
     * get all variant for a laptop
     * @param laptop laptop need to get its variant
     * @return list of laptop variant
     */
    private static ArrayList<LaptopVariant> laptopVariantRetrieve(Laptop laptop){
        ArrayList<LaptopVariant> variants = new ArrayList<>();
        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt(laptopVariantQuery);
        try {
            preStmt.setString(1,laptop.getProductId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()){
                LaptopVariant lv = new LaptopVariant(
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                        );
                lv.setSpecs(new Specification(
                        rs.getString(2),
                        rs.getString(1),
                        rs.getInt(3),
                        rs.getInt(4))
                );
                lv.setImgPath(rs.getString(9));

                variants.add(lv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return variants;
    }

    /**
     * get all variant for phone
     * @param phone phone need to geet its variant
     * @return list of variant
     */
    private static ArrayList<PhoneVariant> phoneVariantRetrieve(Phone phone){
        ArrayList<PhoneVariant> variants = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt(phoneVariantQuery);
        try {
            preStmt.setString(1,phone.getProductId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()){
                PhoneVariant pv = new PhoneVariant(
                        new Specification(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );

                pv.setImgPath(rs.getString(9));

                variants.add(pv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return variants;
    }

    /**
     * get all smartwatch variant
     * @param smartWatch smartwatch need to get its variant
     * @return list of smartwatch variant
     */
    private static ArrayList<SmartWatchVariant> smartWatchVariantRetrieve(SmartWatch smartWatch){
        ArrayList<SmartWatchVariant> variants = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt(smartWatchVariantQuery);
        try {
            preStmt.setString(1,smartWatch.getProductId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()){
                SmartWatchVariant sm = new SmartWatchVariant(
                        new Specification(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );

                sm.setImgPath(rs.getString(8));
                variants.add(sm);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return variants;
    }

    /**
     * get all variant for headphone
     * @param headphone headphone need to get its variant
     * @return list of headphone variant
     */
    private static ArrayList<HeadphoneVariant> headphoneVariantRetrieve(Headphone headphone){
        ArrayList<HeadphoneVariant> variants = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt(headphoneVariantQuery);
        try {
            preStmt.setString(1,headphone.getProductId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()){
                HeadphoneVariant hv = new HeadphoneVariant(
                        new Specification(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6)
                );

                hv.setImgPath(rs.getString(7));
                variants.add(hv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return variants;
    }

    /**
     * get all keyboard variant
     * @param keyboard keyboard need to get its variant
     * @return list of keyboard variant
     */
    private static ArrayList<KeyboardVariant> keyboardVariantRetrieve(Keyboard keyboard){
        ArrayList<KeyboardVariant> variants = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt(keyboardVariantQuery);
        try {
            preStmt.setString(1,keyboard.getProductId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()){
                KeyboardVariant kv = new KeyboardVariant(
                        new Specification(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );

                kv.setImgPath(rs.getString(8));
                variants.add(kv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return variants;
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
                    tmp = new Brand(rs.getString(12),
                            rs.getString(13),
                            rs.getString(14));
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
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));

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
                    tmp = new Brand(rs.getString(12),
                            rs.getString(13),
                            rs.getString(14));
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
                        rs.getString(10),
                        rs.getString(11))
                );

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
                    tmp = new Brand(rs.getString(8),
                            rs.getString(9),
                            rs.getString(10));
                }
                smartWatches.add(new SmartWatch(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7))
                );

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }

        return smartWatches;
    }

    /**
     * get all headphone data
     * @return list of headphones
     */
    private static ArrayList<Headphone> headphoneRetrieve(){
        ArrayList<Headphone> headphones = new ArrayList<>();

        boolean flag = false;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery(headphoneQuery);

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
                headphones.add(new Headphone(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9))
                );

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }

        return headphones;
    }

    /**
     * get all keyboard data
     * @return list of keyboard
     */
    private static ArrayList<Keyboard> keyboardRetrieve(){
        ArrayList<Keyboard> keyboards = new ArrayList<>();

        boolean flag = false;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery(keyboardQuery);

            while (rs != null && rs.next()){
                Brand tmp = null;
                for(Brand brd : brands){
                    if(brd.getBrandId().equals(rs.getString(1))){
                        flag = true;
                        tmp = brd;
                    }
                }

                if(!flag){
                    tmp = new Brand(rs.getString(8),
                            rs.getString(9),
                            rs.getString(10));
                }
                keyboards.add(new Keyboard(
                        rs.getString(1),
                        rs.getString(2),
                        tmp,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7))
                );

            }
        } catch (SQLException e) {
            System.err.println("ProductDAO laptop retrieve err");
            System.err.println(e.getMessage());
        }

        return keyboards;
    }

    public static ArrayList<Brand> getBrands() {
        return brands;
    }

    public static void setBrands(ArrayList<Brand> brands) {
        ProductDAO.brands = brands;
    }
}
