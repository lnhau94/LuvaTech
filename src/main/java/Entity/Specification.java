package Entity;

public class Specification {
    private String SKU;
    private String productId;
    private int price;
    private int inStock;

    public Specification() {
    }

    public Specification(String SKU, String productId, int price, int inStock) {
        this.SKU = SKU;
        this.productId = productId;
        this.price = price;
        this.inStock = inStock;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
