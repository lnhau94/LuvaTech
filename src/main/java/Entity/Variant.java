package Entity;

public abstract class Variant {
    protected Specification specs;

    public Variant() {
        specs = new Specification();
    }

    public Variant(Specification specs) {
        this.specs = specs;
    }

    public Specification getSpecs() {
        return specs;
    }

    public void setSpecs(Specification specs) {
        this.specs = specs;
    }
}
