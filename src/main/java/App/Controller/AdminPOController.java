package App.Controller;

import App.Model.MainModel;
import Entity.PurchaseOrder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminPOController implements Initializable {
    @FXML
    private Label date;
    @FXML
    private VBox POAllLayout;
    @FXML
    private VBox POConfirmLayout;
    @FXML
    private VBox POPendingLayout;
    @FXML
    private VBox purchaseOrderLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        render();
    }

    public void render() {
        renderAllPO();
    }

    public void renderAllPO() {
        ArrayList<PurchaseOrder> purchaseOrderList = MainModel.purchaseOrderManagement.getPurchaseOrderList();
        for(int i = 0; i < 20; i++) {
            System.out.println(1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            try {
                fxmlLoader.setLocation(new File(
                        "src/main/java/App/View/AdminImportViews/component/ItemPO.fxml").toURI().toURL());
                HBox hbox = fxmlLoader.load();
                POAllLayout.getChildren().add(hbox);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        for (PurchaseOrder purchaseOrder : purchaseOrderList) {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            try {
//                fxmlLoader.setLocation(new File(
//                        "src/main/java/App/View/AdminImportViews/component/ItemPO.fxml").toURI().toURL());
//                AdminItemPOController itemPOController = fxmlLoader.getController();
//                itemPOController.setDataItem(purchaseOrder);
//                HBox hbox = fxmlLoader.load();
//                POAllLayout.getChildren().add(hbox);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
