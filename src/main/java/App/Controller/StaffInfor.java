package App.Controller;

import DAL.DAO;
import DAL.StaffDAO;
import Entity.Staff;
import App.Controller.StaffEdit;
import App.Controller.StaffDetail;

import java.awt.event.ActionEvent;
import java.sql.Struct;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import  java.util.ResourceBundle;

import Main.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    Integer index ;
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
//    public void getDetails(MouseEvent event) throws IOException {
////        index = staffTableView.getSelectionModel().getSelectedIndex();
//        if (event.getClickCount() == 2){ //double click
////                String id = staffTableView.getSelectionModel().getSelectedItem().getStaffId();
////                String name = staffTableView.getSelectionModel().getSelectedItem().getName();
////                String address = staffTableView.getSelectionModel().getSelectedItem().getAddress();
////                String position = staffTableView.getSelectionModel().getSelectedItem().getPosition();
////                Date dob = staffTableView.getSelectionModel().getSelectedItem().getBirthday();
////                Staff staff1 = new Staff(id,name,address,position, (java.sql.Date) dob);
//                Date date = new Date();
//                Staff staff = new Staff("12","DaJid","Paris","Project Manager", (java.sql.Date) date);
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/App/View/StaffDetail.fxml"));
//                Parent parent = loader.load();
//                StaffDetail staff2 = (StaffDetail) loader.getController();
//                staff2.setDetail(staff);
//                Stage stage = new Stage();
//                stage.setScene(new Scene(parent));
//                stage.setTitle("Second Window");
//                stage.show();
//            }
//        }
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

        StaffEdit staffEdit = new StaffEdit();
        staffEdit.setStaffText(id);
        staffEdit.showData();
    }
    public void SceneStaffDelete(){

    }


}
