package recipe;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RecipeManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("recipe.fxml"));
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();

        String name = "Meatballs";
        Ingredient ings = new Ingredient("Salt", "1 Tbsp");
        Directions direct = new Directions(3);
        CookTime ct = new CookTime(15);
        Review rv = new Review(4);

        Recipe mb = new Recipe(name, ings, direct, ct, rv);

        recipes.add(mb);

        ListView<Recipe> recipeList = new ListView<>(recipes);

        recipeList.setCellFactory(param -> new ListCell<Recipe>() {
            @Override
            protected void updateItem(Recipe recp, boolean empty) {
                super.updateItem(recp, empty);

                if (empty || recp == null || recp.toString() == null) {
                    setText(null);
                } else {
                    setText(recp.toString());
                }
            }
        });
        primaryStage.setTitle("RecipeManager");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
