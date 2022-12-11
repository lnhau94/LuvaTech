package App.Controller;

import App.Model.MainModel;
import Entity.*;
import Main.MainApp;
import javafx.beans.property.SimpleStringProperty;
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

public class AdminAccountControl implements Initializable {

    @FXML
    private TableView<Account> accountTable;

    @FXML
    private BorderPane accountScreen;

    @FXML
    private TableColumn<Account, String> ownerColumn;

    @FXML
    private TableColumn<Account, String> passwordColumn;

    @FXML
    private TableColumn<Account, String> usernameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        ownerColumn.setCellValueFactory(data->new SimpleStringProperty(
                findByUsername(data.getValue().getUsername()) == null
                        ?""
                        :findByUsername(data.getValue().getUsername()).getName()
        ));

        updateAccountList();
        renderBackToMenu();
        renderActionChoice();
    }

    public void renderActionChoice(){
        Button addBtn = new Button("Add");
        Button editBtn = new Button("Edit");
        Button removeBtn = new Button("Remove");

        FlowPane flowPane = new FlowPane(addBtn,editBtn,removeBtn);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setPrefHeight(50);
        accountScreen.setTop(flowPane);

        addBtn.getStyleClass().add("admin-function-button");
        editBtn.getStyleClass().add("admin-function-button");
        removeBtn.getStyleClass().add("admin-function-button");

        addBtn.setOnAction(e->{
            showAccountForm();

        });

        editBtn.setOnAction(e->{
            if(accountTable.getSelectionModel().getSelectedIndex()>=0){
                showEditAccountForm(accountTable.getSelectionModel().getSelectedItem());
            }
        });

        removeBtn.setOnAction(e->{
            MainModel.accountManager.getAccountsTable().remove(
                    findByUsername(accountTable.getSelectionModel().getSelectedItem().getUsername()).getStaffId());
            updateAccountList();
        });
    }

    private void showEditAccountForm(Account selectedItem) {
        Stage secondStage = new Stage(StageStyle.UNDECORATED);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newAccountForm.fxml").toURI().toURL());

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));
            ((AccountFormControl)fxmlLoader.getController()).setState(false);
            ((AccountFormControl)fxmlLoader.getController()).setData(selectedItem);
            ((AccountFormControl)fxmlLoader.getController()).setParent(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        secondStage.initModality(Modality.NONE);
        secondStage.setAlwaysOnTop(true);
        secondStage.initOwner(MainApp.mainStage);
        secondStage.show();
    }

    private void showAccountForm() {
        Stage secondStage = new Stage(StageStyle.UNDECORATED);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    new File("src/main/java/App/View/newAccountForm.fxml").toURI().toURL())
                    ;

            secondStage.setScene(new Scene(
                    fxmlLoader.load()
            ));
            ((AccountFormControl)fxmlLoader.getController()).setState(true);
            ((AccountFormControl)fxmlLoader.getController()).setParent(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        secondStage.initModality(Modality.NONE);
        secondStage.setAlwaysOnTop(true);
        secondStage.initOwner(MainApp.mainStage);
        secondStage.show();
    }

    private Staff findByUsername(String username){
        for (Staff st : MainModel.staffManager.getStaffList()){
            if(st.getAccount() != null && st.getAccount().getUsername().equals(username)){
                return st;
            }
        }
        return null;
    }
    public void renderBackToMenu(){
        Button backBtn = new Button("Back");
        FlowPane flowPane = new FlowPane(backBtn);
        flowPane.setAlignment(Pos.BOTTOM_LEFT);
        accountScreen.setBottom(flowPane);

        backBtn.setOnAction(e-> {
            MainApp.switchScene(MainApp.AdminScene);
        });
    }

    public void updateAccountList() {
        accountTable.setItems(FXCollections.observableList(MainModel.accountManager.getAccountsTable().values().stream().toList()));
        accountTable.refresh();
    }
}
