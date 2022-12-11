package Logic;

import DAL.ProductDAO;
import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductManagement {
    private ArrayList<Laptop> laptopList;
    private ArrayList<Phone> phoneList;
    private ArrayList<SmartWatch> smartWatchList;
    private ArrayList<Headphone> headphoneList;
    private ArrayList<Keyboard> keyboardList;

    public ProductManagement() {
        init();
    }

    private void init(){
        HashMap<String,ArrayList<? extends Product>> products = ProductDAO.retrieve();
        laptopList = (ArrayList<Laptop>) products.get("laptop");
        phoneList = (ArrayList<Phone>) products.get("phone");
        smartWatchList = (ArrayList<SmartWatch>) products.get("smartwatch");
        headphoneList = (ArrayList<Headphone>) products.get("headphone");
        keyboardList = (ArrayList<Keyboard>) products.get("keyboard");

    }

    public ArrayList<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(ArrayList<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    public ArrayList<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public ArrayList<SmartWatch> getSmartWatchList() {
        return smartWatchList;
    }

    public void setSmartWatchList(ArrayList<SmartWatch> smartWatchList) {
        this.smartWatchList = smartWatchList;
    }

    public ArrayList<Headphone> getHeadphoneList() {
        return headphoneList;
    }

    public void setHeadphoneList(ArrayList<Headphone> headphoneList) {
        this.headphoneList = headphoneList;
    }

    public ArrayList<Keyboard> getKeyboardList() {
        return keyboardList;
    }

    public void setKeyboardList(ArrayList<Keyboard> keyboardList) {
        this.keyboardList = keyboardList;
    }

    public void addLaptop(Laptop laptop) {
        laptopList.add(laptop);
    }
}
