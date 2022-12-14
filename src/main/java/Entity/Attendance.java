package Entity;

import java.sql.*;

public class Attendance {
    private Staff staff;
    private String staffId;
    private String staffName;
    private Date workday;
    private Time checkin;

    public Attendance(String staffId, String staffName, Date workday, Time checkin, Time checkout) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.workday = workday;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    private Time checkout;

    public Attendance() {
    }

    public Attendance(Staff staff, Date workday, Time checkin) {
        this.staff = staff;
        this.workday = workday;
        this.checkin = checkin;
    }

    public Attendance(Staff staff, Date workday, Time checkin, Time checkout) {
        this.staff = staff;
        this.workday = workday;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getWorkday() {
        return workday;
    }

    public void setWorkday(Date workday) {
        this.workday = workday;
    }

    public Time getCheckin() {
        return checkin;
    }

    public void setCheckin(Time checkin) {
        this.checkin = checkin;
    }

    public Time getCheckout() {
        return checkout;
    }

    public void setCheckout(Time checkout) {
        this.checkout = checkout;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
