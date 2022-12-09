package App.Controller;

import App.Model.MainModel;
import Entity.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Function;

public class AdminProductControl implements Initializable {
    ArrayList<Product> products;

    @FXML
    private TableView<Product> adminProductTable;
    @FXML
    private TableColumn<Product, String> productBrandCol;

    @FXML
    private TableColumn<Product, String> productIdCol;

    @FXML
    private TableColumn<Product, ImageView> productImageCol;

    @FXML
    private TableColumn<Product, String> productNameCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products = new ArrayList<>();

        productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productBrandCol.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getBrand()!=null
                        ?data.getValue().getBrand().getBrandName()
                        :""
        ));

        productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productImageCol.setCellValueFactory(data->
                new ObservableValue<ImageView>() {

                    @Override
                    public void addListener(InvalidationListener invalidationListener) {

                    }

                    @Override
                    public void removeListener(InvalidationListener invalidationListener) {

                    }

                    @Override
                    public void addListener(ChangeListener<? super ImageView> changeListener) {

                    }

                    @Override
                    public void removeListener(ChangeListener<? super ImageView> changeListener) {

                    }

                    @Override
                    public ImageView getValue() {
                        ImageView img = null;
                        try {
                            img =  new ImageView(new Image(new FileInputStream(data.getValue().getImgPath())));
                            img.setFitHeight(100);
                            img.setFitWidth(100);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return img;
                    }

                    @Override
                    public <U> ObservableValue<U> map(Function<? super ImageView, ? extends U> function) {
                        return ObservableValue.super.map(function);
                    }

                    @Override
                    public ObservableValue<ImageView> orElse(ImageView imageView) {
                        return ObservableValue.super.orElse(imageView);
                    }

                    @Override
                    public <U> ObservableValue<U> flatMap(Function<? super ImageView, ? extends ObservableValue<? extends U>> function) {
                        return ObservableValue.super.flatMap(function);
                    }
                }

        );
        productImageCol.setPrefWidth(120);
        productBrandCol.setPrefWidth(200);
        productIdCol.setPrefWidth(100);
        productNameCol.setPrefWidth(400);

        adminProductTable.setItems(FXCollections.observableList(products));
        updateProductList();


    }

    public void updateProductList(){
        products.clear();
        for(Laptop laptop : MainModel.productManager.getLaptopList()){
            products.add(laptop);
        }
        for(Phone item : MainModel.productManager.getPhoneList()){
            products.add(item);
        }
        for(SmartWatch item : MainModel.productManager.getSmartWatchList()){
            products.add(item);
        }
        for(Keyboard item : MainModel.productManager.getKeyboardList()){
            products.add(item);
        }
        for(Headphone item : MainModel.productManager.getHeadphoneList()){
            products.add(item);
        }

    }

}