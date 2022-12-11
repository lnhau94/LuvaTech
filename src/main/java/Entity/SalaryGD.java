package Entity;

public class SalaryGD {
    private String staffid;
    private String staffname;
    private int hour;
    private double pay;
    public SalaryGD(String staffid, String staffname, int hour, double pay) {
        this.staffid = staffid;
        this.staffname = staffname;
        this.hour = hour;
        this.pay = pay;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
