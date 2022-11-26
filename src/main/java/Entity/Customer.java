package Entity;

import java.sql.Date;

public class Customer {
    private String customerId;
    private String name;
    private Date birthday;
    private String address;
    private String phone;

    public Customer() {
    }

    public Customer(String customerId, String name, Date birthday, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
