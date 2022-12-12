package App.Controller;

import com.sun.marlin.Dasher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Main.MainApp;
public class StaffMenu implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SceneStaffInfor(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
    }
    public void SceneSalary(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/Salary.fxml").toURI().toURL())
        ));
    }
    public void exit(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/adminMainView.fxml").toURI().toURL())
        ));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
