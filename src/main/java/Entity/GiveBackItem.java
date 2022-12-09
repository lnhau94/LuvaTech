package Entity;

import java.sql.Date;

public class GiveBackItem {
    private String SKU;
    private int qty;
    private String reason;
    private int payback;
    private Date backDate;

    public GiveBackItem() {
    }

    public GiveBackItem(String SKU, int qty, String reason, int payback, Date backDate) {
        this.SKU = SKU;
        this.qty = qty;
        this.reason = reason;
        this.payback = payback;
        this.backDate = backDate;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPayback() {
        return payback;
    }

    public void setPayback(int payback) {
        this.payback = payback;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}
