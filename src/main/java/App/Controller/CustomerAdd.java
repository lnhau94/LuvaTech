package App.Controller;

import App.Model.CustomerModel;
import App.Model.StaffModel;
import Main.MainApp;
import Util.FaceRecognition;
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
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerAdd implements Initializable {
    @FXML
    private TextField txtCusName;
    @FXML
    private TextField txtCusAddress;
    @FXML
    private TextField txtCusDob;
    @FXML
    private TextField txtCusPhone;

    public void add() throws SQLException, IOException, InterruptedException {
        String name = txtCusName.getText();
        String address = txtCusAddress.getText();
        String  birthday =  txtCusDob.getText();
        String phone = txtCusPhone.getText();
        CustomerModel customerModel = new CustomerModel();
        customerModel.addCustomer(name,birthday,address,phone);
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
