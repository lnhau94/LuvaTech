package App.Controller;

import Main.MainApp;
import Util.FaceRecognition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminMainControl implements Initializable {

    @FXML
    private Button adminAccountBtn;

    @FXML
    private Button adminBrandBtn;

    @FXML
    private Button adminProductBtn;
    @FXML
    private Button checkinBtn;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMenu();
    }
    public void showMenu(){
        Stage mainMenu = new Stage(StageStyle.UNDECORATED);
        Button shopBtn = new Button("Shop");
        Button adminBtn = new Button("Admin");
        VBox v = new VBox(shopBtn,adminBtn,checkinBtn);
        mainMenu.setScene(new Scene(v));
        try {
            mainMenu.getScene().getStylesheets().add(
                    new File("src/main/java/App/View/css/adminComponent.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        shopBtn.setOnAction(e->{
            MainApp.switchScene(MainApp.ShopScene);
            MainApp.mainStage.setMaximized(true);
        });
        adminBtn.setOnAction(e->{
            MainApp.switchScene(MainApp.AdminScene);
            MainApp.mainStage.setMaximized(true);
        });

        shopBtn.getStyleClass().add("admin-function-button");
        adminBtn.getStyleClass().add("admin-function-button");
        checkinBtn.getStyleClass().add("admin-function-button");
        v.getStyleClass().add("admin-nav");
        v.setSpacing(5);
        v.setOnMouseEntered(e->{
            mainMenu.sizeToScene();
        });
        v.setOnMouseExited(e->{
            mainMenu.sizeToScene();
        });
        mainMenu.setAlwaysOnTop(true);
        mainMenu.setX(0);
        mainMenu.setY(0);
        mainMenu.initOwner(MainApp.mainStage);
        mainMenu.show();
    }
}
