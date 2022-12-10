package App.Controller;

import  Entity.Staff;
import App.Model.StaffModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StaffAdd implements Initializable{
    @FXML
    private TextField txtStaffName;
    @FXML
    private TextField txtStaffAddress;
    @FXML
    private TextField txtStaffDob;
    @FXML
    private TextField txtStaffPos;

    public void add() throws SQLException {
        String name = txtStaffName.getText();
        String address = txtStaffAddress.getText();
        String birthday = txtStaffDob.getText();
        String position = txtStaffPos.getText();
        StaffModel staffModel = new StaffModel();
        staffModel.addStaff(name,address,position,birthday);
        System.out.println(name+" "+address+" "+birthday+" "+position);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
