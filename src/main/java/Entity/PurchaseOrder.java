package Entity;

import java.sql.Date;
import java.util.ArrayList;

public class PurchaseOrder {
    private String purchaseOrderId;
    private Staff employeeCreate;
    private Staff employeeConfirm;
    private int totalPrice;
    private Date date;
    private Date expectedDeliveryDate;
    private String supplierName;
    private String supplierAddress;
    private String status;
    private ArrayList<PurchaseOrderDetail> details;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String purchaseOrderId, int totalPrice, Date date, Date expectedDeliveryDate,
                         String supplierName, String supplierAddress, String status) {
        this.purchaseOrderId = purchaseOrderId;
        this.totalPrice = totalPrice;
        this.date = date;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.status = status;
    }

    public PurchaseOrder(String purchaseOrderId, Staff employeeCreate, Staff employeeConfirm, int totalPrice,
                         Date date, Date expectedDeliveryDate, String supplierName, String supplierAddress,
                         String status, ArrayList<PurchaseOrderDetail> details) {
        this.purchaseOrderId = purchaseOrderId;
        this.employeeCreate = employeeCreate;
        this.employeeConfirm = employeeConfirm;
        this.totalPrice = totalPrice;
        this.date = date;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.status = status;
        this.details = details;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public Staff getEmployeeCreate() {
        return employeeCreate;
    }

    public void setEmployeeCreate(Staff employeeCreate) {
        this.employeeCreate = employeeCreate;
    }

    public Staff getEmployeeConfirm() {
        return employeeConfirm;
    }

    public void setEmployeeConfirm(Staff employeeConfirm) {
        this.employeeConfirm = employeeConfirm;
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

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PurchaseOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<PurchaseOrderDetail> details) {
        this.details = details;
    }
}
