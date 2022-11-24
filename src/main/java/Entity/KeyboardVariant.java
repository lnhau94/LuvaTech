package Entity;

public class KeyboardVariant extends Variant{
    private String Switch;
    private String color;

    public KeyboardVariant() {
    }

    public KeyboardVariant(Specification specs, String aSwitch, String color) {
        super(specs);
        Switch = aSwitch;
        this.color = color;
    }

    public String getSwitch() {
        return Switch;
    }

    public void setSwitch(String aSwitch) {
        Switch = aSwitch;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
