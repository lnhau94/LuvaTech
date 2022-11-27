package App.Controller;
import App.Model.StatisticCategory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticCategoryController implements Initializable {
    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private AnchorPane anchorPaneRight;

    @FXML
    private AnchorPane anchorPaneLeft;

    @FXML
    private TableColumn<StatisticCategory, String> name;

    @FXML
    private TableColumn<StatisticCategory, Integer> qty;

    @FXML
    private TableColumn<StatisticCategory, Integer> totalPrice;

    @FXML
    private TableView<StatisticCategory> tableStatisticCategory;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        name.setCellValueFactory(new PropertyValueFactory<StatisticCategory, String>("name"));
        qty.setCellValueFactory(new PropertyValueFactory<StatisticCategory, Integer>("qty"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<StatisticCategory, Integer>("totalPrice"));
    }
}
