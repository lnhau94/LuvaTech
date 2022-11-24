package Entity;

import java.util.ArrayList;

public class Phone extends Product{
    private String chip;
    private String screen;
    private String connect;
    private String os;
    private String material;
    private String battery;
    private String sim;
    private String camera;

    private ArrayList<PhoneVariant> variants;

    public Phone() {
    }

    public Phone(String productId, String productName, Brand brand, String chip, String screen,
                 String connect, String os, String material, String battery, String sim, String camera) {
        super(productId, productName, brand);
        this.chip = chip;
        this.screen = screen;
        this.connect = connect;
        this.os = os;
        this.material = material;
        this.battery = battery;
        this.sim = sim;
        this.camera = camera;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
