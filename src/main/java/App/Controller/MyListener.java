package App.Controller;

import App.Model.ProductModel;
import javafx.event.ActionEvent;


import java.io.IOException;

public interface MyListener {
    public void onClick(ProductModel product) throws IOException;
}
