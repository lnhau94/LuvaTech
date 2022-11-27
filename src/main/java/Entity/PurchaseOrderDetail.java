package Entity;

public class PurchaseOrderDetail {
    private String SKU;
    private int orderQty;
    private int receiveQty;

    public PurchaseOrderDetail() {
    }

    public PurchaseOrderDetail(String SKU, int orderQty, int receiveQty) {
        this.SKU = SKU;
        this.orderQty = orderQty;
        this.receiveQty = receiveQty;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public int getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(int receiveQty) {
        this.receiveQty = receiveQty;
    }
}
