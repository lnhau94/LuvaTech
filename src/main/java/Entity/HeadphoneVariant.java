package Entity;

public class HeadphoneVariant extends Variant{

    private String variantId;
    private String color;

    public HeadphoneVariant() {
    }

    public HeadphoneVariant(Specification specs, String variantId, String color) {
        super(specs);
        this.variantId = variantId;
        this.color = color;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
