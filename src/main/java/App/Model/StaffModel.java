package App.Model;

import DAL.DAO;
import Entity.Attendance;
import Entity.SalaryGD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class StaffModel {
    public void addStaff(String name, String address, String position, String birthday) throws SQLException {
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("INSERT INTO staff(staffname,staffbirthday,staffaddress,staffposition) " +
                "            VALUES('"+name+"','"+birthday+"','"+address+"','"+position+"')");
        preparedStatement.execute();
    }
    public void editStaff(String id,String name,String address, Integer position, Date birthday) throws SQLException {
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("UPDATE staff SET staffname='"+name+"', staffbirthday='"+birthday+"',staffaddress='"+address+"',staffposition='"+position+"'\n" +
                " WHERE staffid = '"+id+"'");
        preparedStatement.execute();
    }
    public void deleteStaff(String ID) throws SQLException{
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        PreparedStatement preparedStatement = dao.getPreStmt("DELETE FROM staff WHERE staffid='"+ID+"'");
        preparedStatement.execute();
    }
    public static ArrayList<Attendance> getDataAttendance(){

            ArrayList<Attendance> attendance = new ArrayList<>();

            DAO dao = new DAO();
            Statement stmt = dao.getStmt();
            try {
                ResultSet rs = stmt.executeQuery("SELECT s.staffname,a.staffid,a.workday,a.checkin,a.checkout\n" +
                        "FROM staff as s, attendence as a\n" +
                        "WHERE s.staffid = a.staffid");
                while (rs != null && rs.next()){
                    attendance.add(new Attendance(
                            rs.getString(2),
                            rs.getString(1),
                            rs.getDate(3),
                            rs.getTime(4),
                            rs.getTime(5)

                    ));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return attendance;
    }
    public static ArrayList<Attendance> getDataAttendanceforDay(LocalDate date){

        ArrayList<Attendance> attendance = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("SELECT s.staffname,a.staffid,a.workday,a.checkin,a.checkout\n" +
                    "FROM staff as s, attendence as a\n" +
                    "WHERE s.staffid = a.staffid and a.workday='"+date+"'");
            while (rs != null && rs.next()){
                attendance.add(new Attendance(
                        rs.getString(2),
                        rs.getString(1),
                        rs.getDate(3),
                        rs.getTime(4),
                        rs.getTime(5)

                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return attendance;
    }
    public static int CountHour(String id, int month) throws SQLException {
        int hour   = 0;
        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs= stmt.executeQuery("SELECT date_part('hour',SUM(checkout-checkin)) FROM attendence  WHERE staffid='"+id+"'  and date_part('month', workday)='"+month+"'");
            while (rs.next()){
                hour = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hour;
    }
    public static ArrayList<SalaryGD> getDataSalary(int month){
        ArrayList<SalaryGD> salary = new ArrayList<>();

        DAO dao = new DAO();
        Statement stmt = dao.getStmt();
        try {
            ResultSet rs = stmt.executeQuery("SELECT staffname,staffid FROM staff " );
            while (rs != null && rs.next()){
                String id = rs.getString(2);
                String name= rs.getString(1);
                int hour = CountHour(id,month);
                double pay = 100000*hour;
                salary.add(new SalaryGD(
                        id,name,hour,pay
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salary ;
    }
}
