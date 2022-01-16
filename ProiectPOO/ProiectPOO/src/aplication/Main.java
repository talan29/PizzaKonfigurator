package aplication;

import Database.MainDatabase;
import Database.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //User Endi=new User("EndiTrainer","1234", "Male",20,"trainer");

        MainDatabase myDB = new MainDatabase();
        //User userToBeInserted = new User("Popescu", "1234"); //id is auto incremental
        //myDB.insertUser(Endi);
        //System.out.println((myDB.getUser(1)));
        //System.out.println((myDB.getAllUser()));

        Parent root = FXMLLoader.load(getClass().getResource("../scenes/Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
