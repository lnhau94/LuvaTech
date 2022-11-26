package Util;

public class Validation {
    public boolean checkPrice(){
        return true;
    }
    public boolean checkName(){
        return true;
    }
    public boolean checkPhone(String phoneNumber){
        return phoneNumber.matches("^[+84|0][^0][0-9]{8}");
    }
}
