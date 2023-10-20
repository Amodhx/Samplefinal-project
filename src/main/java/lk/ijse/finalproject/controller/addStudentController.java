package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.model.Classmodel;
import lk.ijse.finalproject.model.Studentmodel;
import lk.ijse.finalproject.model.Teachermodel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addStudentController implements Initializable {
    @FXML
    private JFXComboBox combo;

    @FXML
    private TextField grade;

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
    private TextField subject1;
    @FXML
    private TextField idd;
    @FXML
    private Label lable;

    @FXML
    void onsaveclick(ActionEvent event) {
        String a = idd.getText();
        String b = (String) combo.getValue();
        String c = name.getText();
        String d = email.getText();
        String e = grade.getText();
        String f ;
        if (male.isSelected()){
            f = "Male";
        }else{
            f = "Female";
        }
        StudentDTO studentDTO = new StudentDTO(a,b,c,d,e,f);
        boolean is = Studentmodel.savStudent(studentDTO);
        Stage stage=(Stage) savebutton.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String>  br= Classmodel.getClassID();
        ObservableList<String> list = FXCollections.observableArrayList();
        for (int i = 0; i < br.size(); i++) {
            list.add(br.get(i));
        }
        combo.setItems(list);
        ArrayList<StudentDTO> ar = Studentmodel.getAllStudents();
        if (ar.size() > 0) {
            String id = ar.get(ar.size() - 1).getStuid();
            lable.setText(id);
        }
    }
}
