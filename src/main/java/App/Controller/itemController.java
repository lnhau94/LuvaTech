package App.Controller;

import App.Model.ProductModel;
import Entity.Laptop;
import Entity.Phone;
import Entity.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class itemController {
    @FXML
    private ImageView imageproduct;

    @FXML
    private Label textCategory;

    @FXML
    private Label textCurrentPrice;

    @FXML
    private Label textName;

    @FXML
    private Label textPrice;

    public itemController() {
    }
    @FXML
    private void click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/ProductDetails.fxml").toURI().toURL());
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        ProductDetailsController controller = loader.getController();
        setDataLaptop(laptop);
        //setDataPhone(phone);
        stage.setScene(scene);
       // myListener.onClick(newProduct);
    }
    private Laptop laptop;
    private Phone phone;
    public void setDataLaptop( Laptop laptop) throws IOException {
        this.laptop = laptop;
        Image newImage;
        if(phone != null){
            newImage = new Image(String.valueOf((new File(laptop.getImgPath()).toURI()).toURL()));
        }else{
            newImage = new Image(String.valueOf((new File("src/main/java/Assets/Image/laptop/Laptop_Dell_XPS13_9320/dell-xps-1.jpg").toURI()).toURL()));
        }

      imageproduct.setImage(newImage);
        textCategory.setText("Laptop");
        textName.setText(laptop.getProductName());
      //  textCurrentPrice.setText(String.valueOf(laptop));
    }
    public void setDataPhone( Phone phone) throws IOException {
        this.phone = phone;
//        Image newImage = new Image(String.valueOf((new File(phone.getImgPath()).toURI()).toURL()));
//        imageproduct.setImage(newImage);
        textCategory.setText("Smart Phone");
        textName.setText(phone.getProductName());
     //   textCurrentPrice.setText(String.valueOf(laptop));
    }
}
