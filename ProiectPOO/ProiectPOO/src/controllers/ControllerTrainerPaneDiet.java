package controllers;

import Database.MainDatabase;
import Database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerTrainerPaneDiet {
    MainDatabase database = new MainDatabase();

    @FXML
    private TextArea Diet;

    @FXML
    private Button submit;

    @FXML
    private TextField Username;



    public void submitAction(ActionEvent actionEvent) {
        User trainerToBeInserted = new User(Username.getText(), Diet.getText());
        database.insertDiet(trainerToBeInserted);
    }
}
