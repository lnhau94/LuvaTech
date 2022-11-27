package App.Logic;

import DAL.StaffDAO;
import Entity.Staff;

import java.util.ArrayList;

public class StaffManagement {
    private ArrayList<Staff> staffList;

    public StaffManagement() {
        init();
    }
    private void init(){
        staffList = StaffDAO.retrieve();
    }
}
