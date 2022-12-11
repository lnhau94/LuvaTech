package App.Controller;

import App.Model.StaffModel;
import Entity.Attendance;
import Entity.SalaryGD;
import Main.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Salary implements Initializable {
    //Salary Table
    @FXML
    private ComboBox<String> ComboBoxMonth;
    ObservableList<String> monthlist = FXCollections.observableArrayList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
    @FXML
    private TableView SalaryTableView;
    @FXML
    private TableColumn salarystaffID;
    @FXML
    private TableColumn salarystaffName;
    @FXML
    private TableColumn salaryDate;
    @FXML
    private TableColumn salaryPay;
    @FXML
    public static ArrayList<SalaryGD> SalaryTableViewList;
    private ObservableList<SalaryGD> SalaryTable;
    //Attendance Table
    @FXML
    private TableView AttendanceTableView;
    @FXML
    private TableColumn staffID;
    @FXML
    private TableColumn staffName;
    @FXML
    private TableColumn attendanceCheckin;
    @FXML
    private TableColumn attendanceCheckout;
    @FXML
    private TableColumn attendanceWorkday;
    @FXML
    private DatePicker datePicker;
    @FXML
    public static ArrayList<Attendance> AttendanceTableViewList;
    @FXML
    public static ArrayList<Attendance> AttendanceTableViewList2;
    private ObservableList<Attendance> AttendanceTable;
    public void renderSalaryTable(){
        int  month = Month(ComboBoxMonth.getValue());
        SalaryTableViewList = StaffModel.getDataSalary(month);
        SalaryTable =  FXCollections.observableArrayList(SalaryTableViewList);
        salarystaffID.setCellValueFactory(new PropertyValueFactory<>("staffid"));
        salarystaffName.setCellValueFactory(new PropertyValueFactory<>("staffname"));
        salaryDate.setCellValueFactory(new PropertyValueFactory<>("hour"));
        salaryPay.setCellValueFactory(new PropertyValueFactory<>("pay"));
        SalaryTableView.setItems(SalaryTable);
    }
    public void  renderAttendance(){
        AttendanceTableViewList = StaffModel.getDataAttendance();
        AttendanceTable= FXCollections.observableArrayList(AttendanceTableViewList);
        staffID.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        attendanceCheckin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        attendanceCheckout.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        attendanceWorkday.setCellValueFactory(new PropertyValueFactory<>("workday"));
        AttendanceTableView.setItems(AttendanceTable);
    }
    public void renderAttendance2(javafx.event.ActionEvent event){
        LocalDate myDate = datePicker.getValue();
        AttendanceTableViewList2 = StaffModel.getDataAttendanceforDay(myDate);
        AttendanceTable= FXCollections.observableArrayList(AttendanceTableViewList2);
        staffID.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        attendanceCheckin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        attendanceCheckout.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        attendanceWorkday.setCellValueFactory(new PropertyValueFactory<>("workday"));
        AttendanceTableView.setItems(AttendanceTable);
    }
    public static int Month(String x){
        int tmp;
        switch (x){
            case "Jan":
                tmp=1;
                break;
            case "Feb":
                tmp=2;
                break;
            case "Mar":
                tmp =3;
                break;
            case "Apr":
                tmp=4;
                break;
            case "May":
                tmp=5;
                break;
            case "Jun":
                tmp=6;
                break;
            case "Jul":
                tmp=7;
                break;
            case "Aug":
                tmp=8;
                break;
            case "Sep":
                tmp=9;
                break;
            case "Oct":
                tmp=10;
                break;
            case "Nov":
                tmp=11;
                break;
            case "Dec" :
                tmp=12;
                break;
            default:
                tmp=1;
                break;
        }
        return  tmp;
    }
    public void SceneStaffMenu() throws IOException {
        MainApp.switchScene(new Scene(FXMLLoader.load(
                new File("src/main/java/App/View/StaffMenu.fxml").toURI().toURL())
        ));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.renderAttendance();

        ComboBoxMonth.setItems(monthlist);
    }

}
