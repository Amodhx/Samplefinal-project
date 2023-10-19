package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.Main;
import lk.ijse.finalproject.model.Studentmodel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentformController implements Initializable {

    @FXML
    private Button addstudentbutton;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private GridPane gridpane;
    @FXML
    private Button searchbutton;

    @FXML
    private TextField textsearch;
    @FXML
    private AnchorPane pane;
    @FXML
    void pnsearchClick(ActionEvent event) {
        String x = textsearch.getText();
        ArrayList<StudentDTO> ar=Studentmodel.getAllStudents();

    }


    @FXML
    void onaddstudentclick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/addStudentform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 808, 599);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<StudentDTO> ar= Studentmodel.getAllStudents();
        int coloumn = 0;
        int row = 0;
        for (int i = 0; i < ar.size(); i++) {
            try {
                studentobjformController.x=i;
                Parent parent= FXMLLoader.load(getClass().getResource("/view/studentObjform.fxml"));
                gridpane.add(parent,coloumn,row++);
                GridPane.setMargin(parent,new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
