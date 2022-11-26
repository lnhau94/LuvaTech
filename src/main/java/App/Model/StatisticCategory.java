package App.Model;

public class StatisticCategory {
    private String name;
    private Integer qty;
    private Integer totalPrice;

    public StatisticCategory() {}

    public StatisticCategory(String name, Integer qty, Integer totalPrice) {
        this.name = name;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
