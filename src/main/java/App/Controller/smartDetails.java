package App.Controller;

import App.Model.cartPage;
import App.View.Component.Component;

import DAL.ColorDAO;
import Entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.util.*;

public class smartDetails {
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
    String colorSelected;
    HashSet<String> colors;
    @FXML
    private HBox renderColor;

    @FXML
    private Label desrcText;
    @FXML
   private Button addtoCart;
    cartPageController cartPageController= new cartPageController();
    public ArrayList<Color> colorsList = ColorDAO.retrieve();
    ArrayList<SmartWatchVariant> Variants;
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
    public void setData(SmartWatch product) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/Alert2.fxml").toURI().toURL());
        Pane alert = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        Alert2Controller alert2Controller = loader.getController();
        dialog.setDialogPane((DialogPane) alert);
        productTitle.setText(product.getProductName());
        colors=new HashSet<>();
        Variants=product.getVariants();
        for(SmartWatchVariant item : Variants){
            colors.add(item.getColor());
        }
        renderColor(colors);
        renderSpecs();
        Description(product);
        addtoCart.setOnAction(e->{
            try {
                alert2Controller.RenderAlert("Success","Bạn chắc muốn thêm vào giỏ hàng!");
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get()== ButtonType.OK){
                cartPageController.addToCart(cart(product));
                dialog.close();
            }else if(clickedButton.get()== ButtonType.CANCEL){
                dialog.close();
            }

        });
    }
    public cartPage cart(SmartWatch product ) {
        cartPage cartItem = new cartPage();
        cartItem.setProductName(product.getProductName());
        for(SmartWatchVariant item : Variants){
            if( item.getColor().equals(colorSelected) ){
                cartItem.setProductSKU(item.getSpecs().getSKU());
                cartItem.setPrice(item.getSpecs().getPrice());
            }
        }
        cartItem.setQuantity(Integer.parseInt(Quality.getText()));
        cartItem.setDescription("Color:"+colorSelected+"\n");
        cartItem.setTotal(cartItem.getPrice()* cartItem.getQuantity());
        return cartItem;
    }
    public void renderColor(HashSet<String> list){
        ToggleGroup colorTG = new ToggleGroup();
        renderColor.getChildren().clear();
        list.forEach((item)->{
            component.ColorRB(item,colorsList,colorTG);
            component.ColorRB(item,colorsList,colorTG).setSelected(true);
            colorSelected=item;
            component.ColorRB(item,colorsList,colorTG).setToggleGroup(colorTG);
            renderColor.getChildren().add(component.ColorRB(item,colorsList,colorTG));
        });
        List<Node> colorRB = renderColor.getChildren().stream().toList();
        colorRB.forEach(n->{
            n.setOnMouseClicked(e->{
                colorSelected=((RadioButton) n).getText();
                System.out.println(colorRB);
                renderSpecs();
            });
        });
    }
    public void Description(SmartWatch smartWatch){
        String  desc= "Screen:"+smartWatch.getScreen()+"\n" +
                "Battery:"+smartWatch.getBattery()+"\n" +
                "FrontGlass:"+smartWatch.getFrontGlass()+"\n";
        desrcText.setText(desc);
    }
    public void renderSpecs(){
        for (SmartWatchVariant item : Variants){
            if( item.getColor().equals(colorSelected) ){
                ProductPrice.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(
                        item.getSpecs().getPrice()
                ));
            }
        }
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
