package lk.ijse.finalproject.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.DTO.TeacherDTO;
import lk.ijse.finalproject.model.Classmodel;
import lk.ijse.finalproject.model.Studentmodel;
import lk.ijse.finalproject.model.Teachermodel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class classobjController implements Initializable {

    public static int x ;

    @FXML
    private Label classname;

    @FXML
    private Label grade;

    @FXML
    private Label studentcount;

    @FXML
    private Label teacherId;

    @FXML
    private Label teachername;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ClassDTO> arrayList = Classmodel.getAllClasses();
        String id = arrayList.get(x).getTeacherID();
        String cid = arrayList.get(x).getClassID();
        String gr = arrayList.get(x).getGrade();
        ArrayList<TeacherDTO> arrayList1 = Teachermodel.getTeachername(id);
        ArrayList<StudentDTO> arrayList2 = Studentmodel.getStudentCount(cid,gr);
        studentcount.setText(String.valueOf(arrayList2.size()));
        teachername.setText(arrayList1.get(0).getName());
        grade.setText(arrayList.get(x).getGrade());
        teacherId.setText(arrayList.get(x).getTeacherID());
        classname.setText(arrayList.get(x).getSubject());



    }
}
