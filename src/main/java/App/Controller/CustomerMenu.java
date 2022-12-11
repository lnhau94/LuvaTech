package App.Controller;

import Main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerMenu implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SceneCustomerInfor(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerInfor.fxml").toURI().toURL())
        ));
    }
    public void SceneOrder(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/Orders.fxml").toURI().toURL())
        ));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
