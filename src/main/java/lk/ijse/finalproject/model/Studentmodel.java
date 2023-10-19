package lk.ijse.finalproject.model;

import lk.ijse.finalproject.DB.DBConnection;
import lk.ijse.finalproject.DTO.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Studentmodel {
    public static boolean savStudent(StudentDTO student){
        Connection connection;
        try {
            connection= DBConnection.getInstance().getConnection();;
            PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
            ps.setString(1, student.getStuid());
            ps.setString(2,student.getCls());
            ps.setString(3,student.getName());
            ps.setString(4,student.getEmail());
            ps.setString(5,student.getGrade());
            ps.setString(6,student.getGender());

            int aff=ps.executeUpdate();
            return aff>0;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<StudentDTO> getAllStudents(){
        ArrayList<StudentDTO> ar=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from student");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                StudentDTO st=new StudentDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                ar.add(st);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return ar;
    }

}
