package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private JFXComboBox combo;

    @FXML
    void onsaveclick(ActionEvent event) {
        String a = C_id.getText();
        String b = (String) combo.getValue();
        String c = subject.getText();
        String d = grade.getText();
        ArrayList<TeacherDTO> ar = Teachermodel.getTeacher(b);
        String e = ar.get(0).getId();
        ClassDTO classDTO =new ClassDTO(a,e,c,d);
        boolean is = Classmodel.savClass(classDTO);

        Stage stage = (Stage) savebutton.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<TeacherDTO> allTeachers = Teachermodel.getAllTeachers();
        ObservableList<String> list = FXCollections.observableArrayList();
        for (int i = 0; i < allTeachers.size(); i++) {
            list.add(allTeachers.get(i).getName());
        }
        combo.setItems(list);
        ArrayList<ClassDTO> ar =  Classmodel.getAllClasses();
        if (ar.size() > 0){
            lable.setText(ar.get(ar.size()-1).getClassID());
        }
    }
}
