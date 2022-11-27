package Entity;

public abstract class Product {
    protected String productId;
    protected String productName;
    protected Brand brand;
    protected String imgPath;

    public Product() {
    }

    public Product(String productId, String productName, Brand brand, String imgPath) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.imgPath = imgPath;
    }

    public String getProductId() {
        return productId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
