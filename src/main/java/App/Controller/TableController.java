//package App.Controller;
//
//import javafx.beans.property.ReadOnlyObjectWrapper;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class TableController  implements Initializable {
//
//    @FXML
//    private TableView<ProductModel> Table;
//
//    @FXML
//    private TableColumn<ProductModel, String> color;
//
//    @FXML
//    private TableColumn<ProductModel, String> cpu;
//
//    @FXML
//    private TableColumn<ProductModel, String> edit;
//
//    @FXML
//    private TableColumn<ProductModel, String> id;
//
//    @FXML
//    private TableColumn<ProductModel, String> name;
//
//    @FXML
//    private TableColumn<ProductModel, String> ram;
//    ObservableList<ProductModel> products = FXCollections.observableArrayList();
//    private List<ProductModel> productList(){
//        List<ProductModel> list = new ArrayList<ProductModel>();
//        ProductModel product;
//        product = new ProductModel();
//        product.setName("Iphone 12");
//        product.setCpu("Apple A gi gi do");
//        list.add(product);
//        return list;
//    }
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        loadData();
//    }
//
//    private void loadData() {
//        products = FXCollections.observableList(productList());
//        Table.setItems(products);
//        id.setCellValueFactory(new PropertyValueFactory<>("name"));
//        color.setCellValueFactory(new PropertyValueFactory<>("name"));
//        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        cpu.setCellValueFactory(new PropertyValueFactory<>("cpu"));
//        TableColumn<ProductModel,ProductModel> editCl = new TableColumn<>("Hello");
//        editCl.setCellValueFactory(
//                param->new ReadOnlyObjectWrapper<>(param.getValue())
//        );
//        editCl.setCellFactory(param-> new TableCell<ProductModel, ProductModel>(){
//            private final Button button = new Button("Save");
//
//            protected void updateItem(ProductModel product, boolean empty) {
//                super.updateItem(product, empty);
//                if(product==null){
//                    setGraphic(null);
//                    return;
//                }else{
//                    setGraphic(button);
//                }
//            }
//
//        });
//        } ;
//
//
//
//}
