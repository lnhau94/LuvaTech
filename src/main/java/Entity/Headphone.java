package Entity;

public class Headphone extends Product{

    private String useTime;
    private String boxTime;
    private String os;
    private String charger;
    private String connect;
    private String headphoneControl;

    public Headphone() {
    }

    public Headphone(String productId, String productName, Brand brand, String useTime, String boxTime,
                     String os, String charger, String connect, String headphoneControl) {
        super(productId, productName, brand);
        this.useTime = useTime;
        this.boxTime = boxTime;
        this.os = os;
        this.charger = charger;
        this.connect = connect;
        this.headphoneControl = headphoneControl;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getBoxTime() {
        return boxTime;
    }

    public void setBoxTime(String boxTime) {
        this.boxTime = boxTime;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getHeadphoneControl() {
        return headphoneControl;
    }

    public void setHeadphoneControl(String headphoneControl) {
        this.headphoneControl = headphoneControl;
    }
}