package Entity;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private Staff cashier;
    private Customer customer;
    private int totalPrice;
    private Date date;
    private Staff takeBackStaff;
    private ArrayList<OrderDetails> details;
    private ArrayList<GiveBackItem> giveBackItems;

    public Order() {
    }

    public Order(Staff cashier, Customer customer, int totalPrice, Date date, Staff takeBackStaff, ArrayList<OrderDetails> details) {
        this.cashier = cashier;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.date = date;
        this.takeBackStaff = takeBackStaff;
        this.details = details;
    }

    public Order(Staff cashier, Customer customer, int totalPrice, Date date, Staff takeBackStaff, ArrayList<OrderDetails> details, ArrayList<GiveBackItem> giveBackItems) {
        this.cashier = cashier;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.date = date;
        this.takeBackStaff = takeBackStaff;
        this.details = details;
        this.giveBackItems = giveBackItems;
    }

    public Staff getCashier() {
        return cashier;
    }

    public void setCashier(Staff cashier) {
        this.cashier = cashier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Staff getTakeBackStaff() {
        return takeBackStaff;
    }

    public void setTakeBackStaff(Staff takeBackStaff) {
        this.takeBackStaff = takeBackStaff;
    }

    public ArrayList<OrderDetails> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OrderDetails> details) {
        this.details = details;
    }

    public ArrayList<GiveBackItem> getGiveBackItems() {
        return giveBackItems;
    }

    public void setGiveBackItems(ArrayList<GiveBackItem> giveBackItems) {
        this.giveBackItems = giveBackItems;
    }
}
