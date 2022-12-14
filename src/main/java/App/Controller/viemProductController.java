package App.Controller;
import App.Model.CategoryModel;
import DAL.ProductDAO;
import Entity.Laptop;
import Entity.Phone;
import Entity.Product;
import Entity.SmartWatch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class viemProductController implements Initializable {

    @FXML
    private AnchorPane viewControl;
    @FXML
    private GridPane grid, gridCategoryItem;
    @FXML
    private HBox hboxCartegory;
    @FXML
    private Label quality;
    @FXML
    private ScrollPane scroll;
    @FXML
    private TextField textSearch;
    @FXML
    private Button BtnSearch;
    @FXML
    //private List<ProductModel> products = new ArrayList<>();
    private List<CategoryModel> categories = new ArrayList<>();
    private HashMap<String, ArrayList<? extends Product>> productList = ProductDAO.retrieve();
    private ArrayList<? extends Product> laptops = (ArrayList<Laptop>) productList.get("laptop");
    private ArrayList<? extends Product> phones = (ArrayList<Phone>) productList.get("phone");
    private ArrayList<? extends Product> smartWatchs = (ArrayList<SmartWatch>) productList.get("smartwatch");
    public ArrayList<Product> products (){
        ArrayList<Product> products = new ArrayList<>();
        for (Product laptop : laptops) {
            products.add(laptop);
        }
        for (Product phone : phones) {
            products.add(phone);
        }
        for (Product smartWatch : smartWatchs) {
            products.add(smartWatch);
        }
        return products;
    }

    ArrayList<Product> AllproductsList =products();
    public void render(ArrayList<Product> products){

        int column=0;
        int row=1;
        try {
            if (products.size() == 0) {
                System.out.println("Khong co san pham nao!");
            }else{
                for (int i=0; i<products.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(new File("src/main/java/App/View/item.fxml").toURI().toURL());
                    AnchorPane anchorPane = fxmlLoader.load();
                    itemController itemController = fxmlLoader.getController();
                    itemController.setData(products.get(i));
                    if(column==4){
                        column = 0;
                        row++;
                    }
                    grid.add(anchorPane,column++,row);
                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMaxWidth(Region.USE_PREF_SIZE);

                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMaxHeight(Region.USE_PREF_SIZE);
                    GridPane.setMargin(anchorPane, new Insets(15));
                    GridPane.setVgrow(anchorPane, Priority.ALWAYS);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * T???o d??? l???u th??? lo???i
     * @return
     * @throws IOException
     */
    private List<CategoryModel> getDataCategories() throws IOException {
        List<CategoryModel> categories = new ArrayList<>();
        CategoryModel category;
        category = new CategoryModel();
        category.setName("All");
        category.setImageCategory("src/main/java/Assets/Image/icon/select.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Laptop");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Smart Phone");
        category.setImageCategory("src/main/java/Assets/Image/icon/smartphone.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("HeadPhone");
        category.setImageCategory("src/main/java/Assets/Image/icon/headphones.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Keyboard");
        category.setImageCategory("src/main/java/Assets/Image/icon/keyboard.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Smart Watch");
        category.setImageCategory("src/main/java/Assets/Image/icon/smart-watch.png");
        categories.add(category);
        return categories;
    }

    /**
     * H??m hi???n th??? t???ng th??? lo???i s???n ph???m
     * @param category Th??? lo???i s???n ph???m
     * @param products Danh s??ch c??c s???n ph???m theo lo???i
     * @return
     * @throws MalformedURLException
     */
    public AnchorPane renderCategory(CategoryModel category, ArrayList<Product> products) throws MalformedURLException {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(200);
        HBox vbox = new HBox();
        vbox.setStyle(" -fx-alignment:"+" center; \n"+
                "-fx-border-insets:"+"5px; \n"+
                "-fx-background-insets:"+"5px; \n"+
                "-fx-border-radius:"+"30px; \n" +
                "-fx-background-radius:"+"30px; \n" +
                "-fx-background-color:"+"#feca57; \n"+
                "-fx-border-color:"+"#feca57; \n"+
                "-fx-alignment:"+"center; \n"+
                "fx-pref-height:"+ "150px; \n"+
                "-fx-pref-width:" +"200px; \n"
        );

        Image image = new Image(String.valueOf(new File(category.getImageCategory()).toURI().toURL()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setStyle( "-fx-pref-height:"+ "10px; \n"+
                " -fx-pref-width:" +"10px; \n"+
                " -fx-alignment:"+" center;");
        Label label = new Label(category.getName());
        label.setStyle("-fx-font-size:"+"20px; \n"+
                      "-fx-padding:"+"0 0 0 10px; \n");
        vbox.getChildren().add(imageView);
        vbox.getChildren().add(label);
        anchorPane.getChildren().add(vbox);
        anchorPane.setOnMouseClicked(e->{
            grid.getChildren().clear();
            render(products);
        });
        return anchorPane;
    }

    /**
     * H??m render c??c th??? lo???i v?? s???n ph???m theo th??? lo???i
     */
    public void renderCategories() throws IOException {
        categories.addAll(getDataCategories());
        hboxCartegory.setStyle("-fx-effect:"+"dropShadow(three-pass-box, rgba(0,0,0,0.1),10.0,0.0,0.0,10.0);");
        hboxCartegory.getChildren().add(renderCategory(categories.get(0),AllproductsList));
        hboxCartegory.getChildren().add(renderCategory(categories.get(1), (ArrayList<Product>) laptops));
        hboxCartegory.getChildren().add(renderCategory(categories.get(2), (ArrayList<Product>) phones));
        hboxCartegory.getChildren().add(renderCategory(categories.get(5), (ArrayList<Product>) smartWatchs));
    }
    public void searchProduct(){
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(new File("src/main/java/App/View/Alert.fxml").toURI().toURL());
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        Pane alert = null;
        try {
            alert = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Dialog<ButtonType> dialog = new Dialog<>();
        AlertController alertController = loader.getController();
        dialog.setDialogPane((DialogPane) alert);
        ArrayList<Product> products = products ();
        ArrayList<Product> ProductsForSearch = new ArrayList<> ();
        BtnSearch.setOnAction(e->{
            ProductsForSearch.clear();
            if(!textSearch.getText().equals("")){
                String pattern = ".*" + textSearch.getText() + ".*";
                for(Product product:products) {
                    if (product.getProductName().toLowerCase().matches(pattern.toLowerCase())) {
                        ProductsForSearch.add(product);
                    }
                }
                grid.getChildren().clear();
                if (ProductsForSearch.size() > 0){
                    render(ProductsForSearch);
                }else {
                    try {
                        alertController.RenderAlert("Warning", "Kh??ng t??m th???y s???n ph???m!");
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                    Optional<ButtonType> clickedButton = dialog.showAndWait();
                    if (clickedButton.get() == ButtonType.OK) {
                        dialog.close();
                        textSearch.setText("");
                        grid.getChildren().clear();
                        render(products);
                    }
                }
            }else{
                try {
                    alertController.RenderAlert("Warning","Vui l??ng nh???p n???i dung c???n t??m ki???m!");
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
                Optional<ButtonType> clickedButton = dialog.showAndWait();
                if(clickedButton.get()== ButtonType.OK){
                    dialog.close();
                }
            }

        });
    }

    /**
     * H??m chuy???n t??? giao di???n b??n h??ng sang giao di???n gi??? h??ng
     * @param e
     * @throws IOException
     */
    public  void  switchCartPage(MouseEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File("src/main/java/App/View/cartPage.fxml").toURI().toURL());
        Parent AccountViewParent = loader.load();
        Scene scene = new Scene(AccountViewParent);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            renderCategories();
            searchProduct();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(AllproductsList.size());
        render(AllproductsList);
        quality.setText(String.valueOf(cartPageController.cartPages.size()));

    }
}
