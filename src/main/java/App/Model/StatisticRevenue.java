package App.Model;

import java.sql.Date;

public class StatisticRevenue {
    private Date date;
    private Integer qtyLaptop;
    private Integer qtyHeadphone;
    private Integer qtyKeyboard;
    private Integer qtyPhone;
    private Integer qtySmartwatch;
    private Integer totalQty;
    private Integer totalPrice;

    public StatisticRevenue() {}

    public StatisticRevenue(Date date, Integer qtyLaptop, Integer qtyHeadphone, Integer qtyKeyboard, Integer qtyPhone, Integer qtySmartwatch, Integer totalPrice) {
        this.date = date;
        this.qtyLaptop = qtyLaptop;
        this.qtyHeadphone = qtyHeadphone;
        this.qtyKeyboard = qtyKeyboard;
        this.qtyPhone = qtyPhone;
        this.qtySmartwatch = qtySmartwatch;
        this.totalQty = this.qtyLaptop+this.qtyHeadphone+this.qtyKeyboard+this.qtyPhone+this.qtySmartwatch;
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQtyLaptop() {
        return qtyLaptop;
    }

    public void setQtyLaptop(Integer qtyLaptop) {
        this.qtyLaptop = qtyLaptop;
    }

    public Integer getQtyHeadphone() {
        return qtyHeadphone;
    }

    public void setQtyHeadphone(Integer qtyHeadphone) {
        this.qtyHeadphone = qtyHeadphone;
    }

    public Integer getQtyKeyboard() {
        return qtyKeyboard;
    }

    public void setQtyKeyboard(Integer qtyKeyboard) {
        this.qtyKeyboard = qtyKeyboard;
    }

    public Integer getQtyPhone() {
        return qtyPhone;
    }

    public void setQtyPhone(Integer qtyPhone) {
        this.qtyPhone = qtyPhone;
    }

    public Integer getQtySmartwatch() {
        return qtySmartwatch;
    }

    public void setQtySmartwatch(Integer qtySmartwatch) {
        this.qtySmartwatch = qtySmartwatch;
    }

    public Integer getTotalQty() {
        return totalQty;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
