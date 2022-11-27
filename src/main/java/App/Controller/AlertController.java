package App.Controller;

import App.Model.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
public class AlertController {
    @FXML
    private Label statusLabel;
    @FXML
    private Label informationLabel;
    @FXML
    private ImageView image;
    @FXML
    private Button cancelButton;

    private ArrayList<Alert> getDataAlert() {
       ArrayList<Alert> alertList = new ArrayList<Alert>();
       alertList.add(new Alert("Error","#c0392b","aaaa"));
        alertList.add(new Alert("Warning","#f1c40f","aaaa"));
        alertList.add(new Alert("Success","#27ae60","aaaa"));
        return alertList;
    }
    public boolean RenderAlert(String status, String information) throws MalformedURLException {
        ArrayList<Alert> alerts = getDataAlert();
        for (Alert alert : alerts) {
            if (alert.getStatus().equalsIgnoreCase(status)) {
                alert.setInformation(information);
                statusLabel.setText(alert.getStatus());
                informationLabel.setText(alert.getInformation());
                image.setImage(new Image(String.valueOf(new File(alert.getImgSrc()).toURI().toURL())));
                return true;
            }
        }
        return false;
    }
}
