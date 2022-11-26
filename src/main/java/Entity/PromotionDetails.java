package Entity;

public class PromotionDetails {

    private String SKU;
    private int percentDiscount;

    public PromotionDetails() {
    }

    public PromotionDetails(String SKU, int percentDiscount) {
        this.SKU = SKU;
        this.percentDiscount = percentDiscount;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
