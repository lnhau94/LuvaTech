package App.Controller;

import App.Model.MainModel;
import Entity.Account;
import Entity.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountFormControl implements Initializable {

    @FXML
    private Button cancelbtn;

    @FXML
    private TextField cfpasswordtxt;

    @FXML
    private Button okbtn;

    @FXML
    private ChoiceBox<Staff> ownerChoice;

    @FXML
    private TextField passwordtxt;

    @FXML
    private TextField usernametxt;

    private Account tmpAccount;

    private AdminAccountControl parent;
    private boolean isNew;

    public void setState(Boolean isNew){
        this.isNew = isNew;
    }

    public AdminAccountControl getParent() {
        return parent;
    }

    public void setParent(AdminAccountControl parent) {
        this.parent = parent;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okbtn.getStyleClass().add("admin-function-button");
        cancelbtn.getStyleClass().add("admin-function-button");
        ownerChoice.setConverter(new StringConverter<Staff>() {
            @Override
            public String toString(Staff staff) {
                return staff.getName();
            }

            @Override
            public Staff fromString(String s) {
                return null;
            }
        });
        ownerChoice.setItems(FXCollections.observableList(MainModel.staffManager.getStaffList()));
        ownerChoice.getSelectionModel().select(0);

        cancelbtn.setOnAction(e->{
            ((Stage)cancelbtn.getScene().getWindow()).close();
        });

        okbtn.setOnAction(e->{
            if(isNew){
                Account acc = new Account();
                getData(acc);
                MainModel.accountManager.addAccount(acc,ownerChoice.getSelectionModel().getSelectedItem());

            }else{
                getData(tmpAccount);
            }
            parent.updateAccountList();
            ((Stage)okbtn.getScene().getWindow()).close();
        });
    }

    public void getData(Account account){
        account.setUsername(usernametxt.getText());
        account.setPassword(passwordtxt.getText());
    }

    public void setData(Account account){
        tmpAccount = account;
        usernametxt.setText(tmpAccount.getUsername());
        passwordtxt.setText(tmpAccount.getPassword());
        cfpasswordtxt.setText(tmpAccount.getPassword());
        ownerChoice.setValue(findByUsername(tmpAccount.getUsername()));
    }
    private Staff findByUsername(String username){
        for (Staff st : MainModel.staffManager.getStaffList()){
            if(st.getAccount() != null && st.getAccount().getUsername().equals(username)){
                return st;
            }
        }
        return null;
    }

}
