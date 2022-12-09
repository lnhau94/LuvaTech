package App.Controller;

import App.View.Component.Component;

import Entity.Keyboard;
import Entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class keyboardDetail {
    @FXML
    private TextField Quality;
    @FXML
    private Label productTilte;
    @FXML
    private AnchorPane laptop;

    @FXML
    private Button minusBtn;

    @FXML
    private Button plusBtn;

    @FXML
    private Label productPrice;

    @FXML
    private HBox renderColor;

    @FXML
    private ComboBox<String> renderSwitch;
    Component component = new Component();
    ToggleGroup colorTG = new ToggleGroup();
    ToggleGroup switchTG = new ToggleGroup();

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

    public void setData(Keyboard product) {
        {
            productTilte.setText(product.getProductName());
            ObservableList<String> switchListRender;
            List<String> switchList = new ArrayList<String>();
            switchList.add("Red Switch");
            switchList.add("Blue Switch");
            switchList.add("Black Switch");
            switchListRender = FXCollections.observableList(switchList);
            List<String> colorList = new ArrayList<String>();
            colorList.add("#2f3640");
            colorList.add("#fbc531");
            colorList.add("#dcdde1");
            colorList.add("#f5f6fa");
            Map<String, String> colors = new HashMap<String, String>();
            colors.put("den", "#2f3640");
            colors.put("vang", "#fbc531");
            colors.put("xam", "#dcdde1");
            colors.put("bac", "#f5f6fa");
            renderSwitch.setItems(switchListRender);
            for (int i = 0; i < colorList.size(); i++) {
                renderColor.getChildren().add(component.ColorRB(colorList.get(i), colorTG));
            }
            renderSwitch.setOnMouseClicked(e->{
                System.out.printf("Switch color:"+renderSwitch.getValue());
            });
        }
    }
}