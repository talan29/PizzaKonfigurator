package controllers;

import Database.MainDatabase;
import Database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerCustomerPaneFeedb {

    MainDatabase database = new MainDatabase();

    @FXML
    private RadioButton R1;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton R2;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton R3;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton R4;

    @FXML
    private RadioButton r4;

    @FXML
    private RadioButton R5;

    @FXML
    private RadioButton r5;

    @FXML
    private Button submit;

    @FXML
    private Button SUBMIT;

    @FXML
    private Button Back;

    @FXML
    private TextField gymFeed;

    @FXML
    private TextField trainerFeed;

    public void submitAction(ActionEvent actionEvent) {
        User insertRateing = new User("trainer",trainerFeed.getText(),Rateing());
        database.insertRateing(insertRateing);
        Stage stage = (Stage) SUBMIT.getScene().getWindow();
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Thanks for the feedback!");
        alert.show();
    }

    public void SUBMITAction(ActionEvent actionEvent) {
        User insertRateing = new User("gym",gymFeed.getText(),Rateing());
        database.insertRateing(insertRateing);
        Stage stage = (Stage) submit.getScene().getWindow();
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Thanks for the feedback!");
        alert.show();
    }

    public int Rateing(){
        int star = 0;
        if (r1.isSelected()||R1.isSelected()){
            star=1;
        }
        else if (r2.isSelected()||R2.isSelected()){
            star=2;
        }
        else if (r3.isSelected()||R3.isSelected()){
            star=3;
        }
        else if (r4.isSelected()||R4.isSelected()){
            star=4;
        }
        else if (r5.isSelected()||R5.isSelected()){
            star=5;
        }
        return star;
    }
}
