package App.Controller;
import App.Model.CategoryModel;
import App.Model.ProductModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
    private ScrollPane scroll;
    private List<ProductModel> products = new ArrayList<>();
    private List<CategoryModel> categories = new ArrayList<>();
    private MyListener myListener;
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
    private List<ProductModel> getDataProduct()  {
       List<ProductModel> products = new ArrayList<>();
       ArrayList<String> colors = new ArrayList<>();
       colors.add("red");
       colors.add("green");
       colors.add("blue");
        ArrayList<String> rams = new ArrayList<>();
        colors.add("2GB");
        colors.add("3GB");
        colors.add("4GB");
        ProductModel product;
       product = new ProductModel();
       product.setName("Iphone 12");
       product.setPrice(1000);
       product.setCategory("laptop");
       product.setCpu("Chip A11");
       product.setDescription("Iphone 12 ngon lam!");
       product.setColors(colors);
        product.setImgSrc(("src/main/java/Assets/Image/laptop/Laptop_Dell_XPS13_9320/dell-xps-1.jpg"));
       product.setRam(rams);
       products.add(product);
        product = new ProductModel();
        product.setName("ban phim ne");
        product.setPrice(1000);
        product.setCategory("keyboard");
        product .setCpu("Chip A11");
        product.setDescription("Iphone 12 ngon lam!");
        product.setColors(colors);
        product.setImgSrc(("src/main/java/Assets/Image/laptop/Laptop_Dell_XPS13_9320/dell-xps-1.jpg"));
        product.setRam(rams);
        products.add(product);
        product = new ProductModel();
        product.setName("Iphone 12");
        product.setPrice(1000);
        product.setCategory("SmartWatch");
        product.setCpu("Chip A11");
        product.setDescription("Iphone 12 ngon lam!");
        product.setColors(colors);
        product.setImgSrc(("src/main/java/Assets/Image/laptop/Laptop_Dell_XPS13_9320/dell-xps-1.jpg"));
        product.setRam(rams);
        products.add(product);
       return products;
    }

    public void renderProducts()  {
        products.addAll(getDataProduct());
        if (products.size() > 0) {
//            myListener= new MyListener(){
//
//                @Override
//                public void onClick(Product product) throws IOException {
//
//                }
//            };
        }
        int column=0;
        int row=1;
        try {
            for (int i=0; i<products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(new File("src/main/java/App/View/item.fxml").toURI().toURL());
                AnchorPane anchorPane = fxmlLoader.load();
                itemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i),myListener);
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public AnchorPane renderCategory(CategoryModel category) throws MalformedURLException {
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
        return anchorPane;
    }
    public void renderCategories() throws IOException {
        categories.addAll(getDataCategories());
        hboxCartegory.setStyle("-fx-effect:"+"dropShadow(three-pass-box, rgba(0,0,0,0.1),10.0,0.0,0.0,10.0);");
     for (int i = 0; i <categories.size();i++){
         hboxCartegory.getChildren().add(renderCategory(categories.get(i)));
     }

    }
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


        renderProducts();

    }
}
