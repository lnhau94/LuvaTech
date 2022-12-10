package App.Model;

import DAL.DAO;
import DAL.StaffDAO;
import Entity.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class StaffModel {
    public void addStaff(String name, String address, String position, String birthday) throws SQLException {
        DAO dao = new DAO();
        dao.getPreStmt("INSERT INTO staff(staffname,staffbirthday,staffaddress,staffposition) " +
                "            VALUES('"+name+"','"+birthday+"','"+address+"','"+position+"')");
        System.out.println("Success");
    }
}
