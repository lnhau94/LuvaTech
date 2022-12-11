package Logic;

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

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public Staff findById(String staffId){
        for (Staff st : staffList){
            if( staffId!=null && Integer.parseInt(st.getStaffId()) == Integer.parseInt(staffId)){
                return st;
            }
        }
        return null;
    }
}
