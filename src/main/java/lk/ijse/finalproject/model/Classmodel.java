package lk.ijse.finalproject.model;

import lk.ijse.finalproject.DB.DBConnection;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.DTO.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Classmodel {
    public static boolean savClass(ClassDTO classes){
        Connection connection;
        try {
            connection= DBConnection.getInstance().getConnection();;
            PreparedStatement ps=connection.prepareStatement("insert into class values(?,?,?,?)");
            ps.setString(1,classes.getClassID());
            ps.setString(2, classes.getTeacherID());
            ps.setString(3, classes.getSubject());
            ps.setString(4, classes.getGrade());
            int aff=ps.executeUpdate();
            return aff>0;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<String> getClassID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("select distinct class_id from class");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String  x = new String(rs.getString(1));
                list.add(x);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;

    }
    public static ArrayList<ClassDTO> getAllClasses(){
        ArrayList<ClassDTO> ar=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from class");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                ClassDTO st=new ClassDTO(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4));
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
