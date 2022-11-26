package Entity;

import java.sql.*;

public class Attendance {
    private Staff staff;
    private Date workday;
    private Time checkin;
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
}
