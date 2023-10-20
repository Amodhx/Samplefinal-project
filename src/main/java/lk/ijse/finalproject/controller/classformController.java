package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.Main;
import lk.ijse.finalproject.model.Classmodel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class classformController implements Initializable {

    @FXML
    private GridPane gridpane;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private JFXButton addButton;
    @FXML
    void adclassButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/addClassform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 808, 599);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ClassDTO> clas = Classmodel.getAllClasses();

        int colomn = 0;
        int row = 0;
        for (int i = 0; i < clas.size(); i++) {
            try {
                classobjController.x = i ;
                Parent parent= FXMLLoader.load(getClass().getResource("/view/classobjform.fxml"));
                gridpane.add(parent,colomn,row++);
                GridPane.setMargin(parent,new Insets(10));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
