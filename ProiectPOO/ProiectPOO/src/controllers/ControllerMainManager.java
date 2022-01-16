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

public class ControllerMainManager implements Initializable {

    @FXML
    private Text Title;

    @FXML
    private Button trainer;

    @FXML
    private Button working;

    @FXML
    private Button details;

    @FXML
    private AnchorPane AnchorSwitch;

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
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/ManagerPaneGym.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void detailsAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/ManagerPaneGym.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void trainerAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/ManagerPaneTrainer.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void workingAction(ActionEvent actionEvent) {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/ManagerPaneHours.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
