package Entity;

import java.util.ArrayList;

public class Keyboard extends Product{
    private String led;
    private String keycap;
    private String os;
    private String battery;

    ArrayList<KeyboardVariant> variants;

    public Keyboard() {
    }

    public Keyboard(String productId, String productName, Brand brand, String led,
                    String keycap, String os, String battery, String imgPath) {
        super(productId, productName, brand, imgPath);
        this.led = led;
        this.keycap = keycap;
        this.os = os;
        this.battery = battery;
    }

    public ArrayList<KeyboardVariant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<KeyboardVariant> variants) {
        this.variants = variants;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }

    public String getKeycap() {
        return keycap;
    }

    public void setKeycap(String keycap) {
        this.keycap = keycap;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
