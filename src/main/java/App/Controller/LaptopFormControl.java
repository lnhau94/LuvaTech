package App.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ResourceBundle;

public class LaptopFormControl implements Initializable {

    @FXML
    private ChoiceBox<String> brandsCb;

    @FXML
    private TextField cameratext;

    @FXML
    private TextField cputxt;

    @FXML
    private Button imagebtn;

    @FXML
    private TextField materialtxt;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField ostxt;
    @FXML
    private TextField connecttxt;
    @FXML
    private TextField screentxt;

    @FXML
    private TextField sizetxt;

    @FXML
    private TextField weighttxt;

    @FXML
    private Button cancelbtn;

    @FXML
    private Button okbtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okbtn.setOnAction(e->{
            createNewLaptop();
        });
        cancelbtn.setOnAction(e->{
            cancelCreateNewLaptop(e);
        });
        imagebtn.setOnAction(e->{
            Platform.runLater(()->{
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(((Button)e.getSource()).getScene().getWindow());
                if (file != null){
                    try {
                        ImageView img = new ImageView(new Image(new FileInputStream(file)));
                        img.setFitWidth(50);
                        img.setFitHeight(50);
                        imagebtn.setGraphic(img);
                        imagebtn.setPrefWidth(100);
//                        copyFile(file,new File("src/main/java/Assets/Image/" + file.getName()));

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        });
    }

    public static void copyFile(File in, File out) throws IOException {
        FileChannel inChannel = new FileInputStream(in).getChannel();
        FileChannel outChannel = new FileOutputStream(out).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (IOException e) {
            throw e;
        } finally {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    }

    public void createNewLaptop(){
        String name = nametxt.getText();
        String brand = brandsCb.getValue();
        String cpu = cputxt.getText();
        String screen = screentxt.getText();
        String size = sizetxt.getText();
        String os = ostxt.getText();
        String material = materialtxt.getText();
        String weight = weighttxt.getText();
        String camera = cameratext.getText();
        String connect = connecttxt.getText();

        System.out.println(name + brand + cpu + screen + size + os + material + weight + camera + connect);

    }
    public void cancelCreateNewLaptop(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
}
