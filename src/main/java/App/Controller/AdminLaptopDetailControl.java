package App.Controller;

import Entity.Laptop;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminLaptopDetailControl {

    @FXML
    private HBox colorChoiceContainer;

    @FXML
    private Label instockLabel;

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

    public void setData(Laptop laptop){

    }

}
