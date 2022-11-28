package Entity;

public class LaptopVariant extends Variant{
    private String variantId;
    private String ram;
    private String color;
    private String storage;

    public LaptopVariant() {
    }

    public LaptopVariant(String variantId, String ram, String color, String storage) {
        this.variantId = variantId;
        this.ram = ram;
        this.color = color;
        this.storage = storage;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
