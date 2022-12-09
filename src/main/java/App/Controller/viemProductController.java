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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

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
        System.out.println("Samrt");
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
     * Tạo dữ lệu thể loại
     * @return
     * @throws IOException
     */
    private List<CategoryModel> getDataCategories() throws IOException {
        List<CategoryModel> categories = new ArrayList<>();
        CategoryModel category;
        category = new CategoryModel();
        category.setName("All");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Laptop");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Smart Phone");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("HeadPhone");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Keyboard");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        category = new CategoryModel();
        category.setName("Smart Watch");
        category.setImageCategory("src/main/java/Assets/Image/icon/laptop.png");
        categories.add(category);
        return categories;
    }

    /**
     * Hàm hiển thị từng thể loại sản phẩm
     * @param category Thể loại sản phẩm
     * @param products Danh sách các sản phẩm theo loại
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
            System.out.println("hello");
        });
        return anchorPane;
    }

    /**
     * Hàm render các thể loại và sản phẩm theo thể loại
     */
    public void renderCategories() throws IOException {
        categories.addAll(getDataCategories());
        hboxCartegory.setStyle("-fx-effect:"+"dropShadow(three-pass-box, rgba(0,0,0,0.1),10.0,0.0,0.0,10.0);");
        hboxCartegory.getChildren().add(renderCategory(categories.get(0),AllproductsList));
        hboxCartegory.getChildren().add(renderCategory(categories.get(1), (ArrayList<Product>) laptops));
        hboxCartegory.getChildren().add(renderCategory(categories.get(2), (ArrayList<Product>) phones));
    }

    /**
     * Hàm chuyển từ giao diện bán hàng sang giao diện giỏ hàng
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(AllproductsList.size());
        render(AllproductsList);
        quality.setText(String.valueOf(cartPageController.cartPages.size()));

    }
}
