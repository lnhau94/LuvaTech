package App.Controller;

import Entity.PurchaseOrder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminItemPOController implements Initializable {
    @FXML
    private ImageView POIcon;

    @FXML
    private Label amount;

    @FXML
    private Label date;

    @FXML
    private Label orderId;

    @FXML
    private Label status;

    @FXML
    private Label vendor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setDataItem(PurchaseOrder po) {
        this.orderId.setText(po.getPurchaseOrderId());
        this.status.setText(po.getStatus());
        this.vendor.setText(po.getSupplierName());
        this.date.setText(po.getDate().toString());
        this.amount.setText(String.valueOf(po.getTotalPrice()));
    }

}
