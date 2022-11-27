package Entity;

public abstract class Variant {
    protected Specification specs;
    protected String imgPath;

    public Variant() {
        specs = new Specification();
    }

    public Variant(Specification specs, String imgPath) {
        this.specs = specs;
        this.imgPath = imgPath;
    }

    public Variant(Specification specs) {
        this.specs = specs;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Specification getSpecs() {
        return specs;
    }

    public void setSpecs(Specification specs) {
        this.specs = specs;
    }
}
