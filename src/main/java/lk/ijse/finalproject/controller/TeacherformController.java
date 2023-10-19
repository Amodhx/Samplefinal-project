package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.DTO.TeacherDTO;
import lk.ijse.finalproject.Main;
import lk.ijse.finalproject.model.Teachermodel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherformController implements Initializable {

    @FXML
    private Button addteacherbutton;



    @FXML
    void onaddTeacherClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/teacheraddform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 808, 599);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<TeacherDTO> ar= Teachermodel.getAllTeachers();

    }
}
