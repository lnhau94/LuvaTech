package App.Controller;

import App.Model.StaffModel;
import DAL.DAO;
import DAL.StaffDAO;
import Entity.*;

import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import  java.util.ResourceBundle;

import Main.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.*;

public class StaffInfor implements Initializable {
    @FXML
    private TableView<Entity.Staff> staffTableView;
    @FXML
    private TableColumn<Staff, String> staffID;
    @FXML
    private TableColumn<Staff, String> staffName;
    @FXML
    private TableColumn<Staff, String> staffDob;
    @FXML
    private TableColumn<Staff, String> staffAddress;
    @FXML
    private TableColumn<Staff, String> staffPosition;

    public static ArrayList<Entity.Staff> StaffTableViewList;
    private ObservableList<Entity.Staff> staffTable;
    public void rederStaff() throws SQLException {
        StaffTableViewList = StaffDAO.retrieve();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.rederStaff();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        staffTable= FXCollections.observableArrayList(StaffTableViewList);
        staffID.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffDob.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        staffTableView.setItems(staffTable);
    }
//    @FXML
    public void SceneStaffDetails(javafx.scene.input.MouseEvent event) throws IOException {
        if (event.getClickCount() == 2){ //double click
                String id = staffTableView.getSelectionModel().getSelectedItem().getStaffId();
                String name = staffTableView.getSelectionModel().getSelectedItem().getName();
                String address = staffTableView.getSelectionModel().getSelectedItem().getAddress();
                String position = staffTableView.getSelectionModel().getSelectedItem().getPosition();
                Date dob = staffTableView.getSelectionModel().getSelectedItem().getBirthday();
//                Staff staff1 = new Staff(id,name,address,position, (java.sql.Date) dob);
                FXMLLoader fxmlLoader = new FXMLLoader(
                        new File("src/main/java/App/View/StaffDetail.fxml").toURI().toURL()
                );
                MainApp.switchScene(new Scene(fxmlLoader.load()));
                ((StaffDetail)fxmlLoader.getController()).setDetail(
                        id,name,address,position,dob
                );
            }
        }
    public void SceneStaffAdd() throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffAdd.fxml").toURI().toURL())
        ));
    }
    public void SceneStaffEdit() throws IOException {
        String id = staffTableView.getSelectionModel().getSelectedItem().getStaffId();
        String name = staffTableView.getSelectionModel().getSelectedItem().getName();
        String address = staffTableView.getSelectionModel().getSelectedItem().getAddress();
        String position = staffTableView.getSelectionModel().getSelectedItem().getPosition();
        Date dob = staffTableView.getSelectionModel().getSelectedItem().getBirthday();

//        Staff staff = new Staff(id,name,address,position,dob);
        FXMLLoader fxmlLoader = new FXMLLoader(
                new File("src/main/java/App/View/StaffEdit.fxml").toURI().toURL()
        );
        MainApp.switchScene(new Scene(fxmlLoader.load()));
        ((StaffEdit)fxmlLoader.getController()).setStaffText(
                id,name,address,position,dob
        );

    }
    public void SceneStaffDelete() throws IOException, SQLException {
        String id = staffTableView.getSelectionModel().getSelectedItem().getStaffId();
        StaffModel staffModel = new StaffModel();
        staffModel.deleteStaff(staffTableView.getSelectionModel().getSelectedItem().getStaffId());
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffInfor.fxml").toURI().toURL())
        ));
    }
    public void SceneStaffMenu() throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffMenu.fxml").toURI().toURL())
        ));
    }


}
