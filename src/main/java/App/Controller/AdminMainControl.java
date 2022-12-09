package App.Controller;

import Main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;


public class AdminMainControl {

    @FXML
    private Button adminAccountBtn;

    @FXML
    private Button adminBrandBtn;

    @FXML
    private Button adminProductBtn;

    @FXML
    void showAccountScreen(ActionEvent event) {
        System.out.println("account click");
    }

    @FXML
    void showBrandScreen(ActionEvent event) {
        System.out.println("brand click");
    }

    @FXML
    void showProductScreen(ActionEvent event) {
        try {
            MainApp.switchScene(new Scene(FXMLLoader.load(
                    new File("src/main/java/App/View/adminProductView.fxml").toURI().toURL()))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
