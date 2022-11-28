package App.Controller;

import com.sun.javafx.stage.EmbeddedWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.application.Application.launch;

public class StaffMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../App/View/StaffMenu.fxml"));

    }
    public static void main(String[] args) {
        launch(args);
    }
}
