package App.Controller;

import App.View.Component.Component;

import Entity.Laptop;
import Entity.LaptopVariant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class laptopDetails {

    @FXML
    private Label ProductPrice;

    @FXML
    private TextField Quality;

    @FXML
    private HBox colorHbox;

    @FXML
    private TextArea drscText;

    @FXML
    private AnchorPane laptop;

    @FXML
    private Button minusBtn;

    @FXML
    private Button plusBtn;

    @FXML
    private Label productTilte;

    @FXML
    private HBox renderHB;

    @FXML
    private HBox storageHB;
    ToggleGroup ramTG = new ToggleGroup();
    ToggleGroup StorageTG = new ToggleGroup();
    ToggleGroup colorTG = new ToggleGroup();
    Component component = new Component();
    public void setData(Laptop product) {
        productTilte.setText(product.getProductName());
        RadioButton ramSelected = new RadioButton();
        ArrayList<LaptopVariant> laptopVariants = product.getVariants();
        List<String> ramList=null;
        ProductController.details.clear();
        for (int i = 0; i < laptopVariants.size(); i++) {
            ProductController.addDetails(laptopVariants.get(i).getRam(), laptopVariants.get(i).getStorage(), laptopVariants.get(i).getColor());
            }
        ramList = ProductController.details.keySet().stream().toList();
       Ram(ramList);
        }

public void Ram(List<String> ramList) {
        if (ramList.size()>0){
           ramList.forEach((ram)->{
               renderHB.getChildren().add( component.cusTomRB(ram,ramTG));
           });
        }else{
            System.out.println("is empty");
        }
        List<Node> ramRadioButtons = renderHB.getChildren().stream().toList();
        if (ramTG.getSelectedToggle()==null){
            ramTG.selectToggle((Toggle) ramRadioButtons.get(0));
            RadioButton radioButton = (RadioButton) ramTG.getSelectedToggle();
            Storage(radioButton);
        }
    for (Node radio : ramRadioButtons) {
        radio.setOnMouseClicked(e -> {
            ramTG.selectToggle((Toggle) radio);
            RadioButton radioButton = (RadioButton) ramTG.getSelectedToggle();
            storageHB.getChildren().clear();
            Storage(radioButton);
        });
    }
    }
    public void Storage(RadioButton ramRB){
        String ram = ramRB.getText();
        List<HashMap<String, List<String>>> storageColor = ProductController.details.get(ram);
       storageColor.forEach(stringListHashMap ->
       {
        addDetails(stringListHashMap.keySet().stream().toList(),StorageTG,storageHB);
           List<Node> storageRB = storageHB.getChildren().stream().toList();
           if (StorageTG.getSelectedToggle()==null){
               StorageTG.selectToggle((Toggle) storageRB.get(0));
               colorHbox.getChildren().clear();
           }
           for (Node radio : storageRB) {
               radio.setOnMouseClicked(e -> {
                   StorageTG.selectToggle((Toggle) radio);
                   RadioButton radioButton = (RadioButton) StorageTG.getSelectedToggle();
                   colorHbox.getChildren().clear();

               });

           }
       });

    }

    private void Color(List<String>colorHas) {
       addDetails(colorHas,colorTG,colorHbox);
        List<Node> colorRB = colorHbox.getChildren().stream().toList();
        if (colorTG.getSelectedToggle()==null){
            colorTG.selectToggle((Toggle) colorRB.get(0));
            RadioButton radioButton = (RadioButton) colorTG.getSelectedToggle();
            Price();
        }
        for (Node radio : colorRB) {
            radio.setOnMouseClicked(e -> {
                colorTG.selectToggle((Toggle) radio);
                RadioButton radioButton = (RadioButton) colorTG.getSelectedToggle();
                Price();
            });
        }
    }
    public void Price(){
        RadioButton ram= (RadioButton) ramTG.getSelectedToggle();
        RadioButton storage= (RadioButton) StorageTG.getSelectedToggle();
        RadioButton color= (RadioButton) colorTG.getSelectedToggle();
        System.out.println(ram.getText()+storage.getText()+color.getText());
    }

    /**
     * Hien thi cac danh sach cau hinh
     * @param list (cac item trong list)
     * @param rb  (Toggle Group)
     * @param renderHB (giao dien hien thi HBOX)
     * @return
     */
    public boolean addDetails(List<String> list, ToggleGroup rb, HBox renderHB){
        if (list.size()>0){
            list.forEach((item)->{
                renderHB.getChildren().add(component.cusTomRB(item,rb));
            });
            return true;
        }else{
            System.out.println("Storage is emty");
            return  false;
        }
    }

    public void Description(Laptop laptop){
        laptop.getCamera();
        laptop.getConnect();
    }
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


}