package Entity;

public class Brand {
    private String brandId;
    private String brandName;
    private String brandCountry;

    public Brand() {
    }

    public Brand(String brandId, String brandName, String brandCountry) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }
}
