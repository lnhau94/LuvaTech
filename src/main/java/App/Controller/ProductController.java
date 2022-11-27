package App.Controller;

import Entity.Variant;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProductController {
    /**
     * 4GB=[ 256GB=[hồng, đen], 512GB[hồng đen]]

     */
    public static HashMap<String, List<String>> items = new HashMap<>();
    public static HashMap<String, List<HashMap<String, List<String>>>> details = new HashMap<>();
    public static synchronized void addDetails(String ram, String storage, String color){
        HashMap<String, List<String>> colorHasMap = new HashMap<>();
        List<HashMap<String, List<String>>> colors = new ArrayList<>();
        addToList(storage,color);
        colors.add(items);
        details.put(ram,colors);
    }
    public static synchronized void addToList(String mapKey, String value){
        List<String> valueList = items.get(mapKey);
        if(valueList == null){
            valueList = new ArrayList<String>();
            valueList.add(value);
            items.put(mapKey, valueList);
        }else{
            if(!items.containsValue(value)){
                valueList.add(value);
            }
        }
    }
    public static void main(String[] args) {
        addDetails("8GB","128GB","Black");
        addDetails("8GB","128GB","Pink");
        addDetails("8GB","128GB","Red");
        addDetails("8GB","256GB","Red");
        addDetails("16GB","256GB","Red");
        addDetails("16GB","128GB","Pink");
    }
}
