package Entity;

public class LaptopVariant extends Variant{
    private String variantId;
    private String ram;
    private String color;
    private String cpu;

    public LaptopVariant() {
    }

    public LaptopVariant(String variantId, String ram, String color, String cpu) {
        this.variantId = variantId;
        this.ram = ram;
        this.color = color;
        this.cpu = cpu;
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
}
