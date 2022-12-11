package App.Controller;

import App.Model.MainModel;
import Entity.Brand;
import Entity.Laptop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BrandFormControl implements Initializable {

    @FXML
    private Button cancelbtn;

    @FXML
    private TextField countrytxt;

    @FXML
    private TextField nametxt;

    @FXML
    private Button okbtn;
    private Brand tmpBrand;

    private boolean isNew;
    private AdminBrandControl parent;

    public void setState(boolean isNew){
        this.isNew = isNew;
    }

    public AdminBrandControl getParent() {
        return parent;
    }

    public void setParent(AdminBrandControl parent) {
        this.parent = parent;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okbtn.setOnAction(e->{
            if (isNew){
                Brand brand = new Brand();
                getData(brand);
                MainModel.brandManager.addNewBrand(brand);
            }else{
                getData(tmpBrand);
            }
            parent.updateBrandList();
            ((Stage)okbtn.getScene().getWindow()).close();
        });
        cancelbtn.setOnAction(e->{
            ((Stage)cancelbtn.getScene().getWindow()).close();
        });
    }

    private void getData(Brand brand) {
        brand.setBrandName(nametxt.getText());
        brand.setBrandCountry(countrytxt.getText());
    }

    public void setData(Brand selectedItem) {
        tmpBrand = selectedItem;
        nametxt.setText(tmpBrand.getBrandName());
        countrytxt.setText(tmpBrand.getBrandCountry());
    }
}
