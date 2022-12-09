package App.View.Component;

import Entity.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class Component {
    public  RadioButton cusTomRB (String ram, ToggleGroup ramTG){
        RadioButton ramItem = new RadioButton(ram);
        ramItem.setToggleGroup(ramTG);
        ramItem.getStyleClass().remove("radio-button");
        ramItem.setId("ramBT");
        ramItem.getStylesheets().add("/view/css/detailItem.css");
        return ramItem;
    }
    public RadioButton ColorRB (String color, ArrayList<Color> colors, ToggleGroup colorTG){
        String colorHexa = null;
        for(Color colorinList: colors) {
            if(colorinList.getName().equalsIgnoreCase(color)){
                colorHexa=colorinList.getColorHexa();
            }
        }
        RadioButton colorItem = new RadioButton();
        colorItem.setText(color);
        colorItem.setToggleGroup(colorTG);
        colorItem.setStyle("-fx-background-color:"+colorHexa+"; \n");
        colorItem.getStyleClass().remove("radio-button");
        colorItem.setId("colorBT");
        colorItem.getStylesheets().add("/view/css/detailItem.css");
        return colorItem;
    }
}
