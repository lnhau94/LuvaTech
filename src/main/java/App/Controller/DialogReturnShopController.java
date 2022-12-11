package App.Controller;

import Main.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DialogReturnShopController implements Initializable {
    @FXML
    private Button BtnRenderOrder;

    @FXML
    private Button BtnReturnShop;

    @FXML
    private DialogPane DialogBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void renderShop(){
        BtnReturnShop.setOnAction(e->{
            try {
                MainApp.switchScene(new Scene(FXMLLoader.load(new File("src/main/java/App/View/view-product.fxml").toURI().toURL())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
