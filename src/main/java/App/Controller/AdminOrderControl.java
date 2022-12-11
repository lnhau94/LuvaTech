package App.Controller;

import App.Model.MainModel;
import Entity.Order;
import Entity.OrderDetails;
import Main.MainApp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AdminOrderControl implements Initializable {

    @FXML
    private TableColumn<Order, String> customerColumn;

    @FXML
    private TableColumn<Order, Date> dateColumn;

    @FXML
    private BorderPane orderScreen;

    @FXML
    private TableColumn<Order, String> idColumn;

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, String> staffColumn;

    @FXML
    private TableColumn<Order, String> totalPriceColumn;

    private AdminOrderDetailControl odController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerColumn.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getCustomer() != null ? data.getValue().getCustomer().getName():""
        ));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        staffColumn.setCellValueFactory(data ->new SimpleStringProperty(
                data.getValue().getCashier() != null
                        ? data.getValue().getCashier().getName()
                        :""
        ));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        orderTable.setItems(FXCollections.observableList(MainModel.orderManager.getOrderList()));
        renderBackToMenu();
        showDetail();
        orderTable.setOnMouseClicked(e->{
            if(orderTable.getSelectionModel().getSelectedIndex()>=0){
                odController.setData(orderTable.getSelectionModel().getSelectedItem().getDetails());
            }
        });
    }
    public void renderBackToMenu(){
        Button backBtn = new Button("Back");
        FlowPane flowPane = new FlowPane(backBtn);
        flowPane.setAlignment(Pos.BOTTOM_LEFT);
        orderScreen.setBottom(flowPane);

        backBtn.setOnAction(e-> {
            MainApp.switchScene(MainApp.AdminScene);
        });
    }
    public void showDetail(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/adminOrderDetail.fxml").toURI().toURL());
            TableView<OrderDetails> tb = fxmlLoader.load();
            tb.getStyleClass().add("admin-order-detail-table");
            odController = fxmlLoader.getController();
            orderScreen.setRight(tb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
