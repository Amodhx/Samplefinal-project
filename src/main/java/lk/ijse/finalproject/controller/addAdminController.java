package lk.ijse.finalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.ijse.finalproject.DTO.UserDTO;
import lk.ijse.finalproject.model.Usermodel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class addAdminController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private TextField email;

    @FXML
    private TextField password;
    @FXML
    private TextField code;

    @FXML
    private TextField username;

    @FXML
    private Button verificateButton;

    int x;
    @FXML
    void oncodetyping(KeyEvent event) {
        String q = code.getText();
        if (x == Integer.parseInt(q)) {
            addButton.setDisable(false);
        }else{
        }
    }

    @FXML
    void onAddButtonClick(ActionEvent event) {
        String x = username.getText();
        String y = password.getText();
        String z = email.getText();

        UserDTO user=new UserDTO(x,y,z);
        boolean a=Usermodel.savUser(user);
        System.out.println(a);
        Stage stage=(Stage) addButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    void onVerificateClick(ActionEvent event) {

        String to = email.getText();
        String from = "amxdhnanditha@gmail.com";
        String host = "smtp.gmail.com";
        String username = "amxdhnanditha@gmail.com";
        String password = "gnhv lcmt oogq nppk";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Verification Code to SignUp");
            Random r=new Random();
            int z=r.nextInt(100000);
            x=z;
            message.setText(String.valueOf(z));

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setDisable(true);
    }
}
