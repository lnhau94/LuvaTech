package App.Controller;

import App.Model.MainModel;
import Entity.Brand;
import Entity.Laptop;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
import javafx.util.StringConverter;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ResourceBundle;

public class LaptopFormControl implements Initializable {

    @FXML
    private ChoiceBox<Brand> brandsCb;

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

    private File file;
    private Laptop tmpLaptop;
    private boolean isNew;
    private AdminProductControl parent;

    public AdminProductControl getParent() {
        return parent;
    }

    public void setParent(AdminProductControl parent) {
        this.parent = parent;
    }

    public void setEditData(Laptop l){
        setData(l);
        ImageView img = null;
        try {
            img = new ImageView(new Image(new FileInputStream(tmpLaptop.getImgPath())));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        img.setFitWidth(50);
        img.setFitHeight(50);
        imagebtn.setGraphic(img);
        imagebtn.setPrefWidth(100);
    }
    public void setData(Laptop l){
        tmpLaptop = l;
        nametxt.setText(tmpLaptop.getProductName());
        cameratext.setText(tmpLaptop.getCamera());
        brandsCb.getSelectionModel().select(tmpLaptop.getBrand());
        cameratext.setText(tmpLaptop.getCamera());
        materialtxt.setText(tmpLaptop.getMaterial());
        ostxt.setText(tmpLaptop.getOs());
        sizetxt.setText(tmpLaptop.getSize());
        weighttxt.setText(tmpLaptop.getWeight());
        connecttxt.setText(tmpLaptop.getConnect());
        screentxt.setText(tmpLaptop.getScreen());
        cputxt.setText(tmpLaptop.getCpu());
    }

    public void setState(Boolean isNew){
        this.isNew = isNew;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okbtn.setOnAction(e->{
            if (isNew){
                Laptop laptop = new Laptop();
                getData(laptop);
                MainModel.productManager.getLaptopList().add(laptop);
                System.out.println(laptop.toString());
            }else{
                getData(tmpLaptop);
            }
            parent.updateProductList();
            ((Stage)okbtn.getScene().getWindow()).close();
        });
        cancelbtn.setOnAction(e->{
            cancelCreateNewLaptop(e);
        });
        brandsCb.setConverter(new StringConverter<>() {
            @Override
            public String toString(Brand brand) {
                return brand.getBrandName();
            }

            @Override
            public Brand fromString(String s) {
                for (Brand br : MainModel.brandManager.getBrandList()) {
                    if (br.getBrandName().equals(s)) {
                        return br;
                    }
                }

                return null;
            }
        });
        brandsCb.setItems(FXCollections.observableList(MainModel.brandManager.getBrandList()));
        brandsCb.getSelectionModel().select(0);
        brandsCb.getStyleClass().add("admin-choiceBox");
        imagebtn.setOnAction(e->{
            Platform.runLater(()->{
                FileChooser fileChooser = new FileChooser();
                file = fileChooser.showOpenDialog(((Button)e.getSource()).getScene().getWindow());
                if (file != null){
                    try {
                        ImageView img = new ImageView(new Image(new FileInputStream(file)));
                        img.setFitWidth(50);
                        img.setFitHeight(50);
                        imagebtn.setGraphic(img);
                        imagebtn.setPrefWidth(100);

                    } catch (FileNotFoundException ex) {
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

    public void getData(Laptop laptop){
        String name = nametxt.getText();
        Brand brand = brandsCb.getValue();
        String cpu = cputxt.getText();
        String screen = screentxt.getText();
        String size = sizetxt.getText();
        String os = ostxt.getText();
        String material = materialtxt.getText();
        String weight = weighttxt.getText();
        String camera = cameratext.getText();
        String connect = connecttxt.getText();
        laptop.setProductName(name);
        laptop.setCamera(camera);
        laptop.setBrand(brand);
        laptop.setCamera(camera);
        laptop.setMaterial(material);
        laptop.setOs(os);
        laptop.setSize(size);
        laptop.setWeight(weight);
        laptop.setConnect(connect);
        laptop.setScreen(screen);
        laptop.setCpu(cpu);
        if(file != null){
            try {
                laptop.setImgPath("src/main/java/Assets/Image/" + file.getName());
                copyFile(file,new File("src/main/java/Assets/Image/" + file.getName()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
    public void cancelCreateNewLaptop(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
}
