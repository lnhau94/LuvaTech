package App.Controller;

import App.Model.cartPage;
import App.View.Component.Component;

import DAL.ColorDAO;
import Entity.Color;
import Entity.Laptop;
import Entity.LaptopVariant;
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
    @FXML
    private Button addtoCart;

    String ramSelected;
    String storageSelected;
    String colorSelected;
    ArrayList<LaptopVariant> laptopVariants;
    HashSet<String> rams;
    HashSet<String> storages;
    HashSet<String> colors;
    Component component = new Component();
    cartPageController cartPageController= new cartPageController();
    public ArrayList<Color> colorsList = ColorDAO.retrieve();
    public void setData(Laptop product) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/Alert2.fxml").toURI().toURL());
        Pane alert = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        Alert2Controller alert2Controller = loader.getController();
        dialog.setDialogPane((DialogPane) alert);
        productTilte.setText(product.getProductName());
        rams=new HashSet<>();
        storages= new HashSet<>();
        colors=new HashSet<>();
        laptopVariants=product.getVariants();
        for(LaptopVariant item : laptopVariants){
            rams.add(item.getRam());
            storages.add(item.getStorage());
            colors.add(item.getColor());
        }
        renderRam(rams);
        renderStorage(filterStorage());
        renderColor(filterColor());
        renderSpecs();
        Description(product);
        addtoCart.setOnAction(e->{
            try {
                alert2Controller.RenderAlert("Success","B???n ch???c mu???n th??m v??o gi??? h??ng!");
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
    public void renderRam(HashSet<String> list) {
        ToggleGroup ramTG = new ToggleGroup();
        list.forEach((item)->{
            component.cusTomRB(item,ramTG);
            component.cusTomRB(item,ramTG).setSelected(true);
            ramSelected=item;
            component.cusTomRB(item,ramTG).setToggleGroup(ramTG);
            ramTG.selectToggle( component.cusTomRB(item,ramTG));
            renderHB.getChildren().add(component.cusTomRB(item,ramTG));
        });
        List<Node> ramRB = renderHB.getChildren().stream().toList();
        ramRB.forEach(n->{
            n.setOnMouseClicked(e->{
                ramSelected=((RadioButton) n).getText();
                System.out.println(ramSelected);
                renderStorage(filterStorage());
                renderColor(filterColor());
                renderSpecs();
            });
        });
    }
    public void renderStorage(HashSet<String> list){
        ToggleGroup StorageTG = new ToggleGroup();
        storageHB.getChildren().clear();
        list.forEach((item)->{
            component.cusTomRB(item,StorageTG);
            component.cusTomRB(item,StorageTG).setSelected(true);
            storageSelected=item;
            component.cusTomRB(item,StorageTG).setToggleGroup(StorageTG);
            storageHB.getChildren().add(component.cusTomRB(item,StorageTG));

        });
        List<Node> storageRB = storageHB.getChildren().stream().toList();
        storageRB.forEach(n->{
            n.setOnMouseClicked(e->{
                storageSelected=((RadioButton) n).getText();
                System.out.println(storageSelected);
                renderColor(filterColor());
                renderSpecs();
            });
        });
    }

    public void renderColor(HashSet<String> list){
        ToggleGroup colorTG = new ToggleGroup();
        colorHbox.getChildren().clear();
        list.forEach((item)->{
            component.ColorRB(item,colorsList,colorTG);
            component.ColorRB(item,colorsList,colorTG).setSelected(true);
            colorSelected=item;
            component.ColorRB(item,colorsList,colorTG).setToggleGroup(colorTG);
            colorHbox.getChildren().add(component.ColorRB(item,colorsList,colorTG));
        });
        List<Node> colorRB = colorHbox.getChildren().stream().toList();
        colorRB.forEach(n->{
            n.setOnMouseClicked(e->{
                colorSelected=((RadioButton) n).getText();
                System.out.println(colorRB);
                renderSpecs();
            });
        });
    }
    public void renderSpecs(){
        for (LaptopVariant item : laptopVariants){
            if(item.getRam().equals(ramSelected)  && item.getStorage().equals(storageSelected)  && item.getColor().equals(colorSelected) ){
                ProductPrice.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(
                        item.getSpecs().getPrice()
                ));
            }
        }
    }
    public HashSet<String> filterColor(){
        HashSet<String> set = new HashSet<>();
        for (LaptopVariant item : laptopVariants){
            if (item.getRam().equals(ramSelected)
                    && item.getStorage().equals(storageSelected)){
                set.add(item.getColor());
            }
        }
        return set;
    }

    public HashSet<String> filterStorage(){
        HashSet<String> s = new HashSet<>();
        for (LaptopVariant item : laptopVariants){
            if (item.getRam().equals(ramSelected)){
                s.add(item.getStorage());
            }
        }
        return s;
    }
    public void Description(Laptop laptop){
        String desc= "Camera:"+laptop.getCamera()+"\n" +
                "Material:"+laptop.getMaterial()+"\n" +
                "Connect:"+laptop.getConnect()+"\n" +
                "Os:"+laptop.getOs()+"\n" +
                "Size:"+laptop.getSize()+"\n" +
                "Weight:"+laptop.getWeight()+"\n";
        drscText.setText(desc);
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
    public  cartPage cart(Laptop product ) {
        cartPage cartItem = new cartPage();
        cartItem.setProductName(product.getProductName());
        for(LaptopVariant item : laptopVariants){
            if(item.getRam().equals(ramSelected)  && item.getStorage().equals(storageSelected)  && item.getColor().equals(colorSelected) ){
                cartItem.setProductSKU(item.getSpecs().getSKU());
                cartItem.setPrice(item.getSpecs().getPrice());
            }

        }
        cartItem.setQuantity(Integer.parseInt(Quality.getText()));
        cartItem.setDescription("Ram:"+ramSelected+"\n" +
                "Storage:"+storageSelected+"\n" +
                "Color:"+colorSelected+"\n");
        cartItem.setTotal(cartItem.getPrice()* cartItem.getQuantity());

        return cartItem;
    }

}