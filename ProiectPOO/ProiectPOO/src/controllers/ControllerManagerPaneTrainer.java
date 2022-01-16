package controllers;

import Database.MainDatabase;
import Database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerManagerPaneTrainer implements Initializable {

    MainDatabase database = new MainDatabase();

    @FXML
    private TextField passwordField;

    @FXML
    private Button submit;

    @FXML
    private TextField fullName;

    @FXML
    private RadioButton female;

    @FXML
    private TextArea Info;

    @FXML
    private TextField age;

    @FXML
    private RadioButton male;

    @FXML
    private TextField usernameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void submitAction(ActionEvent actionEvent) {
        System.out.println("Submit successfull");
        User userToBeInserted = new User(usernameField.getText(), passwordField.getText(), getGender(), Integer.parseInt(age.getText()), "trainer");
        database.insertUser(userToBeInserted);

        User trainerToBeInserted = new User(usernameField.getText(),fullName.getText(), Info.getText());
        database.insertTrainer(trainerToBeInserted);
    }

    public String getGender(){
        String gen = "";
        if (male.isSelected()){
            gen="Male";
        }
        else if (female.isSelected()){
            gen="Female";
        }
        return gen;
    }

    public void maleAction(ActionEvent actionEvent) {
    }

    public void femaleAction(ActionEvent actionEvent) {
    }

}
