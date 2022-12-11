package Entity;

public class Color {
    private String name;
    private String colorHexa;

    public Color(String name, String colorHexa) {
        this.name = name;
        this.colorHexa = colorHexa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorHexa() {
        return colorHexa;
    }

    public void setColorHexa(String colorHexa) {
        this.colorHexa = colorHexa;
    }
}
