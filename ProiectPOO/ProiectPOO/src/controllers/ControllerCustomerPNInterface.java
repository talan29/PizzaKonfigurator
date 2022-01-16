package controllers;

import Database.MainDatabase;
import Database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerCustomerPNInterface {

    MainDatabase database = new MainDatabase();

    @FXML
    private Button Back;

    @FXML
    private Button Submit;

    @FXML
    private TextField PeriodField;

    @FXML
    private TextField TrainerField;

    @FXML
    private TextArea DescriptionField;

    @FXML
    private TextField DateField;

    public void initialize(URL location, ResourceBundle resources){
        setPeriod(ControllerCustomerPaneNew.getInstance().period());
    }
    public void setPeriod(String period){
        this.PeriodField.setText(period+" dadad");
    }
    
    public void SubmitAction() {
        User tobeinserted = new User(PeriodField.getText(),DateField.getText(),TrainerField.getText(),DescriptionField.getText());
        database.insertSubscription(tobeinserted);
        System.out.println("Submit done!");
    }

    public void BackAction(ActionEvent actionEvent) {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/MainCustomer.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage scene = new Stage();
            scene.setScene(new Scene(root));
            scene.show();
            scene.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
