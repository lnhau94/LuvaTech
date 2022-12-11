package App.Controller;

import Entity.Laptop;
import Entity.LaptopVariant;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class AdminLaptopDetailControl {

    @FXML
    private HBox colorChoiceContainer;

    @FXML
    private Label instockLabel;

    @FXML
    private TextArea laptopInfoTxt;

    @FXML
    private Label laptopBrand;

    @FXML
    private ImageView laptopImage;

    @FXML
    private Label laptopName;

    @FXML
    private Label priceLabel;

    @FXML
    private HBox ramChoiceContainer;

    @FXML
    private HBox storageChoiceContainer;

    @FXML
    private FlowPane sumarryInfoContainer;

    @FXML
    private VBox variantChoiceContainer;

    @FXML
    private FlowPane variantInfoContainer;

    ArrayList<LaptopVariant> variants;
    HashSet<String> rams;
    HashSet<String> storages;
    HashSet<String> colors;

    String ramChoice;
    String colorChoice;
    String storageChoice;


    public void setData(Laptop laptop){
        laptopName.setText(laptop.getProductName());
        laptopBrand.setText(laptop.getBrand().getBrandName());
        variants = laptop.getVariants();
        rams = new HashSet<>();
        storages = new HashSet<>();
        colors = new HashSet<>();
        for(LaptopVariant item : variants){
            rams.add(item.getRam());
            storages.add(item.getStorage());
            colors.add(item.getColor());
        }

        renderRamChoice(rams);
        renderStorage(filterStorage());
        renderColor(filterColor());
        renderSpecs();
        laptopInfoTxt.setText(laptop.toString());

    }

    private void renderRamChoice(HashSet<String> list){
        ToggleGroup gr = new ToggleGroup();
        for (String ram : list){
            ToggleButton btn = new ToggleButton(ram);
            btn.setSelected(true);
            ramChoice = ram;
            btn.setToggleGroup(gr);
            btn.getStyleClass().add("admin-toggle-button");

            ramChoiceContainer.getChildren().add(btn);
            btn.setOnAction(e -> {
                ramChoice = ((ToggleButton)e.getSource()).getText();
                renderStorage(filterStorage());
                renderColor(filterColor());
                renderSpecs();
            });

        }

    }

    private void renderStorage(HashSet<String> list){
        ToggleGroup gr = new ToggleGroup();
        storageChoiceContainer.getChildren().clear();
        for (String st : list){
            ToggleButton btn = new ToggleButton(st);
            btn.setSelected(true);
            btn.getStyleClass().add("admin-toggle-button");
            storageChoice = st;
            btn.setToggleGroup(gr);
            storageChoiceContainer.getChildren().add(btn);
            btn.setOnAction(e->{
                storageChoice = ((ToggleButton)e.getSource()).getText();
                renderColor(filterColor());
                renderSpecs();
            });
        }
    }

    private void renderColor(HashSet<String> list){
        ToggleGroup gr = new ToggleGroup();
        colorChoiceContainer.getChildren().clear();
        for (String cl : list){
            ToggleButton btn = new ToggleButton(cl);
            btn.setSelected(true);
            btn.getStyleClass().add("admin-toggle-button");
            colorChoice = cl;
            btn.setToggleGroup(gr);
            colorChoiceContainer.getChildren().add(btn);
            btn.setOnAction(e->{
                colorChoice = ((ToggleButton)e.getSource()).getText();
                renderSpecs();
            });
        }
    }

    private void renderSpecs(){
        for(LaptopVariant item : variants){
            if ( item.getRam().equals(ramChoice)
                    && item.getStorage().equals(storageChoice)
                    && item.getColor().equals(colorChoice)){
                priceLabel.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(
                        item.getSpecs().getPrice()
                ));
                instockLabel.setText(String.valueOf(
                        item.getSpecs().getInStock()
                ));

                try {
                    System.out.println(item.getImgPath());
                    laptopImage.setImage(
                            new Image(
                                    new FileInputStream(
                                            item.getImgPath()!=null
                                            ?item.getImgPath()
                                            :"src/main/java/Assets/Image/icon/connection.png"
                                    )));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public HashSet<String> filterColor(){
        HashSet<String> set = new HashSet<>();
        for (LaptopVariant item : variants){
            if (item.getRam().equals(ramChoice)
                    && item.getStorage().equals(storageChoice)){
                set.add(item.getColor());
            }
        }
        return set;
    }

    public HashSet<String> filterStorage(){
        HashSet<String> s = new HashSet<>();
        for (LaptopVariant item : variants){
            if (item.getRam().equals(ramChoice)){
                s.add(item.getStorage());
            }
        }
        return s;
    }

}
