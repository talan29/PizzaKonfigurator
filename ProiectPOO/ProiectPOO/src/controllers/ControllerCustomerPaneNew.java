package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerCustomerPaneNew {


    @FXML
    private Button month1;

    @FXML
    private Button custom;

    @FXML
    private Button month6;

    @FXML
    private Button year1;

    private String period;
    private static ControllerCustomerPaneNew instance;

    public ControllerCustomerPaneNew(){
        instance = this;
    }

    public static ControllerCustomerPaneNew getInstance(){
        return instance;
    }


    public void month1Action(ActionEvent actionEvent) {
        Stage stageNew = (Stage) month1.getScene().getWindow();
        stageNew.close();
        period="1 Month Subscription";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/CustomerPNInterface.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage subs = new Stage();
            subs.setScene(new Scene(root));
            subs.show();
            subs.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void month6Action(ActionEvent actionEvent) {
        Stage stageNew = (Stage) month6.getScene().getWindow();
        stageNew.close();
        //period="6 Month Subscription";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/CustomerPNInterface.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage subs = new Stage();
            subs.setScene(new Scene(root));
            subs.show();
            subs.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void year1Action(ActionEvent actionEvent) {
        Stage stageNew = (Stage) year1.getScene().getWindow();
        stageNew.close();
        //period="1 Year Subscription";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/CustomerPNInterface.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage subs = new Stage();
            subs.setScene(new Scene(root));
            subs.show();
            subs.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void customAction(ActionEvent actionEvent) {
        Stage stageNew = (Stage) custom.getScene().getWindow();
        stageNew.close();
        //period="";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/CustomerPNInterface.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage subs = new Stage();
            subs.setScene(new Scene(root));
            subs.show();
            subs.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String period() {
        return period;
    }
}
