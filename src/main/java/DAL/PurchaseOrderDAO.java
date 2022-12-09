package DAL;

import Entity.PurchaseOrder;
import Entity.PurchaseOrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PurchaseOrderDAO {
    public PurchaseOrderDAO() {
    }

    /**
     * get all PO data
     * @return list of PO
     */
    public static ArrayList<PurchaseOrder> purchaseOrderRetrieve() {
        ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("select purchaseorderid, totalprice, purchasedate, " +
                    "expecteddeliverydate, suppliername, supplieraddress, status from purchaseorder");
            while(rs != null && rs.next()) {
                purchaseOrders.add(new PurchaseOrder(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(rs.getString(6)),
                        rs.getString(rs.getString(7))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for(PurchaseOrder po : purchaseOrders) {
            po.setDetails(purchaseOrderDetailsRetrieve(po));
        }

        return purchaseOrders;
    }

    /**
     * get details of a purchase order
     * @param po purchase order need to get details
     * @return list of purchase order detials
     */
    public static ArrayList<PurchaseOrderDetail> purchaseOrderDetailsRetrieve(PurchaseOrder po) {
        ArrayList<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();

        DAO dao = new DAO();
        PreparedStatement preStmt = dao.getPreStmt("select sku, orderqty, receiveqty " +
                "from purchaseorderdetail pod join purchaseorder po on pod.purchaseorderid = po.purchaseorderid" +
                "where pod.purchaseorderid = ?");
        try {
            preStmt.setString(1, po.getPurchaseOrderId());
            ResultSet rs = preStmt.executeQuery();
            while(rs != null && rs.next()) {
                purchaseOrderDetails.add(new PurchaseOrderDetail(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchaseOrderDetails;
    }
}
