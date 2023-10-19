package lk.ijse.finalproject.model;

import lk.ijse.finalproject.DB.DBConnection;
import lk.ijse.finalproject.DTO.TeacherDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Teachermodel {
    public static boolean savTeacher(TeacherDTO teacher){
        Connection con;
        try {
            con= DBConnection.getInstance().getConnection();
            PreparedStatement ps= con.prepareStatement("insert into Teacher values(?,?,?,?,?,?)");
          ps.setString(1,teacher.getId());
          ps.setString(2,teacher.getName());
          ps.setString(3,teacher.getEmail());
          ps.setString(4,teacher.getGender());
          ps.setString(5,teacher.getNumber());
          ps.setString(6,teacher.getSubject());

            int aff=ps.executeUpdate();
            return aff>0;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<TeacherDTO> getTeacher(String name){
        ArrayList<TeacherDTO> ar = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from teacher where T_name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                TeacherDTO dt = new TeacherDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                ar.add(dt);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return ar;

    }
    public static ArrayList<TeacherDTO> getAllTeachers(){
        ArrayList<TeacherDTO> ar=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from Teacher");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                TeacherDTO dt=new TeacherDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6) );
                ar.add(dt);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return ar;
    }
}
