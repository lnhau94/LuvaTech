package App.Controller;

import App.Model.ProductModel;
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
        controller.setData(newProduct);
        stage.setScene(scene);
            //myListener.onClick(newProduct);
    }
    private ProductModel newProduct;
    private MyListener myListener;
    public void setData(ProductModel newProduct, MyListener  myListener) throws IOException {
        this.newProduct = newProduct;
        this.myListener = myListener;
        Image newImage = new Image(String.valueOf((new File(newProduct.getImgSrc()).toURI()).toURL()));
        imageproduct.setImage(newImage);
        textCategory.setText(newProduct.getCpu());
        textName.setText(newProduct.getName());
        textCurrentPrice.setText(String.valueOf(newProduct.getPrice()));
    }
}
