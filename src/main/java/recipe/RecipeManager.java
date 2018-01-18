package recipe;

import java.io.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;

public class RecipeManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("recipe.fxml"));
        Parent root = loader.load();
        RecipeController recipeController = loader.getController();

        primaryStage.setTitle("RecipeManager");

        primaryStage.setScene(new Scene(root));
        primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                recipeController.saveChanges();
            }
        });
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
