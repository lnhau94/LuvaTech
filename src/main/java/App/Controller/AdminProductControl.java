package App.Controller;

import App.Model.MainModel;
import Entity.*;
import Main.MainApp;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Function;

public class AdminProductControl implements Initializable {
    ArrayList<Product> products;

    @FXML
    private BorderPane productScreen;
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
        BorderPane.setMargin(productScreen.getCenter(),new Insets(0,0,0,0));
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


        adminProductTable.setOnMouseClicked(e->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(
                        new File("src/main/java/App/View/adminLaptopDetailView.fxml").toURI().toURL()
                );
                VBox v = fxmlLoader.load();
                v.setMaxHeight(10000);
                BorderPane.setMargin(v,new Insets(0,0,0,0));
                productScreen.setRight(
                      v
                );
                ((AdminLaptopDetailControl)fxmlLoader.getController()).setData(
                        (Laptop) adminProductTable.getSelectionModel().getSelectedItem()
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        renderActionChoice();
        renderBackToMenu();
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
        adminProductTable.setItems(FXCollections.observableList(products));
        adminProductTable.refresh();


    }

    public void renderActionChoice(){
        Button addBtn = new Button("Add");
        Button editBtn = new Button("Edit");
        Button removeBtn = new Button("Remove");

        FlowPane flowPane = new FlowPane(addBtn,editBtn,removeBtn);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setPrefHeight(50);
        productScreen.setTop(flowPane);

        addBtn.getStyleClass().add("admin-function-button");
        editBtn.getStyleClass().add("admin-function-button");
        removeBtn.getStyleClass().add("admin-function-button");

        addBtn.setOnAction(e->{
            showLaptopForm();

        });

        editBtn.setOnAction(e->{
            if(adminProductTable.getSelectionModel().getSelectedIndex()>=0){
                showEditLaptopForm((Laptop) adminProductTable.getSelectionModel().getSelectedItem());
            }

        });

        removeBtn.setOnAction(e->{
            if(adminProductTable.getSelectionModel().getSelectedIndex()>=0){
                if (adminProductTable.getSelectionModel().getSelectedItem() instanceof Laptop){
                    MainModel.productManager.getLaptopList().remove(adminProductTable.getSelectionModel().getSelectedItem());

                }
                if (adminProductTable.getSelectionModel().getSelectedItem() instanceof Phone){
                    MainModel.productManager.getPhoneList().remove(adminProductTable.getSelectionModel().getSelectedItem());

                }
                if (adminProductTable.getSelectionModel().getSelectedItem() instanceof Headphone){
                    MainModel.productManager.getHeadphoneList().remove(adminProductTable.getSelectionModel().getSelectedItem());

                }
                if (adminProductTable.getSelectionModel().getSelectedItem() instanceof Keyboard){
                    MainModel.productManager.getKeyboardList().remove(adminProductTable.getSelectionModel().getSelectedItem());

                }
                if (adminProductTable.getSelectionModel().getSelectedItem() instanceof SmartWatch){
                    MainModel.productManager.getSmartWatchList().remove(adminProductTable.getSelectionModel().getSelectedItem());

                }
                updateProductList();
            }
        });
    }

    public void showEditLaptopForm(Laptop laptop) {
        Stage secondStage = new Stage(StageStyle.UNDECORATED);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newLaptopForm.fxml").toURI().toURL())
            ;

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));

            ((LaptopFormControl)fxmlLoader.getController()).setEditData(laptop);
            ((LaptopFormControl)fxmlLoader.getController()).setState(false);
            ((LaptopFormControl)fxmlLoader.getController()).setParent(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        secondStage.initModality(Modality.NONE);
        secondStage.setAlwaysOnTop(true);
        secondStage.initOwner(MainApp.mainStage);
        secondStage.show();
    }

    public void showLaptopForm(){
        Stage secondStage = new Stage(StageStyle.UNDECORATED);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newLaptopForm.fxml").toURI().toURL())
                    ;

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));
            ((LaptopFormControl)fxmlLoader.getController()).setState(true);
            ((LaptopFormControl)fxmlLoader.getController()).setParent(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        secondStage.initModality(Modality.NONE);
        secondStage.setAlwaysOnTop(true);
        secondStage.initOwner(MainApp.mainStage);
        secondStage.show();
    }

    public void renderBackToMenu(){
        Button backBtn = new Button("Back");
        FlowPane flowPane = new FlowPane(backBtn);
        flowPane.setAlignment(Pos.BOTTOM_LEFT);
        productScreen.setBottom(flowPane);

        backBtn.setOnAction(e-> {
                    MainApp.switchScene(MainApp.AdminScene);
        });
    }
}
