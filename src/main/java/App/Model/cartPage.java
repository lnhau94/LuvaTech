package App.Model;

public class cartPage {
    private String productSKU;
    private String productName;
    private String description;
    private int price;
    private int quantity;
    private int total;

    public cartPage(String productSKU, String productName, String description, int price, int quantity, int total) {
        this.productSKU = productSKU;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public cartPage() {
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "cartPage{" +
                "productSKU='" + productSKU + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
