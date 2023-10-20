package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class eachstudentController implements Initializable {

    @FXML
    private JFXButton closebutton;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

   public static String nname;
   public static boolean flag;



    @FXML
    void onattendeceClick(ActionEvent event) {

    }

    @FXML
    void oncloseclick(ActionEvent event) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onexamreportclik(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(nname);
        String boy = "C:\\Users\\User\\IdeaProjects\\final-project\\src\\main\\resources\\view\\assets\\boy1.png";
        String girl = "C:\\Users\\User\\IdeaProjects\\final-project\\src\\main\\resources\\view\\assets\\girl1.png";
        Image image1 = new Image(boy);
        Image image2 = new Image(girl);
        if (flag){
            image.setImage(image1);
        }else {
            image.setImage(image2);
        }
    }
}
