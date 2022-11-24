package Entity;

public class SmartWatchVariant extends Variant{
    private String variantId;
    private String edition;
    private String color;

    public SmartWatchVariant() {
    }

    public SmartWatchVariant(Specification specs, String variantId, String edition, String color) {
        super(specs);
        this.variantId = variantId;
        this.edition = edition;
        this.color = color;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
