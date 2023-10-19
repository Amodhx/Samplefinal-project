package lk.ijse.finalproject.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.model.Studentmodel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class studentobjformController implements Initializable {

    public TextField id;
    public TextField name;
    public TextField clss;
    public TextField email;
    public TextField gender;
    static int x=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<StudentDTO> ar= Studentmodel.getAllStudents();
        id.setText(ar.get(x).getStuid());
        name.setText(ar.get(x).getName());
        clss.setText(ar.get(x).getCls());
        email.setText(ar.get(x).getEmail());
        gender.setText(ar.get(x).getGender());



    }


    public void onclickMore(MouseEvent mouseEvent) {
    }
}
