package App.Controller;

import  Entity.Staff;
import App.Model.StaffModel;
import Main.MainApp;
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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StaffEdit implements Initializable{
    @FXML
    private TextField staffname;
    @FXML
    private TextField staffdob;
    @FXML
    private TextField staffaddress;
    @FXML
    private TextField staffposition;

    private String tmp;
    public void setStaffText(String ID) throws IOException {
        tmp = ID;
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffEdit.fxml").toURI().toURL())
        ));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        staffname.setText(tmp);
//        staffdob.setText(String.valueOf(tmp));
//        staffaddress.setText(tmp);
//        staffposition.setText(tmp);
        showData();
    }
    public void showData(){
        staffname.setText(tmp);
        staffdob.setText(String.valueOf(tmp));
        staffaddress.setText(tmp);
        staffposition.setText(tmp);
    }
}
