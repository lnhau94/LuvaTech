package App.Controller;

import Entity.OrderDetails;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminOrderDetailControl implements Initializable {

    @FXML
    private TableColumn<OrderDetails, String> SKUColumn;

    @FXML
    private TableView<OrderDetails> orderDetailTable;

    @FXML
    private TableColumn<OrderDetails, String> priceColumn;

    @FXML
    private TableColumn<OrderDetails, String> qtyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SKUColumn.setCellValueFactory(data->new SimpleStringProperty(
                data.getValue().getSKU()
        ));
        qtyColumn.setCellValueFactory(data->new SimpleStringProperty(
                String.valueOf(data.getValue().getQty())
        ));
    }

    public void setData(ArrayList<OrderDetails> od){
        orderDetailTable.setItems(FXCollections.observableList(od));
        orderDetailTable.refresh();
    }
}
