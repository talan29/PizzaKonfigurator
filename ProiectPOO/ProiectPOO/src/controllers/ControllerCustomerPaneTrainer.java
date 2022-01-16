package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class ControllerCustomerPaneTrainer implements Initializable {

    private String host = "jdbc:mysql://localhost/database";
    private String username = "root";
    private String password = "29022000";

    ObservableList list= FXCollections.observableArrayList();


    @FXML
    private ListView<String> TrainerList;

    @FXML
    private AnchorPane AnchorSwitch;

    @FXML
    private TextField Description;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        UserList("trainer");
    }


    public void UserList(String trainer) {
        try (Connection con = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = statementUsers(con, trainer);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name=rs.getString("username");
                list.addAll(name);
            }
            TrainerList.getItems().addAll(list);
            TrainerList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement statementUsers(Connection con,String trainer) throws SQLException {
            String sql = "SELECT Username FROM user WHERE Type = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, trainer);
            return statement;
    }

     public void Selected(javafx.scene.input.MouseEvent mouseEvent){
        String select=TrainerList.getSelectionModel().getSelectedItem();
        if(select!=null) {
            System.out.println(select + "portocala");
            this.Description.setText(select);
        }
     }
}
