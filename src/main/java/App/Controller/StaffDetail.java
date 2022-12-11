package App.Controller;

import Entity.Staff;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
//import javafx.scene.control.
import java.awt.*;
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
//    public void  setDetail(Staff staff) {
//        txtName.setText(staff.getName());
//        txtAddress.setText(staff.getAddress());
//        txtPosition.setText(staff.getPosition());
//        txtDob.setText(String.valueOf(staff.getBirthday()));
//    }
    public void display(String name){
        txtName.setText(name);
    }
}
