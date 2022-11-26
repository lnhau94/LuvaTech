package Entity;

public class OrderDetails {

    private String SKU;
    private int qty;

    public OrderDetails() {
    }

    public OrderDetails(String SKU, int qty) {
        this.SKU = SKU;
        this.qty = qty;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
