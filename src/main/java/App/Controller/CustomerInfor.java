package App.Controller;

import App.Model.CustomerModel;
import App.Model.StaffModel;
import DAL.StaffDAO;
import Entity.Customer;
import Entity.Staff;
import Main.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerInfor implements Initializable {
    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, String> customerID;
    @FXML
    private TableColumn<Customer, String> customerName;
    @FXML
    private TableColumn<Customer, String> customerDob;
    @FXML
    private TableColumn<Customer, String> customerAddress;
    @FXML
    private TableColumn<Customer, String> customerPhone;

    public static ArrayList<Customer> CustomerTableViewList;
    private ObservableList<Customer> customerTable;
    public void rederCustomer() throws SQLException {
        CustomerTableViewList = CustomerModel.retrieve();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.rederCustomer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        customerTable= FXCollections.observableArrayList(CustomerTableViewList);
        customerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        customerDob.setCellValueFactory(new PropertyValueFactory<>("CustomerDob"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("CustomerPhone"));
        customerTableView.setItems(customerTable);
    }
    //    @FXML

    public void SceneCustomerAdd() throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerAdd.fxml").toURI().toURL())
        ));
    }
    public void SceneCustomerEdit() throws IOException {
        String id = customerTableView.getSelectionModel().getSelectedItem().getCustomerId();
        String name =customerTableView.getSelectionModel().getSelectedItem().getName();
        String address = customerTableView.getSelectionModel().getSelectedItem().getAddress();
        String phone = customerTableView.getSelectionModel().getSelectedItem().getPhone();
        Date dob = customerTableView.getSelectionModel().getSelectedItem().getBirthday();

        FXMLLoader fxmlLoader = new FXMLLoader(
                new File("src/main/java/App/View/CustomerEdit.fxml").toURI().toURL()
        );
        MainApp.switchScene(new Scene(fxmlLoader.load()));
        ((CustomerEdit)fxmlLoader.getController()).setCustomerText(
                id,name,dob,phone,address
        );

    }
    public void SceneCustomerDelete() throws IOException, SQLException {
        String id = customerTableView.getSelectionModel().getSelectedItem().getCustomerId();
        StaffModel staffModel = new StaffModel();
        staffModel.deleteStaff(id);
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerInfor.fxml").toURI().toURL())
        ));
    }
    public void SceneCustomerMenu() throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/CustomerMenu.fxml").toURI().toURL())
        ));
    }
}
