package controllers;

import Database.MainDatabase;
import Database.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerManagerPaneGym implements Initializable {

    MainDatabase database = new MainDatabase();
    private String host = "jdbc:mysql://localhost/database";
    private String username = "root";
    private String password = "29022000";

    ObservableList list= FXCollections.observableArrayList();
    ObservableList list2= FXCollections.observableArrayList();

    @FXML
    private Button submit;

    @FXML
    private TextField equipmentField;

    @FXML
    private TextField quantityField;

    @FXML
    private ListView<String> EquipmentList;

    @FXML
    private ListView<String> QuantityList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EquipmentList();
        QuantityList();
    }

    public void EquipmentList() {
        try (Connection con = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = statementUsers(con);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name=rs.getString("Equipment");
                list.addAll(name);
            }
            EquipmentList.getItems().addAll(list);
            EquipmentList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void QuantityList(){
        try (Connection con = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = statementUsers(con);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name=rs.getString("Quantity");
                list2.addAll(name);
            }
            QuantityList.getItems().addAll(list2);
            QuantityList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement statementUsers(Connection con) throws SQLException {
        String sql = "SELECT Equipment, Quantity FROM gym";
        PreparedStatement statement = con.prepareStatement(sql);
        return statement;
    }

    public void submitAction(ActionEvent actionEvent) {
        User trainerToBeInserted = new User(equipmentField.getText(),quantityField.getText());
        database.insertGym(trainerToBeInserted);
    }
}
