package controllers;
import Database.MainDatabase;
import Database.User;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSignUP implements Initializable{

    MainDatabase database = new MainDatabase();

    @FXML
    private Button signup;

    @FXML
    private ToggleGroup gender;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private TextField age;

    @FXML
    private Button login;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setStyle("-fx-background-color: #900C3F;-fx-text-inner-color: #000000;");
        password.setStyle("-fx-background-color: #900C3F;-fx-text-inner-color: #000000;");
        age.setStyle("-fx-background-color: #900C3F;-fx-text-inner-color: #000000;");
    }

    @FXML
    public void signupAction()
    {
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e -> {
            System.out.println("Signup successfull");
            User userToBeInserted = new User(username.getText(), password.getText(), getGender(), Integer.parseInt(age.getText()), "customer"); //Convertesc int
            database.insertUser(userToBeInserted);
        });
        pt.play();
    }

    public void maleAction() {
    }

    public void femaleAction() {
    }

    public void loginAction() {
        Stage stagesignup = (Stage) signup.getScene().getWindow();
        stagesignup.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/Login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage login = new Stage();
            login.setScene(new Scene(root));
            login.show();
            login.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}

