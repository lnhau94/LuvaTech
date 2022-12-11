package Entity;

import java.sql.Date;

public class Staff {
    private String staffId;
    private String name;
    private String address;
    private String position;
    private Date birthday;
    private Account account;

    public Staff(String id, String name, String address, String position, java.util.Date dob) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.position = position;
        this.birthday = birthday;
    }
    public Staff(String staffId, String name, String address, String position, Date birthday) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.position = position;
        this.birthday = birthday;
    }
    public Staff(String staffId, String name, String address, String position, Date birthday, Account account) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.position = position;
        this.birthday = birthday;
        this.account = account;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
