package App.Controller;

import  Entity.Staff;
import App.Model.StaffModel;
import Main.MainApp;
import Util.FaceRecognition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Util.FaceRecognition.faceRecognition;

public class StaffAdd implements Initializable{
    @FXML
    private TextField txtStaffName;
    @FXML
    private TextField txtStaffAddress;
    @FXML
    private TextField txtStaffDob;
    @FXML
    private TextField txtStaffPos;

    public void add() throws SQLException, IOException, InterruptedException {
        String name = txtStaffName.getText();
        String address = txtStaffAddress.getText();
        String birthday = txtStaffDob.getText();
        String position = txtStaffPos.getText();
        StaffModel staffModel = new StaffModel();
        staffModel.addStaff(name,address,position,birthday);
        FaceRecognition.newUser();
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
    }
    public void SceneStaffInfor(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
