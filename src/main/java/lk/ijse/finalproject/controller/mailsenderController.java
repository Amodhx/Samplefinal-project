package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.finalproject.DTO.ClassDTO;
import lk.ijse.finalproject.DTO.StudentDTO;
import lk.ijse.finalproject.model.Classmodel;
import lk.ijse.finalproject.model.Studentmodel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class mailsenderController implements Initializable {

    @FXML
    private JFXButton canselbutton;

    @FXML
    private JFXComboBox combo;

    @FXML
    private TextField grade;

    @FXML
    private JFXButton sendbutton;

    @FXML
    private JFXTextArea text;

    @FXML
    void oncanselclick(ActionEvent event) {
        Stage stage = (Stage) sendbutton.getScene().getWindow();
        stage.close();

    }

    public  void sendMail(String mail,String textmail){
        String to = mail;
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
            message.setSubject("Mail form ExcelAcme");
            message.setText(textmail);


            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @FXML
    void onsendclick(ActionEvent event) {
        ArrayList<StudentDTO> ar = Studentmodel.getAllStudents();
        ArrayList<String> mails = new ArrayList<>();
        for (int i = 0; i < ar.size(); i++) {
            mails.add(ar.get(i).getEmail());
        }
        String te = text.getText();
        for (int i = 0; i < mails.size(); i++) {
            sendMail(mails.get(i),te);

        }
        Stage stage = (Stage) sendbutton.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ClassDTO>  br= Classmodel.getAllClasses();
        ObservableList<String> st = FXCollections.observableArrayList();
        for (int i = 0; i < br.size(); i++) {
            st.add(br.get(i).getSubject());
        }
        combo.setItems(st);;
    }
}
