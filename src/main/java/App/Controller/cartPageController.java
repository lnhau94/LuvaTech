package App.Controller;

import App.Model.MainModel;
import App.Model.cartPage;
import Entity.Customer;
import Logic.CustomerManagement;
import Logic.OrderManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class cartPageController implements Initializable {
    @FXML
    private TableView<cartPage> cartTable;
    @FXML
    private TableColumn<cartPage, String> description;

    @FXML
    private TableColumn<cartPage, Void> editCol;

    @FXML
    private TableColumn<cartPage, String> productId;

    @FXML
    private TableColumn<cartPage, String> productName;

    @FXML
    private TableColumn<cartPage, Integer> quality;

    @FXML
    private TableColumn<cartPage, Integer> total;
    @FXML
    private TextArea customerAddress;

    @FXML
    private DatePicker customerDate;

    @FXML
    private TextField customerName;

    @FXML
    private TextField customerPhone;

    @FXML
    private Label totalAll;
    @FXML
    private Button payment;

    public static ArrayList<cartPage> cartPages = new ArrayList<cartPage>();
    ObservableList<cartPage> cartPagesList = FXCollections.observableArrayList();

    public void addToCart(cartPage cartItem) {
        if (cartPages.size() > 0) {
            if (checkCart(cartItem)) {
                System.out.println("san pham cu");
            } else {
                System.out.println("san pham moi");
            }
        } else {
            cartPages.add(cartItem);
        }
    }

    public boolean checkCart(cartPage cartItem) {
        for (int i = 0; i < cartPages.size(); i++) {
            if (cartItem.getProductSKU().equalsIgnoreCase(cartPages.get(i).getProductSKU())) {
                cartPages.get(i).setQuantity(cartItem.getQuantity() + cartPages.get(i).getQuantity());
                return true;
            }
        }
        cartPages.add(cartItem);
        return false;

    }

    public void backToShop(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/view-product.fxml").toURI().toURL());
        Parent AccountViewParent = loader.load();
        Scene scene = new Scene(AccountViewParent);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        paymentEvent();
        totalAll.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sum()));
    }

    private Integer sum() {
        int sum = 0;
        for (int i = 0; i < cartPages.size(); i++) {
            sum += cartPages.get(i).getTotal();
        }
        return sum;
    }

    private void loadData() {
        cartPagesList = FXCollections.observableList(cartPages);
        cartTable.setItems(cartPagesList);
        productId.setCellValueFactory(new PropertyValueFactory<>("productSKU"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        quality.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        Callback<TableColumn<cartPage, Void>, TableCell<cartPage, Void>> cellFactory = new Callback<TableColumn<cartPage, Void>, TableCell<cartPage, Void>>() {
            @Override
            public TableCell<cartPage, Void> call(final TableColumn<cartPage, Void> param) {
                final TableCell<cartPage, Void> cell = new TableCell<cartPage, Void>() {

                    private final Button btn = new Button("Delete");


                    {
                        btn.setOnAction((ActionEvent event) -> {
                            cartPage data = getTableView().getItems().get(getIndex());
                            cartPages.remove(data);
                            cartTable.refresh();
                            totalAll.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sum()));
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        editCol.setCellFactory(cellFactory);

        //cartTable.getColumns().add(editCol);
    }

    public void setPayment(ArrayList<cartPage> cartPages, Customer customer) {
        MainModel.orderManager.insertOrder(cartPages, customer);
    }

    public Customer createCustomer() {
        Customer customer = new Customer();
        customer.setName(customerName.getText());
        customer.setBirthday(Date.valueOf(customerDate.getValue()));
        customer.setPhone(customerPhone.getText());
        customer.setAddress(customerAddress.getText());
        String customerid=MainModel.customerManager.insertCustomer(customer);
        customer.setCustomerId(customerid);
        return customer;
    }

    public Customer checkCustomer(String customerPhone) {
        for (Customer customer : MainModel.customerManager.getCustomersList()) {
            if (customer.getPhone().equals(customerPhone)) {
                customerName.setText(customer.getName());
                customerDate.setValue(customer.getBirthday().toLocalDate());
                customerAddress.setText(customer.getAddress());
                return customer;
            }
        }
        return null;
    }
    public void payment(){
        Customer customer;
        if(!customerPhone.getText().equals("")){
            customer=checkCustomer(customerPhone.getText());
            if(customer==null){
                customer=createCustomer();
            }
            setPayment(cartPages,customer);
        }else{
            System.out.println("Vui long nhap song dien thoai");
        }
    }
    public void paymentEvent(){
        payment.setOnAction(e->{
            payment();
            cartPages.clear();
            cartTable.refresh();
        });
    }
}
