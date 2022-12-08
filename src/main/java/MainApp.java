import App.Model.MainModel;
import DAL.AccountDAO;
import DAL.ProductDAO;
import Entity.Product;
import Util.Validation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MainApp extends Application {
    private static Stage mainStage;

    /**
     * Switch to new Scene - Chuyển Scene
     * @param newScene Scene cần hiển thị
     */
    public static void switchScene(Scene newScene){
        mainStage.setScene(newScene);
    }

    public static void main(String[] args) {
//        System.out.println("" + new Validation().checkPhone("+84965026920"));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        mainStage = stage;

//
//        AccountDAO.retrieve();
//        ProductDAO.retrieve();

//        MainModel.start();

//        stage.setTitle("LuvaTech");
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        stage.setScene(new Scene(root, 300, 250));
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                StackPane pane = new StackPane();
//                Button btn = new Button("hello");
//                btn.setOnAction(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent actionEvent) {
//                                        switchScene(root.getScene());
//                                    }
//                                }
//
//                );
//                pane.getChildren().add(btn);
//                switchScene(new Scene(pane));
//            }
//        });

        stage.setScene(new Scene(FXMLLoader.load(new File("src/main/java/App/View/StaffDetail.fxml").toURI().toURL())));

        stage.show();

    }
}
