package App.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminMainControl {

    @FXML
    private Button adminAccountBtn;

    @FXML
    private Button adminBrandBtn;

    @FXML
    private Button adminProductBtn;

    @FXML
    void showAccountScreen(ActionEvent event) {
        System.out.println("account click");
    }

    @FXML
    void showBrandScreen(ActionEvent event) {
        System.out.println("brand click");
    }

    @FXML
    void showProductScreen(ActionEvent event) {
        System.out.println("product click");

    }

}
