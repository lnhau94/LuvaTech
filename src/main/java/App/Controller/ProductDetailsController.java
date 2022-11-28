package App.Controller;
import Entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDetailsController {

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
    private HBox storageHBox;
    private Product newProduct;

    //render Product Details View
   // new File("src/main/java/App/View/view-product.fxml").toURI().toURL())
    public void SwitchScreenDetails(Product product) throws IOException {

        Map<String, String> pathScreen = new HashMap<>();
        pathScreen.put("laptop","src/main/java/App/View/laptopDetail.fxml");
        pathScreen.put("SmartPhone","src/main/java/App/View/laptopDetail.fxml");
        pathScreen.put("keyboard","src/main/java/App/View/keyboardDetail.fxml");
        pathScreen.put("SmartWatch","src/main/java/App/View/smartDetails.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        if(product instanceof Phone){
            fxmlLoader.setLocation(new File(pathScreen.get("laptop")).toURI().toURL());
            AnchorPane anchorPane= fxmlLoader.load();
            laptopDetails laptopDetails =fxmlLoader.getController();
            laptopDetails.setData(product);
            hboxDetails.getChildren().add(anchorPane);
        }else if(product instanceof Laptop){
            System.out.println("Check");
            fxmlLoader.setLocation(new File(pathScreen.get("laptop")).toURI().toURL());
            AnchorPane anchorPane1= fxmlLoader.load();
            keyboardDetail keyboardDetail = fxmlLoader.getController();
            keyboardDetail.setData(product);
            hboxDetails.getChildren().add(anchorPane1);

        }else if(product instanceof SmartWatch){
            fxmlLoader.setLocation(new File(pathScreen.get("SmartWatch")).toURI().toURL());
            AnchorPane anchorPane2= fxmlLoader.load();
            smartDetails smartDetails = fxmlLoader.getController();
            smartDetails.setData(product);
            hboxDetails.getChildren().add(anchorPane2);

        }else {
            fxmlLoader.setLocation(new File(pathScreen.get("SmartWatch")).toURI().toURL());
            AnchorPane anchorPane2= fxmlLoader.load();
            smartDetails smartDetails = fxmlLoader.getController();
            smartDetails.setData(product);
            hboxDetails.getChildren().add(anchorPane2);
        }
//        switch (I){
//            case  "laptop":
//
//                break;
//            case  "keyboard":
//
//               break;
//            case  "SmartWatch":
//
//                break;
//           default:
//                System.out.printf("Code sai roi leu leu");
//        }
    }

    //render product Details data
    public void setData(Product newProduct) throws IOException {
        productTitle.setText(newProduct.getProductName());
       // Image newImage = new Image(String.valueOf(new File(newProduct.getImgSrc()).toURI().toURL()));
     //   productImage.setImage(newImage);
        SwitchScreenDetails(newProduct);
    }
    //back to Shop
    public void backToShop(ActionEvent e)throws IOException{
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/view-product.fxml").toURI().toURL());
        Parent AccountViewParent = loader.load();
        Scene scene = new Scene(AccountViewParent);
        stage.setScene(scene);
    }



}
