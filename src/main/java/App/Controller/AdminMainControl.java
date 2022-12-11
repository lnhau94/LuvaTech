package App.Controller;

import Main.MainApp;
import Util.FaceRecognition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

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
        System.out.println("Account click");
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

    public void showStaffScreen(){
        try {
            MainApp.switchScene(new Scene(FXMLLoader.load(
                    new File("src/main/java/App/View/StaffMenu.fxml").toURI().toURL()))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkIn(){
        try {
            FaceRecognition.faceRecognition();
        } catch (InterruptedException e) {
            System.out.println("face recognize");
            System.out.println(e.getMessage());
        }
    }

}
