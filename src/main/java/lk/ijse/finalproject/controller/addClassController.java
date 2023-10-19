package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.DTO.TeacherDTO;
import lk.ijse.finalproject.model.Classmodel;
import lk.ijse.finalproject.model.Teachermodel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addClassController implements Initializable {

    @FXML
    private TextField C_id;

    @FXML
    private TextField grade;

    @FXML
    private Label lable;

    @FXML
    private JFXButton savebutton;

    @FXML
    private TextField subject;

    @FXML
    private TextField teachername;

    @FXML
    void onsaveclick(ActionEvent event) {
        String a = C_id.getText();
        String b = teachername.getText();
        String c = subject.getText();
        String d = grade.getText();
        ArrayList<TeacherDTO> ar = Teachermodel.getTeacher(b);
        String e = ar.get(0).getId();
        ClassDTO classDTO =new ClassDTO(a,b,e,d);
        boolean is = Classmodel.savClass(classDTO);

        Stage stage = (Stage) savebutton.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ClassDTO> ar =  Classmodel.getAllClasses();
        if (ar.size() > 0){
            lable.setText(ar.get(ar.size()-1).getClassID());
        }
    }
}
