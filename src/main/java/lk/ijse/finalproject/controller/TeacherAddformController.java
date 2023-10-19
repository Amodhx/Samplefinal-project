package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.DTO.TeacherDTO;
import lk.ijse.finalproject.model.Studentmodel;
import lk.ijse.finalproject.model.Teachermodel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherAddformController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField email;

    @FXML
    private CheckBox female;

    @FXML
    private CheckBox male;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private JFXButton savebutton;

    @FXML
    private TextField subject;
    @FXML
    private Label lable;

    @FXML
    void onsaveclick(ActionEvent event) {
        String a = id.getText();
        String b = name.getText();
        String c = email.getText();
        String d ;
        if (male.isSelected()){
            d = "Male";
        }else{
            d = "Female";
        }
        String e = number.getText();
        String f = subject.getText();
        TeacherDTO teacherDTO = new TeacherDTO(a,b,c,d,e,f);
        boolean is = Teachermodel.savTeacher(teacherDTO);
        Stage stage=(Stage) savebutton.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<TeacherDTO> ar = Teachermodel.getAllTeachers();
        if (ar.size() > 0) {
            String id = ar.get(ar.size() - 1).getId();
            lable.setText(id);
        }
    }
}
