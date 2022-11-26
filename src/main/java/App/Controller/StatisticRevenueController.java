package App.Controller;
import App.Model.StatisticRevenue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class StatisticRevenueController implements Initializable {
    @FXML
    private TableColumn<StatisticRevenue, Date> date;

    @FXML
    private TableColumn<StatisticRevenue, Integer> qtyLaptop;

    @FXML
    private TableColumn<StatisticRevenue, Integer> qtyHeadphone;

    @FXML
    private TableColumn<StatisticRevenue, Integer> qtyKeyboard;

    @FXML
    private TableColumn<StatisticRevenue, Integer> qtyPhone;

    @FXML
    private TableColumn<StatisticRevenue, Integer> qtySmartwatch;

    @FXML
    private TableColumn<StatisticRevenue, Integer> totalQty;

    @FXML
    private TableColumn<StatisticRevenue, Integer> totalPrice;

    @FXML
    private TableView<StatisticRevenue> tableStatisticRevenue;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        date.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Date>("date"));
        qtyLaptop.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("qtyLaptop"));
        qtyHeadphone.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("qtyHeadphone"));
        qtyKeyboard.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("qtyKeyboard"));
        qtyPhone.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("qtyPhone"));
        qtySmartwatch.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("qtySmartwatch"));
        totalQty.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("totalQty"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<StatisticRevenue, Integer>("totalPrice"));
    }
}
