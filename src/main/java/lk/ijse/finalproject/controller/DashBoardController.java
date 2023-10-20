package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.finalproject.Main;

import java.io.IOException;

public class DashBoardController {
    @FXML
    private ImageView snedmailButton;

    @FXML
    private Button addStudentButton;
    @FXML
    private AnchorPane anpane;

    @FXML
    private Button addadminButton;

    @FXML
    private Button addteacherButton;

    @FXML
    private Button billingButton;

    @FXML
    private Button classesButton;

    @FXML
    private Button dashBoardButton;

    @FXML
    private Button examButton;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button studentButton;

    @FXML
    private Button teacherButton;

    @FXML
    void onBilingClick(ActionEvent event) {

    }

    @FXML
    void onExamClick(ActionEvent event) {

    }
    @FXML
    void onSendMailClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/mailsenderform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 808, 599);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void onLogOutClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Loginform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1530, 850);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Stage stage1=(Stage) teacherButton.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void onStudentClick(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/studentform.fxml"));
        this.anpane.getChildren().clear();
        this.anpane.getChildren().add(root);

    }

    @FXML
    void onTeacherClick(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/Teacherform.fxml"));
        this.anpane.getChildren().clear();
        this.anpane.getChildren().add(root);
    }

    @FXML
    void onaddStudentClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/addStudentform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 808, 599);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

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

    @FXML
    void onaddadminButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/addAdminform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 497);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onclassesClick(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/classform.fxml"));
        this.anpane.getChildren().clear();
        this.anpane.getChildren().add(root);
    }

    @FXML
    void ondashBoardClick(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/dbform.fxml"));
        this.anpane.getChildren().clear();
        this.anpane.getChildren().add(root);
    }

}
