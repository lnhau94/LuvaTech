package Util;

public class Validation {
    public boolean checkPrice(){
        return true;
    }
    public boolean checkName(){
        return true;
    }

    /**
     * Check legal phone number - Kiểm tra số điện thoại hợp lệ theo quy chuẩn VN
     * @param phoneNumber number need to check - số điện thoại cần kiểm tra
     * @return True if legal, False if illegal - True nếu hợp lệ, False nếu ko hợp lệ
     */
    public boolean checkPhone(String phoneNumber){
        return phoneNumber.matches(
                "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|" +
                        "(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$"
        );
    }
}
