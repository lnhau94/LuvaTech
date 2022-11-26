package App.Controller;
import App.Model.StatisticProduct;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class StatisticProductController implements Initializable {
    @FXML
    private TableColumn<StatisticProduct, Date> date;

    @FXML
    private TableColumn<StatisticProduct, String> SKU;

    @FXML
    private TableColumn<StatisticProduct, Integer> price;

    @FXML
    private TableColumn<StatisticProduct, Integer> qty;

    @FXML
    private TableColumn<StatisticProduct, Integer> totalPrice;

    @FXML
    private TableView<StatisticProduct> tableStatisticProduct;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        date.setCellValueFactory(new PropertyValueFactory<StatisticProduct, Date>("date"));
        SKU.setCellValueFactory(new PropertyValueFactory<StatisticProduct, String>("SKU"));
        price.setCellValueFactory(new PropertyValueFactory<StatisticProduct, Integer>("price"));
        qty.setCellValueFactory(new PropertyValueFactory<StatisticProduct, Integer>("qty"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<StatisticProduct, Integer>("totalPrice"));
    }
}
