package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.DTO.UserDTO;
import lk.ijse.finalproject.Main;
import lk.ijse.finalproject.model.Usermodel;

import java.io.IOException;
import java.util.ArrayList;

public class loginController {

    @FXML
    private Button loginButton;

    @FXML
    private Label signup;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label text;

    @FXML
    void onLoginClick(ActionEvent event) throws IOException {
        String x = username.getText();
        String y = password.getText();

        ArrayList<UserDTO> ar= Usermodel.getAllUsers();

        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i).getUserName().equals(x) && ar.get(i).getPassword().equals(y)){
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/DashBoardform.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1530, 850);
                Stage stage=new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
                Stage stage1=(Stage) loginButton.getScene().getWindow();
                stage1.close();
            }else{
                text.setText("Your username/password not match");
            }
        }



    }
    @FXML
    void onUserType(KeyEvent event) {
        text.setText("");
    }

    @FXML
    void onsignupClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/addAdminform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 497);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        //stage.centerOnScreen();
        stage.setX(850);
        stage.setY(150);
        stage.setScene(scene);
        stage.show();

    }

}
