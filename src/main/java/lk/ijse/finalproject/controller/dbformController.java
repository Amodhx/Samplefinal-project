package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.Main;

import java.io.IOException;

public class dbformController {

    @FXML
    private Button addStudentButton;

    @FXML
    private Button addadminButton;

    @FXML
    private Button addteacherButton;

    @FXML
    private Button logoutbutton;

    @FXML
    void onLogOutClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Loginform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1530, 850);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Stage stage1=(Stage) logoutbutton.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void onaddStudentClick(ActionEvent event) {

    }

    @FXML
    void onaddTeacherClick(ActionEvent event) {

    }

    @FXML
    void onaddadminButtonClick(ActionEvent event) {

    }

}
