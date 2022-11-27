package Entity;

import java.util.ArrayList;

public class Laptop extends Product{
    private String screen;
    private String connect;
    private String os;
    private String material;
    private String size;
    private String weight;
    private String camera;

    private String cpu;

    private ArrayList<LaptopVariant> variants;



    public Laptop() {
        this.variants = new ArrayList<>();
    }

    public Laptop(String productId, String productName, Brand brand, String screen, String connect,
                  String os, String material, String size, String weight, String camera,String cpu,String imgPath) {
        super(productId, productName, brand,imgPath);
        this.screen = screen;
        this.connect = connect;
        this.os = os;
        this.material = material;
        this.size = size;
        this.weight = weight;
        this.camera = camera;
        this.cpu = cpu;
        this.variants = new ArrayList<>();
    }

    public ArrayList<LaptopVariant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<LaptopVariant> variants) {
        this.variants = variants;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
