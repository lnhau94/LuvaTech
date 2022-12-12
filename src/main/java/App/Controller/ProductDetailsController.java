package App.Controller;
import Entity.*;
import Main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ProductDetailsController implements Initializable {

    @FXML
    private AnchorPane RenderDetail;

    @FXML
    private ImageView productImage;

    @FXML
    private Label productPrice;
    @FXML
    private HBox hboxDetails;


    @FXML
    private Label productTitle;

    @FXML

    private TextField Quality;

    @FXML
    private Button minusBtn;

    @FXML
    private Button plusBtn;
    @FXML
    private HBox colorHbox;
    @FXML
    private AnchorPane laptop;
    @FXML
    private HBox ramHbox;
    @FXML
    private Button backBtn;

    @FXML
    private HBox storageHBox;
    private Product newProduct;

    //render Product Details View
    // new File("src/main/java/App/View/view-product.fxml").toURI().toURL())
    public AnchorPane setRenderDetail(Laptop laptop, Map<String, String> pathScreen ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(pathScreen.get("laptop")).toURI().toURL());
        AnchorPane anchorPane = fxmlLoader.load();
        laptopDetails laptopDetails = fxmlLoader.getController();
        laptopDetails.setData(laptop);
        return  anchorPane;
    }
    public AnchorPane setRenderDetail(Phone phone, Map<String, String> pathScreen) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(pathScreen.get("SmartPhone")).toURI().toURL());
        AnchorPane anchorPane = fxmlLoader.load();
        phoneDetails phoneDetails = fxmlLoader.getController();
        phoneDetails.setData(phone);
        return  anchorPane;
    }
    public AnchorPane setRenderDetail(SmartWatch smartWatch, Map<String, String> pathScreen) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(pathScreen.get("SmartWatch")).toURI().toURL());
        AnchorPane anchorPane = fxmlLoader.load();
        smartDetails smartDetails = fxmlLoader.getController();
        // smartDetails.setData(smartWatch);
        return  anchorPane;
    }
    public AnchorPane setRenderDetail(Headphone headphone,Map<String, String> pathScreen ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(pathScreen.get("headPhone")).toURI().toURL());
        AnchorPane anchorPane = fxmlLoader.load();
        headPhoneDetails headPhoneDetails = fxmlLoader.getController();
       // headPhoneDetails.setData(headphone);
        return  anchorPane;
    }
    public AnchorPane setRenderDetail(Keyboard keyboard,Map<String, String> pathScreen ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(pathScreen.get("keyboard")).toURI().toURL());
        AnchorPane anchorPane = fxmlLoader.load();
        keyboardDetail keyboardDetail = fxmlLoader.getController();
        return  anchorPane;
    }


    public void SwitchScreenDetails(Product product) throws IOException {

        Map<String, String> pathScreen = new HashMap<>();
        pathScreen.put("laptop", "src/main/java/App/View/laptopDetail.fxml");
        pathScreen.put("SmartPhone", "src/main/java/App/View/phoneDetail.fxml");
        pathScreen.put("keyboard", "src/main/java/App/View/keyboardDetail.fxml");
        pathScreen.put("SmartWatch", "src/main/java/App/View/smartDetails.fxml");
        pathScreen.put("headPhone", "src/main/java/App/View/headPhoneDetails.fxml");
        AnchorPane anchorPane = null;
        if (product instanceof Laptop) {
            anchorPane = setRenderDetail((Laptop) product, pathScreen);
        } else if (product instanceof SmartWatch) {
            anchorPane = setRenderDetail((SmartWatch) product, pathScreen);
        }else if(product instanceof Phone){
            anchorPane = setRenderDetail((Phone) product, pathScreen);
        }else if(product instanceof Headphone){
            anchorPane = setRenderDetail((Headphone) product, pathScreen);
        }else {
            anchorPane = setRenderDetail((Keyboard) product, pathScreen);
        }
        hboxDetails.getChildren().add(anchorPane);
    }


    //render product Details data
    public void setData(Product newProduct) throws IOException {
        Image newImage;
        if(newProduct != null){
            newImage = new Image(String.valueOf((new File(newProduct.getImgPath()).toURI()).toURL()));
        }else{
            newImage = new Image(String.valueOf((new File("src/main/java/Assets/Image/laptop/Laptop_Dell_XPS13_9320/dell-xps-1.jpg").toURI()).toURL()));
        }
        productImage.setImage(newImage);
        productTitle.setText(newProduct.getBrand().getBrandName());
        SwitchScreenDetails(newProduct);
    }
    public void backToShop(){
        backBtn.setOnAction(e->{
            try {
                MainApp.switchScene(new Scene(FXMLLoader.load(new File("src/main/java/App/View/view-product.fxml").toURI().toURL())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backToShop();
    }
    //back to Shop
//    public void backToShop(ActionEvent e)throws IOException{
//        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.centerOnScreen();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(new File("src/main/java/App/View/view-product.fxml").toURI().toURL());
//        Parent AccountViewParent = loader.load();
//        Scene scene = new Scene(AccountViewParent);
//        stage.setScene(scene);
 //   }



}
