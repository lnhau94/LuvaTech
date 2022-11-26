package Entity;

public class GiveBackItem {
    private String SKU;
    private String reason;
    private int payback;

    public GiveBackItem() {
    }

    public GiveBackItem(String SKU, String reason, int payback) {
        this.SKU = SKU;
        this.reason = reason;
        this.payback = payback;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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
}
