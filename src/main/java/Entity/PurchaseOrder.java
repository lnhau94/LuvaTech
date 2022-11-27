package Entity;

import java.sql.Date;
import java.util.ArrayList;

public class PurchaseOrder {
    private String purchaseOrderId;
    private String employeeIdCreate;
    private String employeeIdConfirm;
    private int totalPrice;
    private Date date;
    private Date expectedDeliveryDate;
    private String supplierName;
    private String supplierAddress;
    private String status;
    private ArrayList<PurchaseOrderDetail> details;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String purchaseOrderId, String employeeIdCreate, String employeeIdConfirm, int totalPrice,
                         Date date, Date expectedDeliveryDate, String supplierName, String supplierAddress,
                         String status, ArrayList<PurchaseOrderDetail> details) {
        this.purchaseOrderId = purchaseOrderId;
        this.employeeIdCreate = employeeIdCreate;
        this.employeeIdConfirm = employeeIdConfirm;
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

    public String getEmployeeIdCreate() {
        return employeeIdCreate;
    }

    public void setEmployeeIdCreate(String employeeIdCreate) {
        this.employeeIdCreate = employeeIdCreate;
    }

    public String getEmployeeIdConfirm() {
        return employeeIdConfirm;
    }

    public void setEmployeeIdConfirm(String employeeIdConfirm) {
        this.employeeIdConfirm = employeeIdConfirm;
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
