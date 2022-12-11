package App.Controller;

import App.Model.MainModel;
import Entity.Brand;
import Main.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminBrandControl implements Initializable {

    @FXML
    private TableView<Brand> brandTable;
    @FXML
    private BorderPane brandView;

    @FXML
    private TableColumn<Brand, String> countryColumn;

    @FXML
    private TableColumn<Brand, String> idColumn;

    @FXML
    private TableColumn<Brand, String> nameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("brandId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("brandCountry"));
        renderActionChoice();
        updateBrandList();
        renderBackToMenu();

    }
    public void renderActionChoice(){
        Button addBtn = new Button("Add");
        Button editBtn = new Button("Edit");
        Button removeBtn = new Button("Remove");

        FlowPane flowPane = new FlowPane(addBtn,editBtn,removeBtn);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setPrefHeight(50);
        brandView.setTop(flowPane);

        addBtn.getStyleClass().add("admin-function-button");
        editBtn.getStyleClass().add("admin-function-button");
        removeBtn.getStyleClass().add("admin-function-button");

        addBtn.setOnAction(e->{
            showBrandForm();

        });

        editBtn.setOnAction(e->{
            if(brandTable.getSelectionModel().getSelectedIndex()>=0){
                showEditBrandForm(brandTable.getSelectionModel().getSelectedItem());
            }
        });

        removeBtn.setOnAction(e->{
            updateBrandList();
        });
    }

    public void updateBrandList() {
        brandTable.setItems(FXCollections.observableList(MainModel.brandManager.getBrandList()));
        brandTable.refresh();
    }

    private void showEditBrandForm(Brand selectedItem) {
        Stage secondStage = new Stage(StageStyle.UNDECORATED);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newBrandForm.fxml").toURI().toURL())
                    ;

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));
            ((BrandFormControl)fxmlLoader.getController()).setData(selectedItem);
            ((BrandFormControl)fxmlLoader.getController()).setState(false);
            ((BrandFormControl)fxmlLoader.getController()).setParent(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        secondStage.initModality(Modality.NONE);
        secondStage.setAlwaysOnTop(true);
        secondStage.initOwner(MainApp.mainStage);
        secondStage.show();
    }


    private void showBrandForm() {
        Stage secondStage = new Stage(StageStyle.UNDECORATED);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newBrandForm.fxml").toURI().toURL())
                    ;

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));
            ((BrandFormControl)fxmlLoader.getController()).setState(true);
            ((BrandFormControl)fxmlLoader.getController()).setParent(this);
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
        brandView.setBottom(flowPane);

        backBtn.setOnAction(e-> {
            MainApp.switchScene(MainApp.AdminScene);
        });
    }
}
