package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainTrainer implements Initializable {

    @FXML
    private AnchorPane AnchorSwitch;

    @FXML
    private Text Title;

    @FXML
    private Button diet;

    @FXML
    private Button plan;

    @FXML
    private Button notifications;

    private AnchorPane AnchorSwitchNew;

    public void initialize(URL location, ResourceBundle resources){
        createPage();
        setUsername(ControllerLogin.getInstance().username());
    }


    public void setUsername(String user){
        this.Title.setText("Welcome, "+user);
    }



    private void setNode(Node node){
        AnchorSwitch.getChildren().clear();
        AnchorSwitch.getChildren().add((Node) node);
    }

    private void createPage() {

        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/TrainerPaneNotification.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void notificationsAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/TrainerPaneNotification.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void planAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/TrainerPanePlan.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dietAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/TrainerPaneDiet.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
