package controllers;
import Database.MainDatabase;
import Database.User;

import com.sun.deploy.panel.RuleSetViewerDialog;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.BaseNode;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable{

    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


    private MainDatabase handler = new MainDatabase();
    private PreparedStatement pst;
    private static ControllerLogin instance;

    public ControllerLogin(){
        instance = this;
    }

    public static ControllerLogin getInstance(){
        return instance;
    }

    public String username(){
        return username.getText();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setStyle("-fx-background-color: #900C3F;-fx-text-inner-color: #000000;");
        password.setStyle("-fx-background-color: #900C3F;-fx-text-inner-color: #000000;");
    }
    @FXML
    public void loginAction()
    {
        PauseTransition pt =new PauseTransition();
        pt.setDuration(Duration.seconds(1));
        pt.setOnFinished(ev -> {
            String sql= "SELECT * FROM user WHERE Username = ? AND Password = ?";
            try (Connection connection = DriverManager.getConnection(handler.getHost(), handler.getUsername(), handler.getPassword()))
                 {
                     pst = connection.prepareStatement(sql);
                     pst.setString(1, username.getText());
                     pst.setString(2, password.getText());
                     ResultSet rs = pst.executeQuery();
                     if(rs.next())
                     {
                         User user = handler.getUser(username.getText());

                            if (user.getType().equals("customer")){
                                 System.out.println("login succesfull");
                                 Stage stagelogin = (Stage) login.getScene().getWindow();
                                 stagelogin.close();
                                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/MainCustomer.fxml"));
                                 Parent root = (Parent) fxmlLoader.load();
                                 Stage login = new Stage();
                                 login.setScene(new Scene(root));
                                 login.show();
                                 login.setResizable(false);
                            }
                            else if (user.getType().equals("trainer")){
                                System.out.println("login succesfull");
                                Stage stagelogin = (Stage) login.getScene().getWindow();
                                stagelogin.close();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/MainTrainer.fxml"));
                                Parent root = (Parent) fxmlLoader.load();
                                Stage login = new Stage();
                                login.setScene(new Scene(root));
                                login.show();
                                login.setResizable(false);
                            }
                            else if (user.getType().equals("manager")){
                                System.out.println("login succesfull");
                                Stage stagelogin = (Stage) login.getScene().getWindow();
                                stagelogin.close();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/MainManager.fxml"));
                                Parent root = (Parent) fxmlLoader.load();
                                Stage login = new Stage();
                                login.setScene(new Scene(root));
                                login.show();
                                login.setResizable(false);
                            }
                     }
                     else {
                         Alert alert = new Alert(Alert.AlertType.ERROR);
                         alert.setHeaderText(null);
                         alert.setContentText("Username or password is not correct!");
                         alert.show();
                         System.out.println("Username or password is not correct");
                     }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pt.play();
        System.out.print(username.getText());
        System.out.print(password.getText());
    }
    @FXML
    public void signupAction() {

        Stage stagelogin = (Stage) login.getScene().getWindow();
        stagelogin.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/SignUP.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage signup = new Stage();
            signup.setScene(new Scene(root));
            signup.show();
            signup.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void forgotAction() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Too bad! :'(");
        alert.show();
    }


}
