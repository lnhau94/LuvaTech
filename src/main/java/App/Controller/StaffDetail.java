package App.Controller;

import Entity.Staff;
import Main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import javafx.scene.control.
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StaffDetail {
    @FXML
    private Label txtName;
    @FXML
    private Label txtAddress;
    @FXML
    private Label txtPosition;
    @FXML
    private Label txtDob;
    public void  setDetail(String ID, String name, String address, String positon, Date dob) {
        txtName.setText(name);
        txtAddress.setText(address);
        txtPosition.setText(positon);
        txtDob.setText(String.valueOf(dob));
    }
    public void SceneStaffInfor(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
    }

}
