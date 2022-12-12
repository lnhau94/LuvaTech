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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private String SID,SName,SAddress,SPosition;
    private Date SDob;
    public void setStaffText(String ID, String name, String address, String positon, Date dob) {
        staffname.setText(name);
        staffdob.setText(String.valueOf(dob));
        staffaddress.setText(address);
        staffposition.setText(positon);
        SID = ID;
//        System.out.println("\n" + ID);
    }
    public void updateStaff() throws SQLException, IOException, ParseException {
        StaffModel staffModel = new StaffModel();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        staffModel.editStaff(SID,staffname.getText(),staffaddress.getText(),Integer.parseInt(staffposition.getText()),dateFormat.parse(staffdob.getText()) );
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
//        System.out.println("\n" + SID);

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
