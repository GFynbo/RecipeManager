package recipe;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.util.List;

public class RecipeManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("recipe.fxml"));

        primaryStage.setTitle("RecipeManager");

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
