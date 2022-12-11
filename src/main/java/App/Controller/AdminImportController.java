package App.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminImportController implements Initializable {

    @FXML
    private AnchorPane container;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadContainerView("src/main/java/App/View/AdminImportViews/component/AdminPOView.fxml");
    }

    public void loadContainerView(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.setLocation(new File(fxmlPath).toURI().toURL());
            VBox vbox = fxmlLoader.load();
            container.getChildren().add(vbox);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
