package lk.ijse.finalproject.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.model.Studentmodel;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class studentobjformController implements Initializable {


    @FXML
    private TextField clss;

    @FXML
    private TextField email;

    @FXML
    private TextField gender;

    @FXML
    private TextField id;

    @FXML
    private ImageView morebutton;

    @FXML
    private TextField name;

    @FXML
    void onclick(MouseEvent event) throws IOException {
        String nname = name.getText();
        String gen = gender.getText();
        boolean flag = false;
        if (gen.equals("Male")){
            flag = true;
        }
        eachstudentController.nname = nname;
        eachstudentController.flag = flag;
        Parent parent = FXMLLoader.load(getClass().getResource("/view/eachstudentform.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(900);
        stage.setY(100);
        stage.show();

    }
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
