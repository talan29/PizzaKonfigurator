package controllers;

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

public class ControllerMainCustomer implements Initializable {

    @FXML
    private Text Title;

    @FXML
    private Button feedback;

    @FXML
    private Button trainer;

    @FXML
    private Button info;

    @FXML
    private Button subscription;

    @FXML
    private Button newsubscription;


    @FXML
    private AnchorPane AnchorSwitch;

    private AnchorPane AnchorSwitchNew;

    @Override
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
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneInfo.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void newsubscriptionAction() {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneNew.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feedbackAction(){
            try {
                AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneFeedb.fxml"));
                setNode(AnchorSwitchNew);
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void trainerAction() {
            try {
                AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneTrainer.fxml"));
                setNode(AnchorSwitchNew);
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void infoAction() {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneInfo.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscriptionAction() {
        try {
            AnchorSwitchNew = FXMLLoader.load(getClass().getResource("../scenes/CustomerPaneSubscription.fxml"));
            setNode(AnchorSwitchNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
