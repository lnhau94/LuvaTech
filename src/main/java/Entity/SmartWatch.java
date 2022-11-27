package Entity;

import java.util.ArrayList;

public class SmartWatch extends Product{

    private String screen;
    private String frontGlass;
    private String os;
    private String battery;

    private ArrayList<SmartWatchVariant> variants;

    public SmartWatch() {
    }

    public SmartWatch(String productId, String productName, Brand brand, String screen,
                      String frontGlass, String os, String battery) {
        super(productId, productName, brand);
        this.screen = screen;
        this.frontGlass = frontGlass;
        this.os = os;
        this.battery = battery;
    }

    public ArrayList<SmartWatchVariant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<SmartWatchVariant> variants) {
        this.variants = variants;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getFrontGlass() {
        return frontGlass;
    }

    public void setFrontGlass(String frontGlass) {
        this.frontGlass = frontGlass;
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
