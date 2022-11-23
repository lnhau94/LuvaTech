import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hello extends Application {

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=luvashop",
                            "postgres", "postgres");

            stmt = c.createStatement();
            String sql = "select * from specification";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Anh vô địch");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
