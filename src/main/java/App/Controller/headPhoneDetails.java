package App.Controller;

import App.View.Component.Component;
import Entity.Headphone;
import Entity.SmartWatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class headPhoneDetails {
    @FXML
    private Label ProductPrice;

    @FXML
    private TextField Quality;

    @FXML
    private AnchorPane laptop;

    @FXML
    private Button minusBtn;

    @FXML
    private Button plusBtn;

    @FXML
    private Label productTitle;

    @FXML
    private HBox renderColor;
    Component component = new Component();
    ToggleGroup colorTG = new ToggleGroup();
    //plusBtn
    public void Plus(ActionEvent e) {
        if (Quality.getText().equalsIgnoreCase("")) {
            Quality.setText("1");
        }
        int inputValue = Integer.parseInt(Quality.getText());
        inputValue += 1;
        Quality.setText(String.valueOf(inputValue));

    }

    //minusBtn
    public void Minus(ActionEvent e) {
        int inputValue = Integer.parseInt(Quality.getText());
        if (inputValue > 1) {
            inputValue -= 1;
            Quality.setText(String.valueOf(inputValue));
        }
    }
//    public void setData(Headphone product){
//        productTitle.setText(product.getProductName());
//        List<String> colorList = new ArrayList<String>();
//        colorList.add("#2f3640");
//        colorList.add("#fbc531");
//        colorList.add("#dcdde1");
//        colorList.add("#f5f6fa");
//        for (int i = 0; i < colorList.size(); i++) {
//            renderColor.getChildren().add(component.ColorRB(colorList.get(i),colorTG));
//        }
//
//    }
}
