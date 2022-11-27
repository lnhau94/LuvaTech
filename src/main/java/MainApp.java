import DAL.AccountDAO;
import DAL.ProductDAO;
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
import java.io.IOException;

public class MainApp extends Application {
    private static Stage mainStage;

    /**
     * Switch to new Scene - Chuyển Scene
     * @param newScene Scene cần hiển thị
     */
    public static void switchScene(Scene newScene){
        mainStage.setScene(newScene);
    }

    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void faceRecognition() throws InterruptedException{
        Process pr;
        pr = null;
        try {
            if (isWindows) {
                String currentDir = System.getProperty("user.dir") + "\\python";
                String command_windows = "cd " + currentDir + " && .\\Scripts\\activate" + " && python " + currentDir + "\\FaceRecognizer.py";
                pr = new ProcessBuilder("cmd.exe", "/c", command_windows).start();
            } else {
                String currentDir = System.getProperty("user.dir") + "/python_macOs";
                String command_mac = "cd " + currentDir + " && ./bin/activate" + " && python3.9 " + currentDir + "/FaceRecognizer.py";
                pr = new ProcessBuilder("/bin/zsh", "-c", command_mac).start();
            }
            pr.waitFor();
            pr.exitValue();
            pr.onExit();
        } catch (IOException e) {
            System.out.println("Error open model face recognize !!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("" + new Validation().checkPhone("+84965026920"));
//        faceRecognition();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainStage.setWidth(dim.getWidth());
        mainStage.setHeight(dim.getHeight());

        AccountDAO.retrieve();
        ProductDAO.retrieve();
        stage.setTitle("LuvaTech");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                StackPane pane = new StackPane();
                Button btn = new Button("hello");
                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        switchScene(root.getScene());
                                    }
                                }

                );
                pane.getChildren().add(btn);
                switchScene(new Scene(pane));
            }
        });
        stage.show();
    }
}
