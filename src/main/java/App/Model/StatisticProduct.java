package App.Model;

import java.sql.Date;

public class StatisticProduct {
    private Date date;
    private String SKU;
    private Integer price;
    private Integer qty;
    private Integer totalPrice;
    public StatisticProduct() {}
    public StatisticProduct(Date date, String SKU, Integer price, Integer qty) {
        this.date = date;
        this.SKU = SKU;
        this.price = price;
        this.qty = qty;
        this.totalPrice = this.price*this.qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

}
