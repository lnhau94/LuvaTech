package Logic;


import DAL.PurchaseOrderDAO;
import Entity.PurchaseOrder;

import java.util.ArrayList;

public class PurchaseOrderManagement {

    public ArrayList<PurchaseOrder> purchaseOrderList;

    public PurchaseOrderManagement() {
        this.purchaseOrderList = init();
    }

    public ArrayList<PurchaseOrder> init() {
        return PurchaseOrderDAO.purchaseOrderRetrieve();
    }

    public ArrayList<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }
}

