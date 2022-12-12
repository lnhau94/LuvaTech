package App.Controller;

import App.Model.CustomerModel;
import App.Model.StaffModel;
import Main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerEdit implements Initializable {
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerDob;
    @FXML
    private TextField customerAddress;
    @FXML
    private TextField customerPhone;

    private String SID,SName,SAddress,SPosition;
    private Date SDob;
    public void setCustomerText(String ID, String name, Date dob, String address, String phone) {
        customerName.setText(name);
        customerDob.setText(String.valueOf(dob));
        customerAddress.setText(address);
        customerPhone.setText(phone);
        SID = ID;
    }
    public void updateCustomer() throws SQLException, IOException, ParseException {
        CustomerModel customerModel = new CustomerModel();

        customerModel.editCustomer(SID,customerName.getText(),customerDob.getText(),customerAddress.getText(),customerPhone.getText() );
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerInfor.fxml").toURI().toURL())
        ));


    }
    public void SceneCustomerInfor(ActionEvent event) throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerInfor.fxml").toURI().toURL())
        ));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
